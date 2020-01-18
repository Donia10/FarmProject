package com.example.farmproject;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Milk extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText milkTheFirstTime;
    EditText milkTheSecondTime;
    EditText milkTheThirdTime;
    EditText fatText;
    EditText proteinText;
    Button add;
    //firebase instance object
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mAnimalsDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milk);

        milkTheFirstTime=findViewById(R.id.item1);
        milkTheSecondTime=findViewById(R.id.item2);
        milkTheThirdTime=findViewById(R.id.item3);
        fatText=findViewById(R.id.fat);
        proteinText=findViewById(R.id.protein);
        add=findViewById(R.id.add);
        //firebase object
        mFirebaseDatabase= FirebaseDatabase.getInstance();
        mAnimalsDatabaseReference=mFirebaseDatabase.getReference().child("animals");
       //toolbar
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("كمية إدرار اللبن");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(Color.WHITE);

        //spinner
        final Spinner spinner=findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.items, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AmountOfMilk amountOfMilk=new AmountOfMilk(milkTheFirstTime.getText().toString(),milkTheSecondTime.getText().toString(),milkTheThirdTime.getText().toString(),fatText.getText().toString(),proteinText.getText().toString());

                //create new node in tree of animals
              /* Map<String,AmountOfMilk> milkMap= new HashMap<>();
                Map<String,String>map=new HashMap<>();
                milkMap.put("Milk",amountOfMilk);
                milkMap.put("add",amountOfMilk);**/
                //mAnimalsDatabaseReference.setValue(milkMap);
                //create milk into id
               // mAnimalsDatabaseReference.push().setValue(milkMap);

                //create milk into id without Map
                mAnimalsDatabaseReference.push().child("milk").setValue(amountOfMilk);

                //mAnimalsDatabaseReference.setValue(amountOfMilk);
              // mAnimalsDatabaseReference.push().setValue(amountOfMilk);
                //milkTheFirstTime.setText("0", TextView.BufferType.EDITABLE); /*// May be unecessary... */
                milkTheFirstTime.getText().clear();
                milkTheSecondTime.getText().clear();
                milkTheThirdTime.getText().clear();
                fatText.getText().clear();
                proteinText.getText().clear();
                //fatText.setText("0");

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(position==1){
            milkTheFirstTime.setVisibility(View.VISIBLE);
            milkTheSecondTime.setVisibility(View.GONE);
            milkTheThirdTime.setVisibility(View.GONE);
           //apply data
           /* AmountOfMilk amountOfMilk=new AmountOfMilk(editText1.getText().toString(),null,null,fatText.getText().toString(),proteinText.getText().toString());
            mAnimalsDatabaseReference.push().setValue(amountOfMilk);**/
        }else if(position==2){
            milkTheFirstTime.setVisibility(View.VISIBLE);
            milkTheSecondTime.setVisibility(View.VISIBLE);
            milkTheThirdTime.setVisibility(View.GONE);


/*
            AmountOfMilk amountOfMilk=new AmountOfMilk(editText1.getText().toString(),editText2.getText().toString(),null,fat.getText().toString(),protein.getText().toString());
            mAnimalsDatabaseReference.push().setValue(amountOfMilk);**/
        }else if(position==3){
            milkTheFirstTime.setVisibility(View.VISIBLE);
            milkTheSecondTime.setVisibility(View.VISIBLE);
            milkTheThirdTime.setVisibility(View.VISIBLE);
           /* AmountOfMilk amountOfMilk=new AmountOfMilk(editText1.getText().toString(),editText2.getText().toString(),editText3.getText().toString(),fat.getText().toString(),protein.getText().toString());
            mAnimalsDatabaseReference.push().setValue(amountOfMilk);**/

        }else {
            milkTheFirstTime.setVisibility(View.GONE);
            milkTheSecondTime.setVisibility(View.GONE);
            milkTheThirdTime.setVisibility(View.GONE);
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}