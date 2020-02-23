package com.example.farmproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class missedAnimal extends AppCompatActivity {

     Spinner missedtype;
      Button add;

     private FirebaseDatabase mFirebaseDatabase;
     private DatabaseReference mAnimalsDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_missed_animal);

       //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.missedanimal);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("الحيوانات المفقودة");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(Color.WHITE);


        missedtype = findViewById(R.id.missedspinner);
        add = findViewById(R.id.addbtn);

      //firebase objects
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mAnimalsDatabaseReference = mFirebaseDatabase.getReference().child("animals");

       final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Spinner_items, android.R.layout.simple_spinner_item);

        missedtype.setAdapter(adapter);
        missedtype.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // writeOnDatabase();


            }
        });
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        parent.getItemAtPosition(position);
    }

   public void writeOnDatabase()
    {
        AnimalMissed missedanimal= new AnimalMissed(missedtype.getSelectedItem().toString());
        mAnimalsDatabaseReference.child("missedAnimal").child("1").setValue(missedanimal);


    }

}
