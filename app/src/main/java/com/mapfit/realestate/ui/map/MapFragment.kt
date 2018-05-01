package com.mapfit.realestate.ui.map

import android.annotation.SuppressLint
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearSnapHelper
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mapfit.android.MapTheme
import com.mapfit.android.MapfitMap
import com.mapfit.android.OnMapReadyCallback
import com.mapfit.android.annotations.Marker
import com.mapfit.android.annotations.Polygon
import com.mapfit.android.annotations.callback.OnMarkerAddedCallback
import com.mapfit.android.annotations.callback.OnMarkerClickListener
import com.mapfit.android.annotations.callback.OnPolygonClickListener
import com.mapfit.android.geometry.LatLng
import com.mapfit.realestate.R
import com.mapfit.realestate.model.Neighborhood
import com.mapfit.realestate.model.RealEstate
import com.mapfit.realestate.ui.common.Event
import com.mapfit.realestate.ui.common.RealEstateAdapter
import com.mapfit.realestate.ui.main.MainViewModel
import com.mapfit.realestate.ui.widget.PriceMarkerBitmapDrawable
import com.mapfit.realestate.util.computeOffsetToPoint
import com.mapfit.realestate.util.openProjectPage
import kotlinx.android.synthetic.main.fragment_map.*
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch

@SuppressLint("ResourceType")
class MapFragment : Fragment() {

    companion object {
        private const val ANIMATION_DURATION = 250L
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var mapfitMap: MapfitMap
    private lateinit var realEstateAdapter: RealEstateAdapter
    private lateinit var realEstateLayoutManager: LinearLayoutManager
    private lateinit var selectionJob: Job

    private val neighborhoods = mutableListOf<Neighborhood>()
    private val neighborhoodHashMap = HashMap<Neighborhood, Polygon>()
    private val realEstateHashMap = HashMap<RealEstate, Marker>()
    private var selectedPolygon: Polygon? = null
    private var selectedNeighborhood: Neighborhood? = null
    private var selectedRealEstate: RealEstate? = null
    private var selectedMarker: Marker? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (!::viewModel.isInitialized) {
            viewModel = ViewModelProviders
                .of(activity!!)
                .get(MainViewModel::class.java)

        }

        init()
    }

    private fun init() {
        mapView.getMapAsync(MapTheme.MAPFIT_GRAYSCALE, object : OnMapReadyCallback {
            override fun onMapReady(mapfitMap: MapfitMap) {
                this@MapFragment.mapfitMap = mapfitMap

                initMap()

                if (neighborhoods.isEmpty()) {
                    initObservers()
                } else {
                    addNeighborhoodsOnMap(neighborhoods)
                }

                val selectedNeighborhood = viewModel.neighborhoodEvent.value

                //  restore the state of previously selected neighborhood
                if (selectedNeighborhood != null) {
                    onNeighborhoodSelected(selectedNeighborhood)
                }
            }
        })

        initRealEstateRecycler()
    }

    private fun initRealEstateRecycler() {
        realEstateLayoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)

        realEstateAdapter = RealEstateAdapter(
            { realEstate -> viewModel.onRealEstateSelected(realEstate) },
            { openProjectPage(activity!!) },
            RealEstateAdapter.ItemType.HORIZONTAL
        )

