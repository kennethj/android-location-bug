package com.example.locationbug

import android.Manifest
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.example.locationbug.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), LocationListener
{

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val locationButton: Button = findViewById(R.id.locationButton)
        val requestButton: Button = findViewById(R.id.requestButton)
        locationButton.isEnabled = false
        val locationPermissionRequest = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            when {
                permissions.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false) -> {
                    locationButton.isEnabled = true
                    requestButton.isEnabled = false
                    print("Location permission granted")
                }
                permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                    locationButton.isEnabled = true
                    requestButton.isEnabled = false
                    print("Location permission granted")
                }
                else -> {
                    print("Location permission denied")
                }
            }
        }
        requestButton.setOnClickListener() {
            locationPermissionRequest.launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )
        }
        locationButton.setOnClickListener() {
            print("Location button clicked")
            val locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0L, 0f, this)

            val infoText: TextView = findViewById(R.id.info)
            infoText.text = "Location fetched"
        }
    }

    override fun onLocationChanged(location: Location) {
        print("Location changed")
        val infoText: TextView = findViewById(R.id.info)
        infoText.text = "Location changed"
    }
}