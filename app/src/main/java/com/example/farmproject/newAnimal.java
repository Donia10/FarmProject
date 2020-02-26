package com.example.farmproject;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class newAnimal extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {

    EditText animal_num;
    Spinner type;
    Spinner Age;
    TextView Age_res;
    Button add;
    //editText for animalStatus
    EditText maleId;
    Spinner status;
    Spinner previousBirths;
    Spinner typeBaby;
    Spinner typeBaby2;
    Spinner typeBaby3;
    Spinner typeBaby4;
    Spinner typeBaby5;

    //firebase instance object
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mAnimalsDatabaseReference;
    private DatabaseReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_animal);

        animal_num = findViewById(R.id.animalnum);
        type=findViewById(R.id.animaltype);
        Age = findViewById(R.id.animalage);
        Age_res = findViewById(R.id.ageresult);
        add = findViewById(R.id.addbtn);

        //objects for AnimalStatus
        maleId=findViewById(R.id.maleId);
        typeBaby=findViewById(R.id.typeBaby);
        typeBaby2=findViewById(R.id.typeBaby2);
        typeBaby3=findViewById(R.id.typeBaby3);
        typeBaby4=findViewById(R.id.typeBaby4);
        typeBaby5=findViewById(R.id.typeBaby5);

        //firebase object
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mAnimalsDatabaseReference = mFirebaseDatabase.getReference().child("animals");
        ref = mFirebaseDatabase.getReference().child("animals");

        //toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.tlnewanimal);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("إضافة حيوان جديد");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(Color.WHITE);


        // Create an ArrayAdapter for spinner type

        final ArrayAdapter<CharSequence> newadapter = ArrayAdapter.createFromResource(this, R.array.Spinner6_items, android.R.layout.simple_spinner_item);
        newadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type.setAdapter(newadapter);
        type.setOnItemSelectedListener(this);


     // Create an ArrayAdapter for spinner Age

        final ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.Spinner4_items, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Age.setAdapter(adapter1);
        Age.setOnItemSelectedListener(this);

       // Create an ArrayAdapter for spinner status
/*
        final Spinner status = findViewById(R.id.animalstatus);

        final ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.Spinner5_items, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        status.setAdapter(adapter2);
        status.setOnItemSelectedListener(this);
        **/

        //spinner
          status=findViewById(R.id.animalstatus);
        // Create an ArrayAdapter using the string array and a default spinner layout
        final ArrayAdapter<CharSequence> adapterStatus = ArrayAdapter.createFromResource(this, R.array.Spinner5_items, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterStatus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        status.setAdapter(adapterStatus);
        status.setOnItemSelectedListener(this);


        //spinner
        previousBirths=findViewById(R.id.numberOfPreviousBirths);
        // Create an ArrayAdapter using the string array and a default spinner layout
        final ArrayAdapter<CharSequence> adapterB = ArrayAdapter.createFromResource(this, R.array.Spinner9_items, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterB.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        previousBirths.setAdapter(adapterB);
        previousBirths.setOnItemSelectedListener(this);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               writeData();

            }
        });


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(parent.getId() == R.id.animalstatus)
        {
        if(position==2||position==3){
            maleId.setVisibility(View.VISIBLE);

        }else {
            maleId.setVisibility(View.GONE);
        }
        }
        if(parent.getId() == R.id.numberOfPreviousBirths) {
            if (position == 1) {
                typeBaby.setVisibility(View.VISIBLE);
                typeBaby2.setVisibility(View.GONE);
                typeBaby3.setVisibility(View.GONE);
                typeBaby4.setVisibility(View.GONE);
                typeBaby5.setVisibility(View.GONE);

            }
            else if (position == 2) {
                typeBaby.setVisibility(View.VISIBLE);
                typeBaby2.setVisibility(View.VISIBLE);
                typeBaby3.setVisibility(View.GONE);
                typeBaby4.setVisibility(View.GONE);
                typeBaby5.setVisibility(View.GONE);

            }
            else if (position == 3) {
                typeBaby.setVisibility(View.VISIBLE);
                typeBaby2.setVisibility(View.VISIBLE);
                typeBaby3.setVisibility(View.VISIBLE);
                typeBaby4.setVisibility(View.GONE);
                typeBaby5.setVisibility(View.GONE);

            }
            else if (position == 4) {
                typeBaby.setVisibility(View.VISIBLE);
                typeBaby2.setVisibility(View.VISIBLE);
                typeBaby3.setVisibility(View.VISIBLE);
                typeBaby4.setVisibility(View.VISIBLE);
                typeBaby5.setVisibility(View.GONE);
            }
            else if(position==5){
                typeBaby.setVisibility(View.VISIBLE);
                typeBaby2.setVisibility(View.VISIBLE);
                typeBaby3.setVisibility(View.VISIBLE);
                typeBaby4.setVisibility(View.VISIBLE);
                typeBaby5.setVisibility(View.VISIBLE);
            }
            else {
                typeBaby.setVisibility(View.GONE);
                typeBaby2.setVisibility(View.GONE);
                typeBaby3.setVisibility(View.GONE);
                typeBaby4.setVisibility(View.GONE);
                typeBaby5.setVisibility(View.GONE);
            }
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

        maleId.setText("");
    }

    public void writeData(){

        String id=animal_num.getText().toString();
        NewAnimals newAnimal=new NewAnimals(animal_num.getText().toString(),type.getSelectedItem().toString(),Age.getSelectedItem().toString(),Age_res.getText().toString(),status.getSelectedItem().toString(),maleId.getText().toString(),previousBirths.getSelectedItem().toString(),typeBaby.getSelectedItem().toString(),typeBaby2.getSelectedItem().toString(),typeBaby3.getSelectedItem().toString(),typeBaby4.getSelectedItem().toString(),typeBaby5.getSelectedItem().toString());
        ref.child("animalId").child(id).child("id").setValue(id);
        mAnimalsDatabaseReference.child("newAnimal").child(animal_num.getText().toString()).setValue(newAnimal);
    }

}
