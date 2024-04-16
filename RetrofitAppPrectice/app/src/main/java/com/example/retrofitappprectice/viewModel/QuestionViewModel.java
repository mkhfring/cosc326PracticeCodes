package com.example.retrofitappprectice.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.retrofitappprectice.model.QuestionList;
import com.example.retrofitappprectice.repository.QuestionRepository;

import java.util.List;

public class QuestionViewModel extends ViewModel {
    LiveData<QuestionList> questionList;
    QuestionRepository repository = new QuestionRepository();

    public QuestionViewModel() {
        this.questionList = repository.getQuestionList();
    }

    public LiveData<QuestionList> getQuestionList() {
        return questionList;
    }
}
