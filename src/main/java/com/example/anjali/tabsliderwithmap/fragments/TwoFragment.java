package com.example.anjali.tabsliderwithmap.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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


public class TwoFragment extends SupportMapFragment implements
        OnMapReadyCallback {

    private final LatLng HAMBURG = new LatLng(53.558, 9.927);

    private static final String ARG_SECTION_NUMBER = "section_number";

    private GoogleMap mMap;
    private Marker marker;
    private Random mRandom = new Random(1984);

    public TwoFragment() {
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

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(HAMBURG, 150));

        mMap.animateCamera(CameraUpdateFactory.zoomTo(150), 2000, null);
    }

    private LatLng position() {
        return new LatLng(random(53.558, 53.5585678), random(9.927, 9.9279090));
    }

    private double random(double min, double max) {
        return mRandom.nextDouble() * (max - min) + min;
    }

}
