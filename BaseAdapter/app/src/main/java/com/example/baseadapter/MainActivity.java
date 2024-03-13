package com.example.baseadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] countries = {"USA", "Canada", "England", "France"};
        ListView listView = findViewById(R.id.listview);
        CustomAdapter customAdapter = new CustomAdapter(this, countries);
        listView.setAdapter(customAdapter);
    }
}