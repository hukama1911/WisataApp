package com.lulunaurahmapswisata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.lulunaurahmapswisata.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)


    }
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        // Ambil data latitude dan longitude
        val latitude = intent.getDoubleExtra("latitude", 0.0)
        val longitude = intent.getDoubleExtra("longitude", 0.0)
        val namawisata = intent.getStringExtra("namaWisata")
        val lokasiWisata = LatLng(latitude, longitude)

        // Tambahkan marker dan pindahkan kamera ke lokasi wisata
        mMap.addMarker(MarkerOptions().position(lokasiWisata).title(namawisata))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasiWisata, 15f))

    }
}
