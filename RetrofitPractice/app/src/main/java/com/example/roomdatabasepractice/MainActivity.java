package com.example.roomdatabasepractice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatabasepractice.ViewModel.ContactViewModel;
import com.example.roomdatabasepractice.model.Contacts;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    MyAdapter adapter;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        ArrayList<Contacts> contactList = new ArrayList<Contacts>();

        ContactViewModel viewModel = new ViewModelProvider(this)
                .get(ContactViewModel.class);


        viewModel.getContactList().observe(
                this,
                new Observer<List<Contacts>>() {
                    @Override
                    public void onChanged(List<Contacts> contacts) {
                        contactList.clear();
                        for(Contacts c: contacts){
                            contactList.add(c);

                        }
                        adapter.notifyDataSetChanged();
                    }
                }

        );
        adapter= new MyAdapter(contactList);
        recyclerView.setAdapter(adapter);


    }
}