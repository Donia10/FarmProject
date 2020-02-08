package com.example.farmproject;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BabyAnimal_Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView birthday;
    TextView dadrnum_txt;
    TextView mumnum;
    TextView sonnum;
    TextView sonWeight;
    Spinner type;
    Spinner sontype;
    Button add;
    TextView ss;

    //firebase instance object

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mAnimalsDatabaseReference;
    private DatabaseReference ref;

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
        ss=findViewById(R.id.s);

        //firebase object
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mAnimalsDatabaseReference = mFirebaseDatabase.getReference().child("animals");
        ref = mFirebaseDatabase.getReference().child("animals");

        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Spinner_items, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        type.setAdapter(adapter);
        type.setOnItemSelectedListener(this);                //spinner1

        final ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.Spinner2_items, android.R.layout.simple_spinner_item);

        sontype.setAdapter(adapter1);                          //spinner2
        sontype.setOnItemSelectedListener(this);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeData();

                /*
                BabyAnimal_Json babyanimal = new BabyAnimal_Json(type.getSelectedItem().toString());
                BabyAnimal_Json babyanimal2 = new BabyAnimal_Json(sontype.getSelectedItem().toString());

                mAnimalsDatabaseReference.child("baby").setValue(babyanimal);
                //mAnimalsDatabaseReference.push().child("baby").setValue(babyanimal2);
                **/
           }
        });

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        parent.getItemAtPosition(position);
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    public void writeData(){

        String id=sonnum.getText().toString();
        NewBabyAnimal newBabyAnimal =new NewBabyAnimal(birthday.getText().toString(),dadrnum_txt.getText().toString(),mumnum.getText().toString(), sonnum.getText().toString(),type.getSelectedItem().toString(), sontype.getSelectedItem().toString(),sonWeight.getText().toString()) ;
        ref.child("animalId").child(id).child("id").setValue(id);
        //ref.child("animalId").child(id).child("babyAnimal").setValue(newBabyAnimal);
         mAnimalsDatabaseReference.child("babyAnimal").child(sonnum.getText().toString()).setValue(newBabyAnimal);
    }
}