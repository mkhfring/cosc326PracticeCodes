package com.mastercoding.marketapp.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.mastercoding.marketapp.ItemList;
import com.mastercoding.marketapp.itemApi.ItemApi;
import com.mastercoding.marketapp.retrofitInstance.RetroFitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemRepository {
    ItemApi itemApi;

    public ItemRepository() {
        itemApi = new RetroFitInstance()
                .getRetrofitInstance()
                .create(ItemApi.class);
    }
    public LiveData<ItemList> getItemList(){
        Call<ItemList> response = itemApi.getItems();
        MutableLiveData<ItemList> data = new MutableLiveData<>();
        response.enqueue(new Callback<ItemList>() {
            @Override
            public void onResponse(Call<ItemList> call, Response<ItemList> response) {
                ItemList list = response.body();
                Log.v("onResponse", "" + response.code());
                data.setValue(list);
            }

            @Override
            public void onFailure(Call<ItemList> call, Throwable throwable) {
                Log.v("onFailure", throwable.getMessage());

            }

        });
        return data;
    }
}
