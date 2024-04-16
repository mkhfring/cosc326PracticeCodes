package com.example.retrofitappprectice.repository;

import androidx.lifecycle.LiveData;

import com.example.retrofitappprectice.model.QuestionList;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitInstance {
    String baseUrl = "http://10.0.2.2:5000/";
    public RetroFitInstance() {
    }
    public Retrofit getRetroFitInstance(){
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
