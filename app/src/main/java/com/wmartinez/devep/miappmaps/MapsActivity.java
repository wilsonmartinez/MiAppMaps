package com.wmartinez.devep.miappmaps;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static String placeText;
    private static double lat, lng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Bundle bundle = getIntent().getExtras();
        if (bundle == null){
            return;
        }else {
            switch (bundle.getInt("place")){
                case 1:
                    placeText = "Parque Simon Bolivar";
                    break;
                case 2:
                    placeText = "Parque Jaime Duque";
                    break;
                case 3:
                    placeText = "Monserrate";
                    break;
                case 4:
                    placeText = "Plaza de Bolivar";
                    break;
            }
            lat = bundle.getDouble("latitud");
            lng = bundle.getDouble("longitud");
        }
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
        //LatLng sydney = new LatLng(-34, 151);
        LatLng lugar = new LatLng(lat, lng);
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory
                .fromResource(R.drawable.mapmarker_flag5_azure))
                .anchor(0.0f, 1.0f)
                .position(lugar)
                .title("Marker in " + placeText));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lugar));
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.moveCamera(CameraUpdateFactory.zoomTo(16));
    }
}
