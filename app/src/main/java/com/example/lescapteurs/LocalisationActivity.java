package com.example.lescapteurs;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class LocalisationActivity extends Activity {
    TextView longitude, latitude;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.localisation);

        /*
        LocationManager manager =(LocationManager)getSystemService(Context.LOCATION_SERVICE);
        List<String> fournisseurs = manager.getAllProviders();
        for (String f : fournisseurs) {
            Toast.makeText(getApplicationContext(), "" + f, Toast.LENGTH_SHORT).show();
            if (f.equals(LocationManager.GPS_PROVIDER)){
                // TODO
            }
        }*/

        longitude = (TextView) findViewById(R.id.)

    }
}