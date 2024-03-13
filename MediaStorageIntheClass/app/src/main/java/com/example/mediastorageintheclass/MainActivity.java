package com.example.mediastorageintheclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
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
                saveImageToStorge();

            }
        });
        loadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFromMediaStorage("example.jpg");
            }
        });
    }

    private void loadFromMediaStorage(String displayName) {
        Context context = getApplicationContext();
        Uri queryUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        String[] projection = new String[] {
                MediaStore.Images.Media._ID,
                MediaStore.Images.Media.DISPLAY_NAME
        };
        String selection = MediaStore.Images.Media.DISPLAY_NAME + "=?";
        String[] args = new String[] {displayName};

        Cursor cursor = context.getContentResolver().query(queryUri, projection, selection, args, null);
        cursor.moveToFirst();

        //retrieve image from the storage
        int columnId = cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID);
        Long id = cursor.getLong(columnId);
        Uri imageUri = Uri.withAppendedPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, Long.toString(id));
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeStream(context.getContentResolver().openInputStream(imageUri));
            toLoadImage.setImageBitmap(bitmap);
            cursor.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveImageToStorge() {
        //read this image from imageview
        BitmapDrawable drawable  = (BitmapDrawable) tosaveImage.getDrawable();
        Bitmap bitmap = drawable.getBitmap();

        //create a uri. indicate name, mimetype, location
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.DISPLAY_NAME, "example.jpg");
        values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
        values.put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/exmpleDirectory");


        Uri uri = getApplicationContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        try {
            OutputStream writer = getApplicationContext().getContentResolver().openOutputStream(uri);
            bitmap.compress(Bitmap.CompressFormat.JPEG,100, writer);
            try {
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Toast.makeText(getApplicationContext(), "Image saved to gallery", Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}