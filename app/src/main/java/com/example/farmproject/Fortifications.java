package com.example.farmproject;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Fortifications extends AppCompatActivity {

    EditText typeFortification;
    EditText dateOfNextDose;
    Button add;
    Fortification fortification;
    //firebase instance object
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mAnimalsDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fortifications);

       //Toolbar
        Toolbar toolbar =(Toolbar)findViewById(R.id.fortifications);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("التحصينات");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(Color.WHITE);

        //defined Objects
        typeFortification=findViewById(R.id.type_fortifications);
        dateOfNextDose=findViewById(R.id.dateOfNextDose);
        add=findViewById(R.id.add);

        //firebase objects
        mFirebaseDatabase= FirebaseDatabase.getInstance();
        mAnimalsDatabaseReference=mFirebaseDatabase.getReference().child("animals");

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                writeOnDatabase();
                typeFortification.getText().clear();
                dateOfNextDose.getText().clear();
            }
        });
    }
    public void writeOnDatabase(){
        Fortification fortification=new Fortification(typeFortification.getText().toString(),dateOfNextDose.getText().toString());
        mAnimalsDatabaseReference.child("fortification").child("1").setValue(fortification);

    }
}
