package com.example.retrofitappprectice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.database.Observable;
import android.os.Bundle;
import android.util.Log;

import com.example.retrofitappprectice.databinding.ActivityMainBinding;
import com.example.retrofitappprectice.model.QuestionList;
import com.example.retrofitappprectice.viewModel.QuestionViewModel;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        QuestionViewModel viewModel = new ViewModelProvider(this)
                .get(QuestionViewModel.class);
        viewModel.getQuestionList().observe(this, new Observer<QuestionList>() {
            @Override
            public void onChanged(QuestionList questions) {
                mainBinding.txtQuestion.setText(questions.get(0).getQuestion());
                mainBinding.radio1.setText(questions.get(0).getOption1());
                mainBinding.radio2.setText(questions.get(0).getOption2());


            }
        });
    }
}