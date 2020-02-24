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

public class Pollination extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner number_poll;
    Spinner result;
    Button add;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mAnimalsDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pollination);

        number_poll=findViewById(R.id.number_pollination);
        result=findViewById(R.id.result_poll);
        add=findViewById(R.id.addbtn);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mAnimalsDatabaseReference = mFirebaseDatabase.getReference().child("animals");


        //toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolPollination);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("التلقيح");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(Color.WHITE);

       final ArrayAdapter<CharSequence> newadapter = ArrayAdapter.createFromResource(this, R.array.Spinner7_items, android.R.layout.simple_spinner_item);
       newadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        number_poll.setAdapter(newadapter);
        number_poll.setOnItemSelectedListener(this);

        final ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.Spinner8_items, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        result.setAdapter(newadapter);
        result.setOnItemSelectedListener(this);

       add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               writeOnDatabase();

            }
        });
    }

   @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
     // number_poll.setVisibility(View.VISIBLE);
       if(parent.getId() == R.id.number_pollination) {
           parent.getItemAtPosition(position);

       }
       else if(parent.getId() == R.id.result_poll)
       {
           parent.getItemAtPosition(position);

       }


   }






    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

   public void writeOnDatabase(){
        Pllinations pollinations=new  Pllinations(number_poll.getSelectedItem().toString(), result.getSelectedItem().toString());
        mAnimalsDatabaseReference.child("pollinations").child("1").setValue(pollinations);

    }
}
