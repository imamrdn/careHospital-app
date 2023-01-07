package com.example.carehospital_app;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.carehospital_app.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng hospital1 = new LatLng(-7.768414317381166, 110.37348492575882);
        mMap.addMarker(new MarkerOptions().position(hospital1).title("RSUP Dr.Sardjito"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(hospital1));

        LatLng hospital2 = new LatLng(-7.800527903281889, 110.3623322545951);
        mMap.addMarker(new MarkerOptions().position(hospital2).title("RS PKU Muhammadiyah"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(hospital2));

        LatLng hospital3 = new LatLng(-7.776973231044184, 110.376172354595);
        mMap.addMarker(new MarkerOptions().position(hospital3).title("RS Umum Panti Rapih"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(hospital3));

        LatLng hospital4 = new LatLng(-7.825625844955445, 110.37795295274316);
        mMap.addMarker(new MarkerOptions().position(hospital4).title("RSUD Kota Yogyakarta"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(hospital4));

        LatLng hospital5 = new LatLng(-7.783830544699, 110.37764778157894);
        mMap.addMarker(new MarkerOptions().position(hospital5).title("RS Bethesda Yogyakarta"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(hospital5));
    }
}