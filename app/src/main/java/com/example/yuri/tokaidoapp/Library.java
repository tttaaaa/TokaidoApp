package com.example.yuri.tokaidoapp;

import android.location.LocationManager;

/**
 * Created by bambo on 2016/03/28.
 */
public class Library {

    public static String[3] GPS(LocationManager mLocationManager,LocationListener mLOcationListner){
        DOUBLE [] GPS ={0.0,0.0};
        boolean isNetworkEnabled = mLocationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (isNetworkEnabled) {
            mLocationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    LOCATION_UPDATE_MIN_TIME,
                    LOCATION_UPDATE_MIN_DISTANCE,
                    ｍLocationListner
            );
            Geocoder   mGeocoder = new Geocoder(getApplicationContext(), Locale.JAPAN);
            Location location = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (location != null) {
                double longitude = location.getLongitude();
                double latitude = location.getLatitude();
                GPS[0] =longitude.toString;
                GPS[1] =latitude.toString;
                //GeoCoder を用いて地名を検索
                StringBuffer buff = new StringBuffer();
                try {
                    List<Address> addrs = mGeocoder.getFromLocation(latitude, longtitude, 1);
                    for(Address addr : addrs){
                        //地名を取得して，文字列に連結する
                        int index = addr.getMaxAddressLineIndex();
                        for(int i = 0; i <= index; i++){
                            buff.append(addr.getAddressLine(i));
                            buff.append("\n");
                        }
                        buff.append("\n");
                        String city = buff.toString;
                    }
                } catch(IOException e){
                    Log.e("HelloLocationActivity", e.toString());
                }
                ｝
                GPS[2] = city;
                return GPS ;
            }


        }
