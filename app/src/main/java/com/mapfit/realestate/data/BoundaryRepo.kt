package com.mapfit.realestate.data

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.mapfit.android.Mapfit
import com.mapfit.android.geometry.LatLng
import com.mapfit.realestate.model.GeoJson
import com.mapfit.realestate.model.Neighborhood
import com.mapfit.realestate.model.RealEstate
import com.squareup.moshi.Moshi
import kotlinx.coroutines.experimental.launch
import java.io.IOException
import java.io.InputStream


class BoundaryRepo {

    private val neighborhoodNames = listOf(
        "little italy",
        "east village",
        "murray hill",
        "stuyvesant town",
        "washington heights",
        "central harlem",
        "soho",
        "spanish harlem",
        "financial district",
        "tribeca",
        "morningside heights",
        "hell's kitchen",
        "flatiron district",
        "midtown west",
        "midtown east",
        "central park",
        "greenwich village",
        "battery park city",
        "chinatown",
        "lower east side",
        "gramercy",
        "west side",
        "west village",
        "inwood",
        "hamilton heights",
        "noho",
        "two bridges",
        "nolita",
        "kips bay",
        "upper east side",
        "chelsea",
        "city hall area"
    )


    fun neighborhoods(): List<List<RealEstate>> {

        val allRealEstates = mutableListOf<List<RealEstate>>()

        val littleItaly = listOf(
            RealEstate(
                "apt1",
                "https://images.unsplash.com/photo-1505873242700-f289a29e1e0f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=91b874ce453385d8867cc98ee582fee3&auto=format&fit=crop&w=1024&q=80",
                "$2,400",
                "199 Hester St, New York, NY 10013",
                "Little Italy, Manhattan",
                2,
                1,
                350,
                "July 14th, 2018"
            ),
            RealEstate(
                "apt2",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$3,200",
                "85 Wooster St, New York, NY 10012",
                "Little Italy, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            )
        )
        allRealEstates.add(littleItaly)
        val eastVillage = listOf()
        allRealEstates.add(eastVillage)
        val murrayHill = listOf()
        allRealEstates.add(murrayHill)
        val stuyvesant = listOf()
        allRealEstates.add(stuyvesant)
        val washingtonHeights = listOf()
        allRealEstates.add(washingtonHeights)
        val centralHarlem = listOf()
        allRealEstates.add(centralHarlem)
        val financialDistrict = listOf()
        allRealEstates.add(financialDistrict)
        val tribeca = listOf()
        allRealEstates.add(tribeca)
        val morningside = listOf()
        allRealEstates.add(morningside)
        val hellsKitchen = listOf()
        allRealEstates.add(hellsKitchen)
        val flatironDistrict = listOf()
        allRealEstates.add(flatironDistrict)
        val midtownWest = listOf()
        allRealEstates.add(midtownWest)
        val midtownEeast = listOf()
        allRealEstates.add(midtownEeast)
        val centralPark = listOf()
        allRealEstates.add(centralPark)
        val greenwichVillage = listOf()
        allRealEstates.add(greenwichVillage)
        val batteryParkCity = listOf()
        allRealEstates.add(batteryParkCity)
        val chinatown = listOf()
        allRealEstates.add(chinatown)
        val lowerEastSide = listOf()
        allRealEstates.add(lowerEastSide)
        val gramercy = listOf()
        allRealEstates.add(gramercy)
        val westSide = listOf()
        allRealEstates.add(westSide)
        val westVillage = listOf()
        allRealEstates.add(westVillage)
        val inwood = listOf()
        allRealEstates.add(inwood)
        val hamiltonHeights = listOf()
        allRealEstates.add(hamiltonHeights)
        val noho = listOf()
        allRealEstates.add(noho)
        val twoBridges = listOf()
        allRealEstates.add(twoBridges)
        val nolita = listOf()
        allRealEstates.add(nolita)
        val kipsBay = listOf()
        allRealEstates.add(kipsBay)
        val upperEastSide = listOf()
        allRealEstates.add(upperEastSide)
        val chelsea = listOf(
            RealEstate(
                "apt1",
                "https://images.unsplash.com/photo-1505873242700-f289a29e1e0f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=91b874ce453385d8867cc98ee582fee3&auto=format&fit=crop&w=1024&q=80",
                "$2,400",
                "57 Mercer St, New York, NY 10013",
                "Chelsea, Manhattan",
                1,
                1,
                700,
                "June 14th, 2018"
            ),
            RealEstate(
                "apt2",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$3,200",
                "85 Wooster St, New York, NY 10012",
                "Chelsea, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            )
        )
        allRealEstates.add(chelsea)
        val cityHallArea = listOf()
        allRealEstates.add(cityHallArea)

        return allRealEstates
    }


    fun getNeighborhoods(): LiveData<List<Neighborhood>> {
        val data = MutableLiveData<List<Neighborhood>>()
        launch {

            val geoJson = parseGeoJsonFromAssets()

            geoJson?.let {
                var index = -1

                val neighborhoods: List<Neighborhood> =
                    neighborhoodNames.map {
                        index++

                        try {
                            Neighborhood(
                                it,
                                parseDoublesIntoLatLngs(geoJson.features[index].geometry.coordinates),
                                emptyList()
                            )
                        } catch (e: Exception) {
                            Neighborhood(it, emptyList(), emptyList())
                        }
                    }

                data.postValue(neighborhoods)
            }
        }

        return data
    }

    private fun parseDoublesIntoLatLngs(doubles: List<List<List<Double>>>): List<List<LatLng>> {
        val latLngs = mutableListOf<MutableList<LatLng>>()

        doubles.forEach {
            val outerList = mutableListOf<LatLng>()

            it.forEach {
                outerList.add(LatLng(it[1], it[0]))
            }

            latLngs.add(outerList)
        }

        return latLngs
    }

    private fun parseGeoJsonFromAssets(): GeoJson? {
        val json = Mapfit.getContext()?.let {
            inputStreamToString(it.assets.open("nyc_regions.json"))
        }

        val moshi = Moshi.Builder().build()
        val jsonAdapter = moshi.adapter<GeoJson>(GeoJson::class.java)

        return jsonAdapter.fromJson(json)
    }

    private fun inputStreamToString(inputStream: InputStream): String =
        try {
            val bytes = ByteArray(inputStream.available())
            inputStream.read(bytes, 0, bytes.size)
            String(bytes)
        } catch (e: IOException) {
            ""
        }

}