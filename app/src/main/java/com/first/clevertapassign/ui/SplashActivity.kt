package com.first.clevertapassign.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.clevertap.android.sdk.CleverTapAPI
import com.first.clevertapassign.R
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class SplashActivity : AppCompatActivity() {
    var cleverTapDefaultInstance: CleverTapAPI? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        CleverTapAPI.setDebugLevel(CleverTapAPI.LogLevel.DEBUG);
        cleverTapDefaultInstance = CleverTapAPI.getDefaultInstance(applicationContext)
        setUser()
        cleverTapDefaultInstance?.pushEvent("Product viewed")
    }

    private fun setUser() {
        val profileUpdate = HashMap<String, Any>()
        profileUpdate["Name"] = "Ankush Yadav" // String
        profileUpdate["Identity"] = 61026032 // String or number
        profileUpdate["Email"] = "ankusyadav1004@gmail.com" // Email address of the user
        profileUpdate["Phone"] = "+91 7977115157" // Phone (with the country code, starting with +)
        profileUpdate["Gender"] = "M" // Can be either M or F
        val stuff = ArrayList<String>()
        stuff.add("bag")
        stuff.add("shoes")
        profileUpdate["MyStuff"] = stuff //ArrayList of Strings
        val otherStuff = arrayOf("Jeans", "Perfume")
        profileUpdate["MyStuff"] = otherStuff //String Array
        cleverTapDefaultInstance?.onUserLogin(profileUpdate)
    }
}