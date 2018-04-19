package com.mapfit.realestate.model

data class GeoJson(
		val type: String,
		val source: String,
		val features: List<Feature>
)

data class Feature(
		val type: String,
		val properties: Properties,
		val geometry: Geometry
)

data class Properties(
		val style: String
)

data class Geometry(
		val type: String,
		val coordinates: List<List<List<Double>>>
)