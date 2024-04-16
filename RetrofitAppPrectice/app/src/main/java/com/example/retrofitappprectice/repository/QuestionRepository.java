package com.example.retrofitappprectice.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.retrofitappprectice.model.QuestionList;
import com.example.retrofitappprectice.questionSerivce.QuestionService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionRepository {
    QuestionService questionService;

    public QuestionRepository() {
        this.questionService = new RetroFitInstance()
                .getRetroFitInstance()
                .create(QuestionService.class);
    }
    public LiveData<QuestionList> getQuestionList(){
        MutableLiveData<QuestionList> data = new MutableLiveData<>();
        Call<QuestionList> response = questionService
                .getQuestions("your_api_key");
        response.enqueue(new Callback<QuestionList>() {
            @Override
            public void onResponse(Call<QuestionList> call, Response<QuestionList> response) {
                QuestionList list = response.body();
                Log.v("onresponse", list.get(0).getQuestion());
                data.setValue(list);
            }

            @Override
            public void onFailure(Call<QuestionList> call, Throwable throwable) {
                Log.v("netError", "No response from server");

            }
        });
        return data;
    }
}
