package com.mapfit.realestate

import android.app.Application
import com.mapfit.android.Mapfit

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Mapfit.getInstance(this, getString(R.string.mapfit_api_key))
    }
}