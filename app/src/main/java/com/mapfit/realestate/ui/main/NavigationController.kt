package com.mapfit.realestate.ui.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.mapfit.realestate.ui.detail.RealEstateDetailFragment
import com.mapfit.realestate.ui.list.RealEstateListFragment
import com.mapfit.realestate.ui.map.MapFragment

/**
 * Navigation controller for [MainActivity].
 */
class NavigationController(
    private val fragmentManager: FragmentManager,
    private val containerId: Int
) {

    private val mapFragment by lazy { MapFragment() }
    private val realEstateListFragment by lazy { RealEstateListFragment() }
    private val realEstateDetailFragment by lazy { RealEstateDetailFragment() }

    fun openMapView() {
        changeFragment(mapFragment)
    }

    fun openListView() {
        changeFragment(realEstateListFragment)
    }

    fun openDetailView() {
        changeFragment(realEstateDetailFragment)
    }

    private fun changeFragment(fragment: Fragment) {
        val backStateName = fragment.javaClass.name

        val fragmentPopped = fragmentManager.popBackStackImmediate(backStateName, 0)

        if (!fragmentPopped) {
            fragmentManager.beginTransaction()
                .setCustomAnimations(
                    android.R.animator.fade_in,
                    android.R.animator.fade_out
                )
                .replace(containerId, fragment)
                .addToBackStack(backStateName)
                .commit()
        }
    }
}