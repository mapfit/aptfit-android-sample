package com.mapfit.realestate.util

import android.content.Context
import android.content.Intent
import android.net.Uri

/**
 * Opens project's Github repository on the default browser.
 */
fun openProjectPage(context: Context) {
    val url = "https://github.com/mapfit/store-locator-android-sample"
    val urlIntent = Intent(Intent.ACTION_VIEW)
    urlIntent.data = Uri.parse(url)
    context.startActivity(urlIntent)
}