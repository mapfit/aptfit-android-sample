package com.mapfit.realestate.model


data class GeoJson(
		val type: String,
		val crs: Crs,
		val features: List<Feature>
)

data class Crs(
		val type: String,
		val properties: Properties
)


data class Feature(
		val type: String,
		val properties: Properties,
		val geometry: Geometry
)

data class Properties(
		val id: String,
		val name: String,
		val parent_id: String,
		val src: String,
		val population: String
)

data class Geometry(
		val type: String,
		val coordinates: List<List<List<List<Double>>>>
)