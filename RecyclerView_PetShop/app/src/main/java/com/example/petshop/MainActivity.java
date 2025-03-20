package com.example.petshop;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView  = findViewById(R.id.recyclerView);

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(new Item(R.drawable.dog, "dog", "Buy this very cute dog."));
        itemList.add(new Item(R.drawable.seconddog, "cat", "Buy this very cute dog."));
        itemList.add(new Item(R.drawable.thirddog, "bird", "Buy this very cute dog."));
        itemList.add(new Item(R.drawable.fourthdog, "dog", "Buy this very cute dog."));
        itemList.add(new Item(R.drawable.fifthdog, "cat", "Buy this very cute dog."));
        itemList.add(new Item(R.drawable.sixthdog, "bird", "Buy this very cute dog."));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);



        CustomAdapter adapter = new CustomAdapter(itemList, this);
        recyclerView.setAdapter(adapter);

    }
}