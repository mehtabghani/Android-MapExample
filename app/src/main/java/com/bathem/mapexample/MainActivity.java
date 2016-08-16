package com.bathem.mapexample;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapLoadedCallback {

    private GoogleMap mMap;
    LocationListFragment mListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

         mListFragment = new LocationListFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.table_frame_layout, mListFragment, "");
        fragmentTransaction.commit();
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
        mMap.setOnMapLoadedCallback(this);

    }

    @Override
    public void onMapLoaded() {

        // Add a marker in Sydney and move the camera

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);


//        LatLng karachi = new LatLng(24.886860, 67.085781);
//        mMap.addMarker(new MarkerOptions().position(karachi).title("Marker in karachi"));
//        LatLng kabul = new LatLng(24.877628, 67.154617);
//        mMap.addMarker(new MarkerOptions().position(kabul).title("Marker in kabul"));

        // Create a LatLngBounds that includes Australia.

//        LatLngBounds.Builder builder = new LatLngBounds.Builder();
//        builder.include(karachi);
//        builder.include(kabul);

          //mMap.moveCamera(CameraUpdateFactory.newLatLng(karachi));
       // mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), 5));
       //   mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(builder.build().getCenter(), 10));
    }

    public void moveCamerToLatLong(LatLng latLng) {

        mMap.addMarker(new MarkerOptions().position(latLng).title(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(10));

    }

}
