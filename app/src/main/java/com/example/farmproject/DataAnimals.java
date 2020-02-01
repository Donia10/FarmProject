package com.example.farmproject;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DataAnimals extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_animals);
        //objects
        first=findViewById(R.id.first);
        second=findViewById(R.id.second);
        third=findViewById(R.id.third);
        fat=findViewById(R.id.fatP);
        protein=findViewById(R.id.proteinR);
        type=findViewById(R.id.type);
        date=findViewById(R.id.date);

        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference().child("animals").child("fortifications").child("1");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Fortification_ f=dataSnapshot.getValue(Fortification_.class);
                readFortification(f);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        readMilk(new AmountOfMilk("","","","",""));
    }
    private void readMilk(AmountOfMilk amountOfMilk){
        first.setText("Milk First Time = "+amountOfMilk.getMilkFirstTime());
        second.setText("Milk Second Time = "+amountOfMilk.getMilkSecondTime());
        third.setText("Milk Third Time = "+amountOfMilk.getMilkThirdTime());
        fat.setText("Fat Percentage = "+amountOfMilk.getFatPercentage());
        protein.setText("protein Ratio= "+amountOfMilk.getProteinRatio());
    }
    private void readFortification(Fortification_ fortification_){

        type.setText(" Type Fortification ="+fortification_.getTypeFortification());
        date.setText("DateOfNextDose ="+fortification_.getDateOfNextDose());
          }
}
