package com.example.roomdatabasepractice.service;

import com.example.roomdatabasepractice.model.ContactList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ContactServiceApi {
    @GET("get-contacts")
    Call<ContactList> getQuestionList(@Query("api_key") String apiKey);
}
