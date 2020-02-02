package com.example.farmproject;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class BabyAnimal_Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView birthday;
    TextView dadrnum_txt;
    TextView mumnum;
    TextView sonnum;
    TextView sonWeight;
    Spinner type;
    Spinner sontype;
    Button add;

    //firebase instance object
/*
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mAnimalsDatabaseReference;
**/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby_animal_);

        //toolbar
        Toolbar toolbar=(Toolbar)findViewById(R.id.tlbaby);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("إضافة مولود جديد ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(Color.WHITE);

        birthday = (TextView) findViewById(R.id.birthdatetxt);
        dadrnum_txt = (TextView) findViewById(R.id.fathernum);
        mumnum = (TextView) findViewById(R.id.mothernum);
        sonnum = (TextView) findViewById(R.id.babynum);
        sonWeight = (TextView) findViewById(R.id.babyweight);
        type = (Spinner) findViewById(R.id.typesurgion);
        //   type.setOnItemClickListener(this);
        sontype = (Spinner) findViewById(R.id.babytype);
        // sontype.setOnItemClickListener(this);
        add = (Button) findViewById(R.id.addbtn);

/*
        //firebase object
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mAnimalsDatabaseReference = mFirebaseDatabase.getReference().child("animals");

        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Spinner_items, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        type.setAdapter(adapter);
        type.setOnItemSelectedListener(this);                //spinner1

        final ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.Spinner2_items, android.R.layout.simple_spinner_item);

        sontype.setAdapter(adapter1);                          //spinner2
        sontype.setOnItemSelectedListener(this);
/*
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BabyAnimal_Json babyanimal = new BabyAnimal_Json(type.getSelectedItem().toString());
                BabyAnimal_Json babyanimal2 = new BabyAnimal_Json(sontype.getSelectedItem().toString());

                mAnimalsDatabaseReference.push().child("baby").setValue(babyanimal);
                mAnimalsDatabaseReference.push().child("baby").setValue(babyanimal2);
           }
        });
    **/
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        parent.getItemAtPosition(position);
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}