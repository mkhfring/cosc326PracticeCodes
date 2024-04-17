package com.mastercoding.contactsmanagerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mastercoding.contactsmanagerapp.databinding.ActivityAddNewContactBinding;

public class AddNewContactActivity extends AppCompatActivity {

    private ActivityAddNewContactBinding binding;
    private AddNewContactClickHandler handler;
    private Contacts contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact);

        contacts = new Contacts();

        binding= DataBindingUtil.setContentView(
                this,
                R.layout.activity_add_new_contact
        );


        // VIew Model
        MyViewModel myViewModel = new ViewModelProvider(this)
                .get(MyViewModel.class);


        handler = new AddNewContactClickHandler(
                contacts,
                this,
                myViewModel
        );

        binding.setContact(contacts);
        binding.setClickHandler(handler);








    }


}