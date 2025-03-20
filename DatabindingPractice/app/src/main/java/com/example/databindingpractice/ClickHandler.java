package com.example.databindingpractice;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

public class ClickHandler {
    Context context;

    public ClickHandler(Context context) {
        this.context = context;
    }

    public void onClick(View view){
        Toast.makeText(context, "Button is Clicked", Toast.LENGTH_SHORT).show();
    }
}
