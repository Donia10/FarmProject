package com.example.farmproject;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.Executor;

public class DataAnimal extends AppCompatActivity {

    public static final String EXTRA="com.example.farmproject.EXTRA";
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    TextView fat;
    TextView milkFirst;
    TextView milkSecond;
    TextView milkThird;
    TextView protien;
    @Override
    public boolean bindIsolatedService(Intent service, int flags, String instanceName, Executor executor, ServiceConnection conn) {
        return super.bindIsolatedService(service, flags, instanceName, executor, conn);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_animal);

        //Intent
        Intent intent=getIntent();
        final String animalId=intent.getStringExtra(AnimalsAdapter.EXTRA_TEXT);

        //ToolBar
        Toolbar toolbar=findViewById(R.id.tlData);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("حيوان رقم "+animalId);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //objects
        fat=findViewById(R.id.fat);
        milkFirst=findViewById(R.id.milkFirst);
        milkSecond=findViewById(R.id.milkSecond);
        milkThird=findViewById(R.id.milkThird);
        protien=findViewById(R.id.protein);

        firebaseDatabase=FirebaseDatabase.getInstance();
        assert animalId != null;
        databaseReference=firebaseDatabase.getReference().child("animals").child(animalId);
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                dataSnapshot.child("milk");
               AmountOfMilk amountOfMilk=dataSnapshot.getValue(AmountOfMilk.class);
               fat.setText("FatPercentage = "+amountOfMilk.getFatPercentage());
               milkFirst.setText("MilkFirstTime = "+amountOfMilk.getMilkFirstTime());
               milkSecond.setText("MilkSecondTime = "+amountOfMilk.getMilkSecondTime());
               milkThird.setText("MilkThirdTime = "+amountOfMilk.getMilkThirdTime());
               protien.setText("proteinRatio = "+amountOfMilk.getProteinRatio());

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
