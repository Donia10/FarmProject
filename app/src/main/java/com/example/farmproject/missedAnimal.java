package com.example.farmproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class missedAnimal extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner missedtype;
    Button add;
    String animalId;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mAnimalsDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_missed_animal);

        //Toolbar
        Toolbar toolbar= (Toolbar) findViewById(R.id.missedanimal);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("الحيوانات المفقودة");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(Color.WHITE);


        Intent intent=getIntent();
        animalId=intent.getStringExtra(AnimalsAdapter.EXTRA_TEXT);

        missedtype = findViewById(R.id.missedspinner);
        add = findViewById(R.id.addbtn);
        //firebase objects
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mAnimalsDatabaseReference = mFirebaseDatabase.getReference().child("animals");

        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Spinner3_items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        missedtype.setAdapter(adapter);
        missedtype.setOnItemSelectedListener(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeOnDatabase();
            }
        });
    }

    public void writeOnDatabase()
    {

        AnimalMised animalMised=new AnimalMised(missedtype.getSelectedItem().toString());
        mAnimalsDatabaseReference.child("MissedAnimal").child(animalId).setValue(animalMised);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

