package com.mapfit.realestate.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.mapfit.realestate.R
import com.mapfit.realestate.model.Neighborhood
import com.mapfit.realestate.ui.detail.RealEstateDetailFragment
import com.mapfit.realestate.ui.list.RealEstateListFragment
import com.mapfit.realestate.ui.map.MapFragment
import com.mapfit.realestate.util.openProjectPage
import com.mapfit.realestate.util.setCompoundDrawables
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var navigationController: NavigationController
    private lateinit var viewModel: MainViewModel

    enum class ScreenState { LIST_VIEW, MAP_VIEW, DETAIL_VIEW }

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

        btnChangeScreen.setOnClickListener {
            val newState = when (it.tag ?: ScreenState.MAP_VIEW) {
                ScreenState.LIST_VIEW -> ScreenState.MAP_VIEW
                ScreenState.MAP_VIEW -> ScreenState.LIST_VIEW
                ScreenState.DETAIL_VIEW -> ScreenState.MAP_VIEW
                else -> ScreenState.MAP_VIEW
            }

            changeScreen(newState,true)
        }

        viewModel.neighborhoodEvent.observe(this, Observer {
            it?.let { onNeighborhoodSelected(it) }
        })

        viewModel.realEstateEvent.observe(this, Observer {
            it?.let { changeScreen(ScreenState.DETAIL_VIEW, true) }
        })

        viewModel.backNavigationEvent.observe(this, Observer {
            it?.let {
                onBackPressed()
            }
        })
    }

    /**
     * Changes the text and icon of the screen state button.
     *
     * @param newState expected screen state
     */
    private fun changeScreen(newState: ScreenState, navigate: Boolean) {
        val (newText, resourceId) = when (newState) {
            ScreenState.LIST_VIEW -> {
                if (navigate) navigationController.openListView()
                Pair(getString(R.string.map_view), R.drawable.ic_map_24dp)
            }
            ScreenState.MAP_VIEW -> {
                if (navigate) navigationController.openMapView()
                Pair(getString(R.string.list_view), R.drawable.ic_list_24dp)
            }
            ScreenState.DETAIL_VIEW -> {
                if (navigate) navigationController.openDetailView()
                Pair("", 0)
            }
        }

        val isDetailState = newState == ScreenState.DETAIL_VIEW

        btnChangeScreen.apply {
            visibility = if (isDetailState) View.GONE else View.VISIBLE
            tag = newState
            text = newText

            if (!isDetailState) {
                setCompoundDrawables(
                    end = ContextCompat.getDrawable(
                        this@MainActivity,
                        resourceId
                    )
                )
            }
        }
    }

    /**
     * Changes screen state accordingly to the given neighborhood.
     *
     * @param neighborhood to be displayed
     */
    private fun onNeighborhoodSelected(neighborhood: Neighborhood) {
        txtNeighborhood.apply {
            text = neighborhood.name
            alpha = 0f
            animate().alphaBy(1f).setDuration(200).start()
        }

        btnChangeScreen.apply {
            visibility = View.VISIBLE
            animate().alphaBy(1f).setDuration(200).start()
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            finish()
        } else {
            super.onBackPressed()

            when (navigationController.getCurrentFragment()) {
                is MapFragment -> changeScreen(ScreenState.MAP_VIEW, false)
                is RealEstateListFragment -> changeScreen(ScreenState.LIST_VIEW, false)
            }
        }
    }
}
