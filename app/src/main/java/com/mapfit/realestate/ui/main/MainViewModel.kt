package com.mapfit.realestate.ui.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.mapfit.realestate.data.NeighborhoodRepo
import com.mapfit.realestate.model.Neighborhood
import com.mapfit.realestate.model.RealEstate
import com.mapfit.realestate.ui.common.Event

class MainViewModel : ViewModel() {

    private val boundaryRepo = NeighborhoodRepo()

    val neighborhoodEvent = MutableLiveData<Neighborhood>()
    val realEstateEvent = MutableLiveData<RealEstate>()
    val regionPolygons = boundaryRepo.getNeighborhoods()
    val backNavigationEvent = MutableLiveData<Event<Any>>()

    fun onNeighborhoodSelected(neighborhood: Neighborhood) =
        neighborhoodEvent.postValue(neighborhood)

    fun onRealEstateSelected(realEstate: RealEstate) = realEstateEvent.postValue(realEstate)

    fun onBackNavigation() = backNavigationEvent.postValue(Event(Any()))

}