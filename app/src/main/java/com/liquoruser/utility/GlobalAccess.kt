package com.liquoruser.utility

import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.widget.Toast
import java.util.*


class GlobalAccess {

    companion object
    {
        fun displayMsg(context: Context, msg: String) {
            displayMsg(context, msg, Toast.LENGTH_SHORT)
        }

        fun displayMsg(context: Context, msg: String, length: Int) {
            Toast.makeText(context, msg, length).show()
        }

        fun getCompleteAddressFromLatLong(context: Context, latitude: Double, longitude: Double) : String
        {
            val geocoder: Geocoder
            val addresses: List<Address>
            geocoder = Geocoder(context, Locale.getDefault())

            addresses = geocoder.getFromLocation(
                latitude,
                longitude,
                1
            ) // Here 1 represent max location result to returned, by documents it recommended 1 to 5


            val address: String = addresses[0].getAddressLine(0) // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()

            val city: String = addresses[0].getLocality()
            val state: String = addresses[0].getAdminArea()
            val country: String = addresses[0].getCountryName()
            val postalCode: String = addresses[0].getPostalCode()
            val knownName: String = addresses[0].getFeatureName()

            return address
        }
    }
}