package com.first.clevertapassign

import android.app.Application
import com.clevertap.android.sdk.CleverTapAPI

class CleverTapSDKIntergration: Application() {

    override fun onCreate() {
        super.onCreate()
        CleverTapAPI.setDebugLevel(CleverTapAPI.LogLevel.DEBUG)
    }
}