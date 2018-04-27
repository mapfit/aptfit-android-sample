package com.mapfit.realestate.model

import android.arch.lifecycle.MutableLiveData
import com.mapfit.realestate.ui.common.Event

data class RealEstate(
    var name: String,
    var imageUrl: String,
    var price: String,
    var address: String,
    var neighborhood: String,
    var bedroomCount: Int,
    var bathroomCount: Int,
    var area: Int,
    var availableDate: String,
    var isActive: MutableLiveData<Event<Boolean>> = MutableLiveData()
)