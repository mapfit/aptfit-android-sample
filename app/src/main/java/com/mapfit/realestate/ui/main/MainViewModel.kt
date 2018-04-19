package com.mapfit.realestate.ui.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.mapfit.realestate.data.BoundaryRepo
import com.mapfit.realestate.model.Neighborhood
import com.mapfit.realestate.model.RealEstate
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

class MainViewModel : ViewModel() {
    private val boundaryRepo = BoundaryRepo()

    val neighborhoodEvent = MutableLiveData<Neighborhood>()
    val realEstateEvent = MutableLiveData<RealEstate>()
    val regionPolygons = boundaryRepo.getNeighborhoods()

    fun onNeighborhoodSelected(neighborhood: Neighborhood) = launch(UI) {
        neighborhoodEvent.setValue(neighborhood)
    }

    fun onRealEstateSelected(realEstate: RealEstate) = launch(UI) {
        realEstateEvent.setValue(realEstate)
    }
}