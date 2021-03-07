package com.example.lescapteurs;

import android.app.Activity;
import android.content.Context;
import android.graphics.Camera;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

public class LocalisationActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.localisation);

        LocationManager manager =(LocationManager)getSystemService(Context.LOCATION_SERVICE);
        List<String> fournisseurs = manager.getAllProviders();
        for (String f : fournisseurs) {
            Toast.makeText(getApplicationContext(), "" + f, Toast.LENGTH_SHORT).show();
            if (f.equals(LocationManager.GPS_PROVIDER)){
                // TODO
            }
        }
    }
}