        recyclerView.apply {
            this@apply.adapter = realEstateAdapter
            this@apply.layoutManager = realEstateLayoutManager

            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                        val view = snapHelper.findSnapView(layoutManager)
                        val position = layoutManager.getPosition(view)

                        val realEstate = selectedNeighborhood?.realEstates?.get(position)
                        onEstateSelected(realEstate = realEstate)
                    }
                }
            })
        }
    }

    private fun initMap() {
        mapfitMap.apply {
            setZoom(12f, 500)
            setCenter(LatLng(lat = 40.73748242049333, lng = -73.95733284034074), 500)

            setOnPolygonClickListener(object : OnPolygonClickListener {
                override fun onPolygonClicked(selectedPolygon: Polygon) {
                    neighborhoodHashMap.forEach { neighborhood, polygon ->
                        if (polygon == selectedPolygon) {
                            onNeighborhoodSelected(neighborhood)
                            return@forEach
                        }
                    }
                }
            })

            setOnMarkerClickListener(object : OnMarkerClickListener {
                override fun onMarkerClicked(marker: Marker) {
                    onEstateSelected(marker)
                }
            })
        }
    }

    private fun initObservers() {
        viewModel.regionPolygons.observe(this, Observer {
            it?.let { it1 ->
                neighborhoods.addAll(it1)
                addNeighborhoodsOnMap(neighborhoods)
            }
        })
    }

    /**
     * Changes styling of the marker and it's building polygon while centering the map to it.
     * Clicking the same marker will center the marker while clicking another one changes
     * previously selected to inactive style.
     *
     * @param marker that is being selected
     */
    private fun onEstateSelected(marker: Marker? = null, realEstate: RealEstate? = null) {
        val chosenMarker: Marker? = marker ?: realEstate?.let { getMarkerForRealEstate(it) }
        val estate: RealEstate? = realEstate ?: marker?.let { getRealEstateForMarker(it) }


        // change the marker and building colors
        if (selectedMarker == null || selectedMarker != chosenMarker) {
            chosenMarker?.apply {
                setIcon(PriceMarkerBitmapDrawable(activity!!, estate!!.price, true))
                buildingPolygon?.let { changePolygonState(it, true) }
            }

            selectedMarker?.apply {
                selectedRealEstate?.let {
                    PriceMarkerBitmapDrawable(
                        activity!!,
                        it.price,
                        false
                    )
                }?.let { setIcon(it) }

                buildingPolygon?.let { changePolygonState(it, false) }
            }
        }


        // change recyclerview position to the selected marker's real estate
        selectedNeighborhood
            ?.takeIf { marker != null }
            ?.let {
                val position = it.realEstates.indexOf(estate)

                if (recyclerView.visibility == View.VISIBLE) {
                    realEstateLayoutManager.smoothScrollToPosition(
                        recyclerView,
                        RecyclerView.State(),
                        position
                    )

                } else {
                    realEstateLayoutManager.scrollToPosition(position)
                }
            }


        // set map center and zoom level
        if (!::selectionJob.isInitialized || selectionJob.isCompleted) {

            selectionJob = launch {
                mapfitMap.apply {

                    chosenMarker?.let {
                        val center = computeOffsetToPoint(it.getPosition(), 55.0, 180.0)
                        setCenter(center, ANIMATION_DURATION)
                    }
                    setZoom(18f, ANIMATION_DURATION)
                    setRotation(0f)
                    delay(ANIMATION_DURATION)
                }
            }

            if (estate != selectedRealEstate || selectedRealEstate == null) {
                estate?.isActive?.value = Event(true)
                selectedRealEstate?.isActive?.value = Event(false)
            }

        }

        selectedMarker = chosenMarker
        selectedRealEstate = estate

        recyclerView.visibility = View.VISIBLE
    }

    private fun getMarkerForRealEstate(realEstate: RealEstate): Marker? {
        var marker: Marker? = null
        realEstateHashMap.filter { it.key == realEstate }.forEach { _, markr -> marker = markr }
        return marker
    }

    private fun getRealEstateForMarker(marker: Marker): RealEstate? {
        var realEstate: RealEstate? = null
        realEstateHashMap.filter { it.value == marker }.forEach { estate, _ -> realEstate = estate }
        return realEstate
    }

    private fun onNeighborhoodSelected(neighborhood: Neighborhood) {
        val selectedPolygon = neighborhoodHashMap[neighborhood]

        selectedPolygon
            ?.takeIf { onPolygonSelected(it) }
            ?.let {
                realEstateAdapter.replaceItems(neighborhood.realEstates)
                recyclerView.visibility = View.GONE

                viewModel.onNeighborhoodSelected(neighborhood)

                mapfitMap.apply {
                    neighborhoodHashMap[neighborhood]?.let {
                        setLatLngBounds(it.getLatLngBounds(), 0.8f)
                    }
                }

                removePreviousRealEstates()
                addRealEstatesToMap(neighborhood.realEstates)
                selectedNeighborhood = neighborhood
            }
    }

    private fun removePreviousRealEstates() {
        realEstateHashMap.forEach { _, marker -> marker.remove() }
        realEstateHashMap.clear()
    }

    @SuppressLint("ResourceType")
    private fun onPolygonSelected(polygon: Polygon): Boolean {
        val differentPolygons = selectedPolygon == null || selectedPolygon != polygon
        if (selectedPolygon != null && selectedPolygon != polygon) {
            changePolygonState(selectedPolygon!!, true)
        }

        if (differentPolygons) {
            changePolygonState(polygon, false)
        }

        selectedPolygon = polygon

        return differentPolygons
    }

    private fun addRealEstatesToMap(realEstates: List<RealEstate>) {
        launch {
            realEstates.forEach {
                mapfitMap.addMarker(
                    it.address,
                    true,
                    onMarkerAddedCallback(it)
                )
            }
        }
    }

    private fun onMarkerAddedCallback(realEstate: RealEstate): OnMarkerAddedCallback {
        return object : OnMarkerAddedCallback {
            override fun onMarkerAdded(marker: Marker) {
                realEstateHashMap[realEstate] = marker
                initMarkerStyle(marker, realEstate)
            }

            override fun onError(exception: Exception) {

            }
        }
    }

    private fun initMarkerStyle(
        marker: Marker,
        realEstate: RealEstate
    ) {
        marker.apply {
            setTitle("") // disables place info on click

            launch {
                setIcon(
                    PriceMarkerBitmapDrawable(
                        this@MapFragment.context!!,
                        realEstate.price,
                        false
                    )
                )

                markerOptions.apply {
                    width = 84
                    height = 48
                }
            }

            buildingPolygon?.let { changePolygonState(it, false) }
        }
    }

    /**
     * Adds neighborhood polygons on the map.
     */
    private fun addNeighborhoodsOnMap(neighborhoods: List<Neighborhood>) {
        neighborhoods.forEach {
            val polygon = mapfitMap.addPolygon(it.polygon)
            neighborhoodHashMap[it] = polygon
            changePolygonState(polygon, true)
        }
    }

    private fun changePolygonState(polygon: Polygon, blue: Boolean) {
        polygon.polygonOptions.apply {
            fillColor = if (blue) {
                getString(R.color.accentTransparent)
            } else {
                getString(R.color.darkAccentTransparent)
            }

            strokeColor = if (blue) {
                getString(R.color.colorAccent)
            } else {
                getString(R.color.darkAccent)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // clear references
        selectedPolygon = null
        neighborhoodHashMap.clear()
        realEstateHashMap.clear()
        mapView?.onDestroy()

    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

}