package com.example.farmproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Button milk;

   //firebase instance object
    public FirebaseDatabase mFirebaseDatabase;
    public DatabaseReference mAnimalsDatabaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseDatabase=FirebaseDatabase.getInstance();
        mAnimalsDatabaseReference=mFirebaseDatabase.getReference().child("Animals");
        milk=findViewById(R.id.milk);
        milk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityMilk();
            }
        });

    }
    public void openActivityMilk() {
        Intent intent = new Intent(this, Milk.class);
        startActivity(intent);

    }

}
