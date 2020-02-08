package com.example.farmproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DataAnimals extends AppCompatActivity {
    public static final String EXTRA ="com.example.farmproject.EXTRA";
    private TextView first;
    private TextView second;
    private TextView third;
    private TextView fat;
    private TextView protein;
    private TextView type;
    private TextView date;

   private FirebaseDatabase firebaseDatabase;
   private DatabaseReference databaseReference;
   private DatabaseReference ref;
   private DatabaseReference refBaby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_animals);

        Intent intent =getIntent();
        String animalID=intent.getStringExtra(AnimalsAdapter.EXTRA_TEXT);
        //toolbar
        Toolbar toolbar_animals = (Toolbar) findViewById(R.id.tlData);
        setSupportActionBar(toolbar_animals);
        getSupportActionBar().setTitle("حيوان رقم "+animalID);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar_animals.setTitleTextColor(Color.WHITE);

        //objects
        first=findViewById(R.id.first);
        second=findViewById(R.id.second);
        third=findViewById(R.id.third);
        fat=findViewById(R.id.fatP);
        protein=findViewById(R.id.proteinR);
        type=findViewById(R.id.type);
        date=findViewById(R.id.date);

        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference().child("animals").child("fortification").child(animalID);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Fortification fortification=dataSnapshot.getValue(Fortification.class);
                readFortification(fortification);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        ref=firebaseDatabase.getReference().child("animals").child("milk").child(animalID);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                AmountOfMilk amountOfMilk=dataSnapshot.getValue(AmountOfMilk.class);
                readMilk(amountOfMilk);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        // readMilk(new AmountOfMilk("","","","",""));
        //Fortification fortification=new Fortification("aaaa","ssss");
        //readFortification(fortification);

    }
    private void readMilk(AmountOfMilk amountOfMilk){
        first.setText("كمية الحليب فى الحلبه الاولى ="+amountOfMilk.getMilkFirstTime());
        second.setText("كمية الحليب فى الحلبه الثانية = "+amountOfMilk.getMilkSecondTime());
        third.setText("كمية الحليب فى الحلبه الثالثة = "+amountOfMilk.getMilkThirdTime());
        fat.setText("نسبة الدهن = "+amountOfMilk.getFatPercentage());
        protein.setText("نسبة البروتين= "+amountOfMilk.getProteinRatio());
    }
    private void readFortification(Fortification fortification){

        type.setText("نسبة الدهن ="+fortification.getTypeOfFortification());
        date.setText("نسبة البروتين ="+fortification.getDateOfNextDose());
          }
}
