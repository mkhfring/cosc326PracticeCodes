package com.example.externalstoragepractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    static final String DIR = "MyFileDir";
    static final String FILENAME = "externalExample.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText = findViewById(R.id.edit);
        Button save_btn = findViewById(R.id.savebtn);
        Button load_btn = findViewById(R.id.read);
        TextView textView = findViewById(R.id.textView);
        if(!isEternalDeviceAvailable()){
            save_btn.setEnabled(false);
        }
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToExternalStorage(editText.getText().toString());
            }
        });
        load_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contents = loadExternalResource();
                textView.setText(contents);
            }
        });

    }

    private String loadExternalResource() {
        File filePath = new File(getExternalFilesDir(DIR), FILENAME);
        FileReader fr = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            try {
                String line = br.readLine();
                while(line !=null){
                    stringBuilder.append(line).append("\n");
                    line = br.readLine();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        finally {
            return stringBuilder.toString();
        }

    }

    private void saveToExternalStorage(String input) {
        File filePath = new File(getExternalFilesDir(DIR), FILENAME);
        try {
            FileOutputStream writer = new FileOutputStream(filePath);
            try {
                writer.write(input.getBytes());
                writer.close();
                Toast.makeText(getApplicationContext(), "saved to external", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isEternalDeviceAvailable() {
        String storageStatus = Environment.getExternalStorageState();
        if(storageStatus.equals(Environment.MEDIA_MOUNTED)){
            return true;
        }
        return false;
    }
}