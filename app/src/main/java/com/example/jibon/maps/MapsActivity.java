package com.example.jibon.maps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.jibon.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {


        map = googleMap;

        LatLng Dhaka = new LatLng(23.8103, 90.4125);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(Dhaka);
        markerOptions.title("Dhaka");
        //set the icon
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        //display the current loction as marker
        map.addMarker(markerOptions);


        //map.addMarker(new MarkerOptions().position(Dhaka).title("Dhaka"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Dhaka));

        //the more the zoom
        map.animateCamera(CameraUpdateFactory.zoomTo(10));

    }
}