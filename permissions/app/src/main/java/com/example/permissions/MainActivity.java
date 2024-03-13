package com.example.permissions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_FOREGROUND_LOCATION_PERMISSION = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.mybtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("btn", "");
                if(!hasForegroundLocationPermission()){
                    Log.d("justForTest", "permission");
                    requestForegroundLocationPermission();

                }
//                requestPermission();
            }
        });

    }
    private void requestForegroundLocationPermission() {
        ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.ACCESS_COARSE_LOCATION },
                REQUEST_FOREGROUND_LOCATION_PERMISSION);
    }

    public boolean hasWritePermission(){
        return ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED;
    }
    public boolean hasForegroundLocationPermission(){
        return ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED;
    }
    public boolean hasBackgroundLocationPermission(){
        return ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_BACKGROUND_LOCATION
        ) == PackageManager.PERMISSION_GRANTED;
    }
    public void requestPermission(){
        List<String> permissionsToRequest = new ArrayList<>();
        if(!hasWritePermission()){
            permissionsToRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if(!hasForegroundLocationPermission()){
            permissionsToRequest.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        }
        if(!hasBackgroundLocationPermission()){
            permissionsToRequest.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION);
        }

        if (!permissionsToRequest.isEmpty()) {
            ActivityCompat.requestPermissions(this,
                    permissionsToRequest.toArray(new String[0]),
                    0);
        }

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_FOREGROUND_LOCATION_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission was granted, proceed with your logic
                Log.d("PermissionsRequest", "Foreground location permission granted");
            } else {
                // Permission was denied, you can inform the user and potentially retry
                Log.d("PermissionsRequest", "Foreground location permission denied");
            }
        }
    }
}