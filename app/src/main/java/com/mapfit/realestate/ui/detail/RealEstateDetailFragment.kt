package com.mapfit.realestate.ui.detail

import android.annotation.SuppressLint
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mapfit.android.MapfitMap
import com.mapfit.android.OnMapReadyCallback
import com.mapfit.android.annotations.Marker
import com.mapfit.android.annotations.MarkerOptions
import com.mapfit.android.annotations.PolygonOptions
import com.mapfit.android.annotations.callback.OnMarkerAddedCallback
import com.mapfit.realestate.R
import com.mapfit.realestate.model.Neighborhood
import com.mapfit.realestate.model.RealEstate
import com.mapfit.realestate.ui.main.MainViewModel
import com.mapfit.realestate.util.GlideApp
import com.mapfit.realestate.util.openProjectPage
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.widget_apt_attributes.*
import kotlinx.android.synthetic.main.widget_mapfit_footer.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.channels.BroadcastChannel
import kotlinx.coroutines.experimental.launch

class RealEstateDetailFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var mapChannel: BroadcastChannel<MapfitMap>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)

        init()
        initMap()
    }

    private fun init() {
        mapChannel = BroadcastChannel(1)

        txtStartBuilding.setOnClickListener { openProjectPage(activity!!) }
        btnBack.setOnClickListener { viewModel.onBackNavigation() }

        viewModel.realEstateEvent.observe(this, Observer {
            it?.let {
                launch {
                    displayRealEstate(it)
                    displayRealEstateMap(it, mapChannel)
                }
            }
        })

        viewModel.neighborhoodEvent.observe(this@RealEstateDetailFragment, Observer {
            it?.let { launch { displayNeighborhood(it, mapChannel) } }
        })
    }

    private fun initMap() {
        mapView.getMapAsync(customTheme = "mapfit-custom-day.yaml",
            onMapReadyCallback = object : OnMapReadyCallback {
                override fun onMapReady(mapfitMap: MapfitMap) {

                    // broadcast mapfitMap instance
                    launch { mapChannel.send(mapfitMap) }

                    mapfitMap.getMapOptions().apply {
                        isZoomControlVisible = true
                        isPanEnabled = false
                    }
                }
            })
    }

    private fun displayRealEstate(realEstate: RealEstate) = launch(UI) {
        GlideApp.with(this@RealEstateDetailFragment)
            .load(realEstate.imageUrl)
            .into(imgHero)

        txtAddress.text = realEstate.address
        txtNeighborhood.text = realEstate.neighborhood
        txtPrice.text = realEstate.price
        txtBed.text = getString(R.string.bedroom_count, realEstate.bedroomCount)
        txtBath.text = getString(R.string.bathroom_count, realEstate.bathroomCount)
        txtArea.text = getString(R.string.apt_area, realEstate.area)
        txtAvailability.text = getString(R.string.available, realEstate.availableDate)
    }

    private suspend fun displayRealEstateMap(
        realEstate: RealEstate,
        mapChannel: BroadcastChannel<MapfitMap>
    ) {
        val mapfitMap = mapChannel.openSubscription().receive()

        mapfitMap.addMarker(
            MarkerOptions()
                .streetAddress(realEstate.address)
                .addBuildingPolygon(true)
            ,
            object : OnMarkerAddedCallback {
                override fun onMarkerAdded(marker: Marker) {
                    marker.title = ""

                    mapfitMap.apply {
                        setCenter(marker.position, 200)
                        setZoom(18f, 200)
                    }
                }

                override fun onError(exception: Exception) {
                    exception.printStackTrace()
                }
            }
        )
    }

    @SuppressLint("ResourceType")
    private suspend fun displayNeighborhood(
        neighborhood: Neighborhood,
        mapChannel: BroadcastChannel<MapfitMap>
    ) {
        val mapfitMap = mapChannel.openSubscription().receive()
        mapfitMap.addPolygon(
            PolygonOptions()
                .points(neighborhood.polygon)
                .fillColor(getString(R.color.darkAccentTransparent))
                .strokeColor(getString(R.color.darkAccent))
        )
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }
}