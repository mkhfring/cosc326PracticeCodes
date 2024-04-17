package com.mastercoding.marketapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.mastercoding.marketapp.repository.ItemRepository;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    // 1- AdapterView
    RecyclerView recyclerView;

    // 2- Data Source
    List<Item> itemList;

    // 3- Adapter
    CustomAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        itemList = new ArrayList<>();
        DrawableMap drawableMap = new DrawableMap();
        ItemRepository repo = new ItemRepository();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        repo.getItemList().observe(this, new Observer<ItemList>() {
            @Override
            public void onChanged(ItemList items) {
                for(Item item: items){
                    Log.e("currentItem", item.getItemName());
                    itemList.add(new Item(
                            drawableMap.getDrawableId(item.getImage()),
                            item.getItemName(),
                            item.getItemDesc()
                    ));

                }
                recyclerView.setLayoutManager(layoutManager);


                myAdapter = new CustomAdapter(itemList);
                recyclerView.setAdapter(myAdapter);
            }
        });

//
//        Item item1 = new Item(R.drawable.fruit, "Fruits","Fresh Fruits from the Garden");
//        Item item2 = new Item(R.drawable.vegitables, "Vegetables","Delicious Vegetables ");
//        Item item3 = new Item(R.drawable.bread,"Bakery","Bread, Wheat and Beans");
//        Item item4 = new Item(R.drawable.beverage, "Beverage","Juice, Tea, Coffee and Soda");
//        Item item5 = new Item(R.drawable.milk, "Milk", "Milk, Shakes and Yogurt");
//        Item item6 = new Item(R.drawable.popcorn,"Snacks","Pop Corn, Donut and Drinks");
//
//
//        itemList.add(item1);
//        itemList.add(item2);
//        itemList.add(item3);
//        itemList.add(item4);
//        itemList.add(item5);
//        itemList.add(item6);




//        myAdapter.setClickListener(this);



    }

//    @Override
//    public void onCLick(View v, int pos) {
//        Toast.makeText(this,
//                "You Choose: "+ itemList.get(pos).getItemName(),
//                Toast.LENGTH_SHORT).show();
//
//    }
}