package com.example.roomdatabasepractice.ViewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.roomdatabasepractice.RetrofitInstance.RetrofitInstance;
import com.example.roomdatabasepractice.model.ContactList;
import com.example.roomdatabasepractice.service.ContactServiceApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContactViewModel extends ViewModel {
    ContactServiceApi serviceApi;

    public ContactViewModel() {
        this.serviceApi = new RetrofitInstance()
                .getRetrofitInstance().create(ContactServiceApi.class);

    }
    public LiveData<ContactList> getContactList(){
        Call<ContactList> response = serviceApi.getQuestionList(
                "your_api_key"
        );
        MutableLiveData data = new MutableLiveData ();
        response.enqueue(new Callback<ContactList>() {
            @Override
            public void onResponse(Call<ContactList> call, Response<ContactList> response) {
                ContactList contacts = response.body();
                Log.v("response", "response status: " + response.code());
                data.setValue(contacts);

            }

            @Override
            public void onFailure(Call<ContactList> call, Throwable throwable) {
                Log.v("netError", "" + throwable.getMessage());

            }
        });

        return data;
    }
}
