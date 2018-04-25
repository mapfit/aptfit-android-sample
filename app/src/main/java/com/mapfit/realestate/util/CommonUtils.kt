package com.mapfit.realestate.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.mapfit.android.geometry.LatLng
import java.lang.Math.*

/**
 * Opens project's Github repository on the default browser.
 */
fun openProjectPage(context: Context) {
    val url = "https://github.com/mapfit/aptfit-android"
    val urlIntent = Intent(Intent.ACTION_VIEW)
    urlIntent.data = Uri.parse(url)
    context.startActivity(urlIntent)
}

/**
 * Returns the LatLng resulting from moving a distance from an origin
 * in the specified heading (expressed in degrees clockwise from north).
 *
 * @param from     LatLng from which to start
 * @param distance in meters
 * @param heading  in degrees. clockwise from north
 */
fun computeOffsetToPoint(from: LatLng, distance: Double, heading: Double): LatLng {
    val dist = distance / 6371009 // earth's radius
    val radHeading = toRadians(heading)
    // http://williams.best.vwh.net/avform.htm#LL
    val fromLat = toRadians(from.lat)
    val fromLng = toRadians(from.lng)
    val cosDistance = cos(dist)
    val sinDistance = sin(dist)
    val sinFromLat = sin(fromLat)
    val cosFromLat = cos(fromLat)
    val sinLat = cosDistance * sinFromLat + sinDistance * cosFromLat * cos(radHeading)
    val dLng = atan2(sinDistance * cosFromLat * sin(radHeading), cosDistance - sinFromLat * sinLat)

    return LatLng(toDegrees(asin(sinLat)), toDegrees(fromLng + dLng))
}