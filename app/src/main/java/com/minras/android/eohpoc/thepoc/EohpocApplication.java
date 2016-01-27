package com.minras.android.eohpoc.thepoc;

import android.app.Application;

import com.estimote.sdk.BeaconManager;


public class EohpocApplication extends Application {
    private BeaconManager beaconManager;
    private String defaultUuid = "B9407F30-F5F8-466E-AFF9-25556B57FE6D";

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
