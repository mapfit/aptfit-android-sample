package com.mapfit.realestate.model

data class RealEstate(
    var name: String,
    var imageUrl: String,
    var price: String,
    var address: String,
    var neighborhood: String,
    var bedroomCount: Int,
    var bathroomCount: Int,
    var area: Int,
    var availableDate: String
)