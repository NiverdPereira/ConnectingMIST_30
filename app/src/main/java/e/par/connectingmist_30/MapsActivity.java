package e.par.connectingmist_30;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import com.google.android.gms.location.LocationListener;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener{

    private GoogleMap mMap;
    Intent myIntent;
    String sss=null;
    private GoogleApiClient client;
    private LocationRequest locationRequest;
    private Location lastLocation;
    private Marker currentLocationMarker;
    private static final LatLng PERTH = new LatLng(-31.952854, 115.857342);
    private static final LatLng SYDNEY = new LatLng(-33.87365, 151.20689);
    private static final LatLng BRISBANE = new LatLng(-27.47093, 153.0235);
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    public static final int REQUEST_LOCATION_CODE = 99;
    int PROXIMITY_RADIUS = 10000;


    private Marker mPerth;
    private Marker mSydney;
    private Marker mBrisbane;
  //  Intent intent=getIntent();
//    String map_loc=intent.getStringExtra("MAP_LOC");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        myIntent=getIntent();
        if (myIntent.hasExtra("Locate")){
               sss=myIntent.getStringExtra("Locate");
        }



         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
          {
              checkLocationPermission();

            }
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
        int x=1;
        if(sss.equals("tower1"))mMap.addMarker(new MarkerOptions().position(MIST).title("MIST")).showInfoWindow();
        //mMap.addMarker(new MarkerOptions().position(lala).title("lala"));
        if(sss.equals("cafe"))mMap.addMarker(new MarkerOptions().position(cafe).title("MIST Cafeteria")).showInfoWindow();
        if(x==2)mMap.addMarker(new MarkerOptions().position(playground).title("MIST Playground")).showInfoWindow();
        if(sss.equals("stationary"))mMap.addMarker(new MarkerOptions().position(stationary).title("MIST Stationary")).showInfoWindow();
        if(sss.equals("cp"))mMap.addMarker(new MarkerOptions().position(cp).title("CP Five Star")).showInfoWindow();
        if(sss.equals("tower2"))mMap.addMarker(new MarkerOptions().position(osmany).title("MIST Tower 2")).showInfoWindow();
        if(sss.equals("admin"))mMap.addMarker(new MarkerOptions().position(academic).title("MIST Admin Building")).showInfoWindow();
        if(sss.equals("trust"))mMap.addMarker(new MarkerOptions().position(atm).title("Trust ATM Booth")).showInfoWindow();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cafe, zoomLevel));
        //mMap.setOnMyLocationButtonClickListener(onMyLocationButtonClickListener);
        //mMap.setOnMyLocationClickListener(onMyLocationClickListener);
        enableMyLocationIfPermitted();

        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.setMinZoomPreference(11);
    }

    private void enableMyLocationIfPermitted() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_FINE_LOCATION},
                    LOCATION_PERMISSION_REQUEST_CODE);
        } else if (mMap != null) {
            buildGoogleApiClient();
            mMap.setMyLocationEnabled(true);
        }
        // Creates an Intent that will load a map of San Francisco
        //Uri gmmIntentUri = Uri.parse("geo:23.838312, 90.358758");
        // Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        //mapIntent.setPackage("com.google.android.apps.maps");
        //startActivity(mapIntent);
    }

    private void showDefaultLocation() {
        Toast.makeText(this, "Location permission not granted, " +
                        "showing default location",
                Toast.LENGTH_SHORT).show();
        LatLng redmond = new LatLng(47.6739881, -122.121512);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(redmond));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode)
        {
            case REQUEST_LOCATION_CODE:
                if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) !=  PackageManager.PERMISSION_GRANTED)
                    {
                        if(client == null)
                        {
                            buildGoogleApiClient();
                        }
                        mMap.setMyLocationEnabled(true);
                    }
                }
                else
                {
                    Toast.makeText(this,"Permission Denied" , Toast.LENGTH_LONG).show();
                }
        }
    }

    private GoogleMap.OnMyLocationButtonClickListener onMyLocationButtonClickListener =
            new GoogleMap.OnMyLocationButtonClickListener() {
                @Override
                public boolean onMyLocationButtonClick() {
                    mMap.setMinZoomPreference(15);
                    return false;
                }
            };

    private GoogleMap.OnMyLocationClickListener onMyLocationClickListener =
            new GoogleMap.OnMyLocationClickListener() {
                @Override
                public void onMyLocationClick(@NonNull Location location) {

                    mMap.setMinZoomPreference(12);

                    CircleOptions circleOptions = new CircleOptions();
                    circleOptions.center(new LatLng(location.getLatitude(),
                            location.getLongitude()));

                    circleOptions.radius(200);
                    circleOptions.fillColor(Color.RED);
                    circleOptions.strokeWidth(6);

                    mMap.addCircle(circleOptions);
                }
            };
    protected synchronized void buildGoogleApiClient()
    {
        client = new GoogleApiClient.Builder(this).addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this).addApi(LocationServices.API).build();
        client.connect();
    }

    @Override
    public void onLocationChanged(Location location) {
        lastLocation=location;
        if(currentLocationMarker!=null){
            currentLocationMarker.remove();
        }
        LatLng ltlg=new LatLng(location.getLatitude(),location.getLongitude());
        MarkerOptions markeroptions=new MarkerOptions();
        markeroptions.position(ltlg);
        markeroptions.title("Current Location");
        markeroptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        currentLocationMarker=mMap.addMarker(markeroptions);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ltlg));
        mMap.animateCamera(CameraUpdateFactory.zoomBy(16.0f));
        if(client!=null){
            LocationServices.FusedLocationApi.removeLocationUpdates(client,this);
        }

    }



    @Override
    public void onConnected(@Nullable Bundle bundle) {
        locationRequest=new LocationRequest();
        locationRequest.setInterval(1000);
        locationRequest.setFastestInterval(1000);
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(client, locationRequest, this);
        }

    }

    public boolean checkLocationPermission()
    {
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)  != PackageManager.PERMISSION_GRANTED )
        {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.ACCESS_FINE_LOCATION))
            {
                ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.ACCESS_FINE_LOCATION },REQUEST_LOCATION_CODE);
            }
            else
            {
                ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.ACCESS_FINE_LOCATION },REQUEST_LOCATION_CODE);
            }
            return false;

        }
        else
            return true;
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
