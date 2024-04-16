package com.example.firebaseinclass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textView);

        // Create an instance of the firebase database
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        // Create a reference to node of database that you want to work with
        DatabaseReference dbref = database.getReference("messages");
        DatabaseReference dbref2 = database.getReference("users");
//        dbref.setValue("Welcome To my firebase app");

        User user = new User("Example", "example@example.com");
        dbref2.setValue(user);

        dbref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User retrievedUser = snapshot.getValue(User.class);
                textView.setText("email:" + retrievedUser.email);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

//        dbref2.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                String value = snapshot.getValue(String.class);
//                textView.setText(value);
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

    }
}