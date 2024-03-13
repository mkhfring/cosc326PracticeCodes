package com.example.inclasscityadapterpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listView);
        ArrayList<CityModel> cities = new ArrayList<>();
        CityModel vancouver = new CityModel("Van", "10,000", R.drawable.vancouver);
        CityModel kelowna = new CityModel("Kelowna", "1000", R.drawable.kelowna);
        cities.add(vancouver);
        cities.add(kelowna);
        CustomAdapter adapter = new CustomAdapter(getApplicationContext(), cities);
        listView.setAdapter(adapter);
    }
}