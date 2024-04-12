package com.example.chatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.PixelCopy;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://chat-app-315c6-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nameRegister = findViewById(R.id.nameRegister);
        final EditText mobileRegister = findViewById(R.id.mobileNumberRegister);
        final EditText emailRegister = findViewById(R.id.emailRegister);
        final Button btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                final String nameText = nameRegister.getText().toString();
                final String mobileText =  mobileRegister.getText().toString();
                final String emailText = emailRegister.getText().toString();

                if(nameText.isEmpty() || mobileText.isEmpty() || emailText.isEmpty()){
                    Toast.makeText(MainActivity.this, "All feild Required !!!", Toast.LENGTH_SHORT).show();
                }else{
                    databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.child("users").hasChild(mobileText)){
                                Toast.makeText(MainActivity.this, "All feild Required !!!", Toast.LENGTH_SHORT).show();
                            }else{
                                databaseReference.child("users").child(mobileText).setValue(emailText);
                                databaseReference.child("users").child(nameText).setValue(nameText);
                                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                                intent.putExtra("mobile", mobileText);
                                intent.putExtra("name", nameText);
                                intent.putExtra("email", emailText);
                                startActivity(intent);
                                finish();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            System.out.println(error);
                        }
                    });
                }
            }
        });
    }
}