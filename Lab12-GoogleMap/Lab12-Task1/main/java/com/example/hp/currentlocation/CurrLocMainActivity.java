package com.example.hp.currentlocation;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class CurrLocMainActivity extends AppCompatActivity {

    private static final String TAG = "loc" ;
    private static final int REQUEST_LOCATION_PERMISSION = 1;
    FusedLocationProviderClient mFusedLocationClient;
    Location mLastLocation;
    double lat,lon, time;
    TextView tv;
    Address currLoc;
    Geocoder geocoder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curr_loc_main);
        tv = findViewById(R.id.textview);
        geocoder = new Geocoder(getApplicationContext(),Locale.getDefault());
        }

    public void btnclick(View v){
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_PERMISSION);
        } else {
            Log.d(TAG, "getLocation: permissions granted");
        }
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(getApplicationContext());
        mFusedLocationClient.getLastLocation().addOnSuccessListener( new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                Toast.makeText(getApplicationContext(), "Granted Success", Toast.LENGTH_SHORT);

                if (location != null) {
                    mLastLocation = location;
                    // Get the lat and long.
                    if (location != null) {
                        // Get the lat and long.
                        lat = location.getLatitude();
                        lon = location.getLongitude();
                        time = location.getTime();
                        Toast.makeText(getApplicationContext(), lat+" "+lon, Toast.LENGTH_SHORT);

                        try {
                            List<Address> addresses = geocoder.getFromLocation(lat,lon,1);
                             currLoc = addresses.get(0);
                             tv.setText(currLoc.getAddressLine(0));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    } else {
                        // Show "no location"}

                    }
                }
            }
        });

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
           switch (requestCode) {
           case REQUEST_LOCATION_PERMISSION:
               // Check if the permission is granted.
       if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
           Toast.makeText(getApplicationContext(), "Granted", Toast.LENGTH_SHORT);
           } else {
           Toast.makeText(getApplicationContext(), "Can't Run The App", Toast.LENGTH_SHORT);
                }
            }
        }


    }

