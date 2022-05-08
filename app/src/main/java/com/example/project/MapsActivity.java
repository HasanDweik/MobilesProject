package com.example.project;

import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.project.databinding.ActivityMapsBinding;
import com.google.android.gms.tasks.OnSuccessListener;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            if(getApplicationContext().checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){

                fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {

                        // current location ,, check !! (not taking exact curr loc, so i added curr loc manually below)
                        if (location != null){
                            LatLng Home = new LatLng(location.getLatitude() , location.getLongitude());
                            MarkerOptions options = new MarkerOptions().position(Home).title("Current Location");
                            options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
                            mMap.addMarker(options);
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(Home));
                            CircleOptions circleOptions = new CircleOptions().center(Home).radius(100);
                            Circle circleOption = mMap.addCircle(circleOptions);
                        }
                    }
                });

            } else {
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION} , 0 );
            }
        }

// castrol
        LatLng total = new LatLng(33.8691369 , 35.5331626);
        mMap.addMarker(new MarkerOptions().position(total).title("total"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(total));
        CircleOptions circleOptions1 = new CircleOptions().center(total).radius(100);
        Circle circleOption1 = mMap.addCircle(circleOptions1);

// total
        LatLng castrol = new LatLng(33.8504671 , 35.5191178);
        mMap.addMarker(new MarkerOptions().position(castrol).title("castrol"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(castrol));
        CircleOptions circleOptions2 = new CircleOptions().center(castrol).radius(100);
        Circle circleOption2 = mMap.addCircle(circleOptions2);

// mobil
        LatLng mobil = new LatLng(33.8553401 , 35.5271311);
        mMap.addMarker(new MarkerOptions().position(mobil).title("mobil"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mobil));
        CircleOptions circleOptions3 = new CircleOptions().center(castrol).radius(100);
        Circle circleOption3 = mMap.addCircle(circleOptions3);


// UA
        LatLng UA = new LatLng(33.837742 , 35.537811);
        mMap.addMarker(new MarkerOptions().position(UA).title("UA"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(UA));
        CircleOptions circleOptionsUA = new CircleOptions().center(UA).radius(100);
        Circle circleOptionUA = mMap.addCircle(circleOptionsUA);


// current location (Home) , manual
        LatLng Home = new LatLng(33.781437 , 35.5505485);
        MarkerOptions optionss = new MarkerOptions().position(Home).title("Current Location");
        optionss.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
        mMap.addMarker(optionss);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Home));
        CircleOptions circleOptionsHome = new CircleOptions().center(UA).radius(100);
        Circle circleOptionHome = mMap.addCircle(circleOptionsHome);

    }
}