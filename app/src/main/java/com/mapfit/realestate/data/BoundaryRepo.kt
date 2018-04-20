package com.mapfit.realestate.data

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.mapfit.android.Mapfit
import com.mapfit.android.geometry.LatLng
import com.mapfit.realestate.model.GeoJson
import com.mapfit.realestate.model.Neighborhood
import com.squareup.moshi.Moshi
import kotlinx.coroutines.experimental.launch
import java.io.IOException
import java.io.InputStream


class BoundaryRepo {

    private val estateRepo = RealEstateRepo()

    fun getNeighborhoods(): LiveData<List<Neighborhood>> {
        val data = MutableLiveData<List<Neighborhood>>()
        launch {

            val geoJson = parseGeoJsonFromAssets()
            val realEstates = estateRepo.getRealEstates()

            geoJson?.let {
                var index = -1

                val neighborhoods: List<Neighborhood> =
                    geoJson.features.map { feature ->
                        index++
                        try {

                            Neighborhood(
                                feature.properties.name,
                                parseDoublesIntoLatLngs(geoJson.features[index].geometry.coordinates),
                                realEstates[index]
                            )
                        } catch (e: Exception) {
                            e.printStackTrace()
                            Neighborhood()
                        }
                    }

                data.postValue(neighborhoods)
            }
        }

        return data
    }

    private fun parseDoublesIntoLatLngs(doubles: List<List<List<List<Double>>>>): List<List<LatLng>> {
        val latLngs = mutableListOf<MutableList<LatLng>>()

        doubles.forEach {

            it.forEach {
                val outerList = mutableListOf<LatLng>()
//                val innerList =mutableListOf<LatLng>()
                it.forEach {
                    outerList.add(LatLng(it[1], it[0]))
                }
                latLngs.add(outerList)
            }

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