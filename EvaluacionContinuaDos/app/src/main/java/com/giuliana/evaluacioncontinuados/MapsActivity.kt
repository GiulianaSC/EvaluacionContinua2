package com.giuliana.evaluacioncontinuados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.giuliana.evaluacioncontinuados.databinding.ActivityMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var binding: ActivityMapsBinding
    private lateinit var googleMap: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fragmentMap = supportFragmentManager.findFragmentById(R.id.fcv_map) as SupportMapFragment
        fragmentMap.getMapAsync(this)
    }
    override fun onMapReady(map: GoogleMap) {
        googleMap = map
        val megaplazaLocation = LatLng(-11.993455015027168, -77.06104517020441)
        googleMap.addMarker(MarkerOptions().position(megaplazaLocation).title("Megaplaza"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(megaplazaLocation, 16f))
        val terminalLocation = LatLng(-11.98153284070917, -77.05877065662267)
        googleMap.addMarker(MarkerOptions().position(terminalLocation).title("Metropolitano Terminal"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(terminalLocation, 16f))
        val municipalidadLocation = LatLng(-11.996603388572176, -77.05465078412205)
        googleMap.addMarker(MarkerOptions().position(municipalidadLocation).title("Municipalidad Independencia"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(municipalidadLocation, 16f))
    }
}