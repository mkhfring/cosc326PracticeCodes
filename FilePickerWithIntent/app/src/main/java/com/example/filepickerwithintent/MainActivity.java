package com.example.filepickerwithintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    private final static String IMAGE_NAME = "myImage";
    public ImageView tosaveImage;
    public ImageView toLoadImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button savebtn = findViewById(R.id.savebtn);
        Button loadbtn = findViewById(R.id.loadbtn);
        tosaveImage = findViewById(R.id.tosave);
        toLoadImage = findViewById(R.id.toload);
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/jpeg");
                intent.putExtra(Intent.EXTRA_TITLE, IMAGE_NAME);
                startActivityForResult(intent, 1);

            }
        });
        loadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                startActivityForResult(intent, 2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri imageUri = data.getData();
        if(resultCode == RESULT_OK){
            if(requestCode == 1){
                saveImage(imageUri);
            }
            if(requestCode == 2){
                loadImage(imageUri);
            }
        }

    }

    private void loadImage(Uri imageUri) {
        toLoadImage.setImageURI(imageUri);
    }

    private void saveImage(Uri imageUri) {
        Bitmap imageBitmap = ((BitmapDrawable)tosaveImage.getDrawable()).getBitmap();
        OutputStream writer = null;
        try {
            writer = this.getContentResolver().openOutputStream(imageUri);
            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, writer);

            try {
                writer.close();
                Toast.makeText(this,"Image is saved", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}