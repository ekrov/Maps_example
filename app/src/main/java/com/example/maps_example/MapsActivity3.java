package com.example.maps_example;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity3 extends AppCompatActivity  implements
        GoogleMap.OnMapClickListener,
        OnMapReadyCallback {

    private GoogleMap mMap;
    private LatLng latLng;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps3);

        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager()
                        .findFragmentById(R.id.mapClick);
        mapFragment.getMapAsync(this);
    }



    private void enableLocation() {
        if (mMap != null) {
            if (latLng != null) {
                mMap.clear();
                mMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title("Choosen location"));
            }
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,
                    12));
        }
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMapClickListener(this);
        enableInitialLocation();

    }

    private void enableInitialLocation() {
        if (mMap != null) {
            try {
                List<Address> address = new
                        Geocoder(this).getFromLocationName("Portugal", 1);
                if (address == null) {
                    Toast.makeText(this, "Not found!",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Address loc = address.get(0);
                    LatLng pos = new LatLng(loc.getLatitude(),
                            loc.getLongitude());
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(pos,
                            4));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onMapClick(LatLng latLng) {
        this.latLng = latLng;
        Toast.makeText(this, latLng.latitude + " " + latLng.longitude,
                Toast.LENGTH_SHORT).show();
        enableLocation();
    }


}