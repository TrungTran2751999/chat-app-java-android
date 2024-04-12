package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity2 extends AppCompatActivity {
    private String mobile;
    private String email;
    private String name;
    private RecyclerView messageRecycleView;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://chat-app-315c6-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mobile = getIntent().getStringExtra("mobile");
        email = getIntent().getStringExtra("email");
        name =  getIntent().getStringExtra("name");
        messageRecycleView = findViewById(R.id.messageRecycleView);
        messageRecycleView.setHasFixedSize(true);
        messageRecycleView.setLayoutManager(new LinearLayoutManager(this));

    }
}