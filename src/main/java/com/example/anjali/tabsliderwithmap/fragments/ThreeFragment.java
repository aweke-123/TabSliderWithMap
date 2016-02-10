package com.example.anjali.tabsliderwithmap.fragments;

import android.util.Log;

import com.example.anjali.tabsliderwithmap.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Random;


public class ThreeFragment extends SupportMapFragment implements
        OnMapReadyCallback {

    private final LatLng london = new LatLng(51.528308, -0.3817765);

    private static final String ARG_SECTION_NUMBER = "section_number";

    private GoogleMap mMap;
    private Marker marker;
    private Random mRandom = new Random(1984);


    public ThreeFragment() {
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.d("MyMap", "onResume");
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {

        if (mMap == null) {

            Log.d("MyMap", "setUpMapIfNeeded");

            getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.d("MyMap", "onMapReady");
        mMap = googleMap;
        setUpMap();
    }

    private void setUpMap() {

        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMapToolbarEnabled(false);

        for (int i=0;i<40;i++){
            mMap.addMarker(new MarkerOptions().position(position()));
            mMap.addMarker(new MarkerOptions()
                    .position(position())
                    .title("yo")
                    .snippet("yo yo Honey Singh..!!")
                    .icon(BitmapDescriptorFactory
                            .fromResource(R.mipmap.ic_launcher)));
        }



        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(london, 15));

        mMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
    }

    private LatLng position() {
        return new LatLng(random(51.6723432, 51.38494009999999), random(0.148271, -0.3514683));
    }

    private double random(double min, double max) {
        return mRandom.nextDouble() * (max - min) + min;
    }

}
