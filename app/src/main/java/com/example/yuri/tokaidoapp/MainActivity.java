package com.example.yuri.tokaidoapp;

import android.app.Service;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements LocationListener{

    private static final String TAG = MainActivity.class.getSimpleName();
    // 更新時間(目安)
    private static final int LOCATION_UPDATE_MIN_TIME = 0;
    // 更新距離(目安)
    private static final int LOCATION_UPDATE_MIN_DISTANCE = 1;

    private LocationManager mLocationManager;

    public Location location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

     public void getshindan(View view){
         mLocationManager = (LocationManager) this.getSystemService(Service.LOCATION_SERVICE);

         requestLocationUpdates();





         Geocoder mGeocoder = new Geocoder(getApplicationContext(), Locale.JAPAN);

         double longitude = location.getLongitude();
         double latitude = location.getLatitude();
         StringBuffer buff = new StringBuffer();
         try {
             List<Address> addrs = mGeocoder.getFromLocation(latitude, longitude, 1);
             for(Address addr : addrs){
                 //地名を取得して，文字列に連結する
                 int index = addr.getMaxAddressLineIndex();
                 for(int i = 0; i <= index; i++){
                     buff.append(addr.getAddressLine(i));
                     buff.append("\n");
                 }
                 buff.append("\n");
                 String city = buff.toString();
                 Log.e("GGGGGGGGGGGGGetCity", city);
             }
         } catch(IOException e){
             Log.e("HelloLocationActivity", e.toString());
         }

         Intent intent = new Intent(this,Hantei_mae.class);
         startActivity(intent);
     }


    public void requestLocationUpdates(){
        boolean isNetworkEnabled = mLocationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (isNetworkEnabled) {
            mLocationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    LOCATION_UPDATE_MIN_TIME,
                    LOCATION_UPDATE_MIN_DISTANCE,
                    this
            );


        } else {
            Log.e("errror", "GPS is error" );
        }

        location = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (location == null) {
            Log.e("errror", "Location=null " );
        }
    }



    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}

