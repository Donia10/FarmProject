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
    Button farmAnimals;
    Button fortifications;

    //firebase instance object
    public FirebaseDatabase mFirebaseDatabase;
    public DatabaseReference mAnimalsDatabaseReference;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*//firebase
        mFirebaseDatabase=FirebaseDatabase.getInstance();
        mAnimalsDatabaseReference=mFirebaseDatabase.getReference().child("Animals");
        **/
        //objects
        milk=findViewById(R.id.milk);
        milk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityMilk();
            }
        });

        farmAnimals=findViewById(R.id.farm_animals);
        farmAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityFarmAnimals();
            }
        });

        fortifications=findViewById(R.id.fortifications);
        fortifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityFortifications();
            }
        });




    }
    public void openActivityMilk() {
        Intent intent = new Intent(this, Milk.class);
        startActivity(intent);

    }
    public void openActivityFarmAnimals() {
        Intent intent = new Intent(this, FarmAnimals.class);
        startActivity(intent);


    }
    public void openActivityFortifications() {
        Intent intent = new Intent(this, Fortifications.class);
        startActivity(intent);

    }

}