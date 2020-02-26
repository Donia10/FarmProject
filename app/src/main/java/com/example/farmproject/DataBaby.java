package com.example.farmproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DataBaby extends AppCompatActivity {

    public static final String ID ="com.example.farmproject.ID";
    public static final String TAG="MainActivity";
    private TextView fatherId;
    private TextView motherId;
    private TextView babyId;
    private TextView birthday;
    private TextView babyWeight;
    private TextView typeOfOperation;
    private TextView typeBaby;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference dRef;
    private LinearLayout babyl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_baby);

        Intent intent =getIntent();
        final String babyID=intent.getStringExtra(BabyIDAdapter.EXTRA_TXT);
        //toolbar
        Toolbar toolbar_animals = (Toolbar) findViewById(R.id.dataBabyTl);
        setSupportActionBar(toolbar_animals);
        getSupportActionBar().setTitle("حيوان المولود "+babyID);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar_animals.setTitleTextColor(Color.WHITE);



        birthday =  findViewById(R.id.birthDay);
        fatherId =  findViewById(R.id.father_id);
        motherId =  findViewById(R.id.mother_id);
        babyId = (TextView) findViewById(R.id.son_id);
        babyWeight = (TextView) findViewById(R.id.baby_weight);
        typeOfOperation=findViewById(R.id.type_op);
        typeBaby=findViewById(R.id.type_baby);
        babyl=findViewById(R.id.babyl);

        firebaseDatabase=FirebaseDatabase.getInstance();
        dRef=firebaseDatabase.getReference().child("animals").child("babyAnimal").child(babyID);
        dRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()) {
                    babyl.setVisibility(View.VISIBLE);
                    NewBabyAnimal newBabyAnimal = dataSnapshot.getValue(NewBabyAnimal.class);
                    readBabyAnimal(newBabyAnimal);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void readBabyAnimal(NewBabyAnimal newBabyAnimal){

        birthday.setText("تاريخ الميلاد"+newBabyAnimal.getBirthDay());
        fatherId.setText("رقم الاب"+newBabyAnimal.getFatherId());
        motherId.setText("رقم الام"+newBabyAnimal.getMotherId());
        babyId.setText("رقم المولود"+newBabyAnimal.getBabyId());
        typeOfOperation.setText("نوع الولاده"+newBabyAnimal.getTypeOperation());
        typeBaby.setText("نوع المولود"+newBabyAnimal.getTypeOfBaby());
        babyWeight.setText("وزن المولود"+newBabyAnimal.getBabyWeight());

    }


}
