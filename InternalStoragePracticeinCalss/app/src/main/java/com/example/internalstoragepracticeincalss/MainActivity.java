package com.example.internalstoragepracticeincalss;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    static final String FILENAME = "example.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText = findViewById(R.id.edit);
        Button save_btn = findViewById(R.id.savebtn);
        Button read_btn = findViewById(R.id.read);
        TextView textView = findViewById(R.id.textView);
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = editText.getText().toString();
                saveOnInternalDevice(userInput);
            }
        });
        read_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = loadFileContent();
                textView.setText(content);
            }
        });
    }

    private String loadFileContent() {
        File filepath = new File(getApplicationContext().getFilesDir(), FILENAME);
        try {
            FileInputStream reader = new FileInputStream(filepath);
            byte [] content = new byte[(int)filepath.length()];
            try {
                reader.read(content);
                return new String(content);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private void saveOnInternalDevice(String userInput) {
        File filepath = new File(getApplicationContext().getFilesDir(), FILENAME);
        try {
            FileOutputStream writer = new FileOutputStream(filepath);
            try {
                writer.write(userInput.getBytes());
                writer.close();
                Toast.makeText(
                        getApplicationContext(),
                        "saved to " + getApplicationContext().getFilesDir(),
                        Toast.LENGTH_SHORT
                ).show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}