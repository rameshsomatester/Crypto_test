package com.example.crypto_test

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_click_me = findViewById(R.id.TvForKey) as TextView
        btn_click_me.setOnClickListener {
            val googleAPI = GoogleApiAvailability.getInstance()
            val result = googleAPI.isGooglePlayServicesAvailable(this)
            val PLAY_SERVICES_RESOLUTION_REQUEST= 9000
            if (result != ConnectionResult.SUCCESS) {
                if (googleAPI.isUserResolvableError(result)) {
                    //prompt the dialog to update google play
                    googleAPI.getErrorDialog(this, result, PLAY_SERVICES_RESOLUTION_REQUEST).show()
                }
            } else {
                Toast.makeText(this@MainActivity, "google play services up to date.", Toast.LENGTH_LONG).show()
            } //google play up to date

        }
    }
}
