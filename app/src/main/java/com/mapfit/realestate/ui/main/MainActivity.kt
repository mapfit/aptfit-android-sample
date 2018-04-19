package com.mapfit.realestate.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.mapfit.realestate.R
import com.mapfit.realestate.model.Neighborhood
import com.mapfit.realestate.util.openProjectPage
import com.mapfit.realestate.util.setCompoundDrawables
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var navigationController: NavigationController
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        init()
    }

    private fun init() {
        navigationController = NavigationController(supportFragmentManager, R.id.container)
        navigationController.openMapView()

        imgGithub.setOnClickListener { openProjectPage(this) }

        btnMapList.setOnClickListener {
            val newState = when (btnMapList.tag ?: ScreenState.MAP_VIEW) {
                ScreenState.LIST_VIEW -> ScreenState.MAP_VIEW
                ScreenState.MAP_VIEW -> ScreenState.LIST_VIEW
                ScreenState.DETAIL_VIEW -> ScreenState.MAP_VIEW
                else -> ScreenState.MAP_VIEW
            }

            changeScreen(newState)
        }

        viewModel.neighborhoodEvent.observe(this, Observer {
            it?.let { onNeighborhoodSelected(it) }
        })

        viewModel.realEstateEvent.observe(this, Observer {
            it?.let { changeScreen(ScreenState.DETAIL_VIEW) }
        })
    }

    /**
     * Changes the text and icon of the screen state button.
     *
     * @param newState expected screen state
     */
    private fun changeScreen(newState: ScreenState) {
        val (text, resourceId) = when (newState) {
            ScreenState.LIST_VIEW -> {
                navigationController.openListView()
                Pair(getString(R.string.map_view), R.drawable.ic_map_24dp)
            }
            ScreenState.MAP_VIEW -> {
                navigationController.openMapView()
                Pair(getString(R.string.list_view), R.drawable.ic_list_24dp)
            }
            ScreenState.DETAIL_VIEW -> {
                navigationController.openDetailView()
                Pair(getString(R.string.map_view), R.drawable.ic_map_24dp)
            }
        }

        btnMapList.tag = newState
        btnMapList.text = text
        btnMapList.setCompoundDrawables(end = ContextCompat.getDrawable(this, resourceId))
    }

    /**
     * Changes screen state accordingly to the given neighborhood.
     *
     * @param neighborhood to be displayed
     */
    private fun onNeighborhoodSelected(neighborhood: Neighborhood) {
        txtAvailability.text = neighborhood.name
        txtAvailability.alpha = 0f
        txtAvailability.animate().alphaBy(1f).setDuration(200).start()
        btnMapList.visibility = View.VISIBLE
        btnMapList.animate().alphaBy(1f).setDuration(200).start()
    }


    enum class ScreenState { LIST_VIEW, MAP_VIEW, DETAIL_VIEW }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            finish()
        } else {
            super.onBackPressed()
        }
    }
}
