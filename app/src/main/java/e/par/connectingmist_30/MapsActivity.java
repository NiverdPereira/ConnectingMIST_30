package e.par.connectingmist_30;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final LatLng PERTH = new LatLng(-31.952854, 115.857342);
    private static final LatLng SYDNEY = new LatLng(-33.87365, 151.20689);
    private static final LatLng BRISBANE = new LatLng(-27.47093, 153.0235);


    private Marker mPerth;
    private Marker mSydney;
    private Marker mBrisbane;

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


        // Add some markers to the map, and add a data object to each marker.

        LatLng MIST = new LatLng(23.837679, 90.358072);
        LatLng lala=new LatLng(23.838135, 90.357928);
        LatLng cafe=new LatLng(23.838312, 90.358758);
        LatLng playground=new LatLng(23.837517, 90.359666);
        LatLng stationary=new LatLng(23.836779, 90.358861);
        LatLng cp=new LatLng(23.838366, 90.358685);
        LatLng osmany=new LatLng(23.838135, 90.357928);
        LatLng academic=new LatLng(23.838005, 90.358916);
        LatLng atm=new LatLng(23.838670, 90.358564);
        float zoomLevel = 16.0f;
        mMap.addMarker(new MarkerOptions().position(MIST).title("MIST"));
        //mMap.addMarker(new MarkerOptions().position(lala).title("lala"));
        mMap.addMarker(new MarkerOptions().position(cafe).title("MIST Cafeteria"));
        mMap.addMarker(new MarkerOptions().position(playground).title("MIST Playground"));
        mMap.addMarker(new MarkerOptions().position(stationary).title("MIST Stationary"));
        mMap.addMarker(new MarkerOptions().position(cp).title("CP Five Star"));
        mMap.addMarker(new MarkerOptions().position(osmany).title("Osmany Hall"));
        mMap.addMarker(new MarkerOptions().position(academic).title("MIST Admin Building"));
        mMap.addMarker(new MarkerOptions().position(atm).title("Trust ATM Booth"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MIST,zoomLevel));
    }
}
