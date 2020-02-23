package com.example.farmproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class newAnimal extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {

    EditText animal_num;
    Spinner type;
    Spinner Age;
    TextView Age_res;


     EditText cow;
     EditText newcow;
     EditText oldcow;

    Button add;
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

      /*  final Spinner status = findViewById(R.id.animalstatus);

        final ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.Spinner5_items, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        status.setAdapter(adapter2);
        status.setOnItemSelectedListener(this);*/

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               writeData();

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Age_res.setVisibility(View.VISIBLE);


     /* if(position==1){
            cow.setVisibility(View.VISIBLE);
            newcow.setVisibility(View.GONE);
            oldcow.setVisibility(View.GONE);

        }else if(position==2){
            cow.setVisibility(View.VISIBLE);
            newcow.setVisibility(View.VISIBLE);
            oldcow.setVisibility(View.GONE);


        }else if(position==3){
           cow.setVisibility(View.VISIBLE);
            newcow.setVisibility(View.VISIBLE);
            oldcow.setVisibility(View.VISIBLE);

        }else {
            cow.setVisibility(View.GONE);
            newcow.setVisibility(View.GONE);
            oldcow.setVisibility(View.GONE);
        } */


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void writeData(){

        String id=animal_num.getText().toString();
        NewAnimals newAnimal =new NewAnimals(animal_num.getText().toString(),type.getSelectedItem().toString(),Age.getSelectedItem().toString(), Age_res.getText().toString(),cow.getText().toString(),newcow.getText().toString(),oldcow.getText().toString()) ;
        ref.child("animalId").child(id).child("id").setValue(id);
        mAnimalsDatabaseReference.child("newAnimal").child(animal_num.getText().toString()).setValue(newAnimal);
    }

}
