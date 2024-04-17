package com.mastercoding.marketapp.itemApi;

import com.mastercoding.marketapp.ItemList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ItemApi {
    @GET("items")
    Call<ItemList> getItems();

}
