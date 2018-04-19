package com.mapfit.realestate.model

import com.mapfit.android.geometry.LatLng

data class Neighborhood(
    var name: String,
    var polygon: List<List<LatLng>>,
    var realEstates: List<RealEstate>
)