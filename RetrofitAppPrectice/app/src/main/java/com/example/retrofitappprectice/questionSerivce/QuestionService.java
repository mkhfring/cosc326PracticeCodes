package com.example.retrofitappprectice.questionSerivce;

import com.example.retrofitappprectice.model.QuestionList;
import com.example.retrofitappprectice.model.Questions;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface QuestionService {
    @GET("get-questions")
    Call<QuestionList> getQuestions(@Query("api_key")String apiKey);
}
