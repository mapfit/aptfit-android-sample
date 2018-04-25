package com.mapfit.realestate.ui.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.mapfit.realestate.data.NeighborhoodRepo
import com.mapfit.realestate.model.Neighborhood
import com.mapfit.realestate.model.RealEstate
import com.mapfit.realestate.ui.common.SingleLiveEvent
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

class MainViewModel : ViewModel() {
    private val boundaryRepo = NeighborhoodRepo()

    val neighborhoodEvent = MutableLiveData<Neighborhood>()
    val realEstateEvent = MutableLiveData<RealEstate>()
    val regionPolygons = boundaryRepo.getNeighborhoods()
    val backNavigationEvent = SingleLiveEvent<Any>()

    fun onNeighborhoodSelected(neighborhood: Neighborhood) = launch(UI) {
        neighborhoodEvent.setValue(neighborhood)
    }

    fun onRealEstateSelected(realEstate: RealEstate) = launch(UI) {
        realEstateEvent.setValue(realEstate)
    }

    fun onBackNavigation() {
        backNavigationEvent.setValue(Any())

    }
}