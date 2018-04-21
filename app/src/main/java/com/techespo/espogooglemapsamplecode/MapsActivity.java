package com.techespo.espogooglemapsamplecode;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ArrayList<LatLng> markerLocationsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
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

        // Add a marker in Sydney and move the camera
        LatLng india = new LatLng(28.6412929,77.1027683);
        mMap.addMarker(new MarkerOptions().position(india).title("Marker in india").icon(BitmapDescriptorFactory.fromResource(R.mipmap.map_marker)));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(india));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(india, 16.0f));
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        mMap.addPolyline(new PolylineOptions().geodesic(true)
                .add(new LatLng(-33.866, 151.195))  // Sydney
                .add(new LatLng(-18.142, 178.431))  // Fiji
                .add(new LatLng(21.291, -157.821))  // Hawaii
                .add(new LatLng(37.423, -122.091))
                .add(new LatLng(-33.866, 151.195))  // Mountain View
        );

        LatLng l1 = new LatLng(28.6412929,77.1027683);
        LatLng l2 = new LatLng(28.6412929,77.1027683);
        LatLng l3 = new LatLng(28.6509848,77.1124175);
        LatLng l4 = new LatLng(28.6508153,77.1091023);
        markerLocationsList =  new ArrayList<LatLng>();
        markerLocationsList.add(l1);
        markerLocationsList.add(l2);
        markerLocationsList.add(l3);
        markerLocationsList.add(l4);

        for(int i=0;i<markerLocationsList.size();i++){
            mMap.addMarker(new MarkerOptions().position(markerLocationsList.get(i)).title("Marker in india").icon(BitmapDescriptorFactory.fromResource(R.mipmap.map_marker)));

        }

    }
}
