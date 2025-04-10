package com.example.roomdatabasepractice.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Contacts {

    @SerializedName("contact_name")
    @Expose
    String name;



    @Expose
    String email;

    public Contacts( String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Contacts() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
