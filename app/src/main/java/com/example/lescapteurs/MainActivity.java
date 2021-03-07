package com.example.lescapteurs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonCam = (Button)findViewById(R.id.btPhoto);
        buttonCam.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CameraActivity.class);
                startActivity(i);
            }
        });

        Button buttonLoca = (Button)findViewById(R.id.btLoca);
        buttonLoca.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, LocalisationActivity.class);
                startActivity(i);
            }
        });

        Button buttonOri = (Button)findViewById(R.id.btOri);
        buttonOri.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, OrientationActivity.class);
                startActivity(i);
            }
        });
    }



}