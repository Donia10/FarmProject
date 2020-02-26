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

public class DataAnimals extends AppCompatActivity {
    public static final String EXTRA ="com.example.farmproject.EXTRA";
    private TextView first;
    private TextView second;
    private TextView third;
    private TextView fat;
    private TextView protein;
    private TextView type;
    private TextView date;
    private TextView age;
    private TextView animalNo;
    private TextView animalType;
    private TextView status;
    private TextView maleNo;
    private TextView previousBirth;
    private TextView fBirth;
    private TextView sBirth;
    private TextView tBirth;
    private TextView forBirth;
    private TextView fifBirth;
    private TextView numberpollination;
    private TextView resultPoll;
    private TextView misedAnimal;

    private LinearLayout missed;
    private LinearLayout milkl;
    private LinearLayout animall;
    private LinearLayout fortl;
    private LinearLayout poll;




    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private DatabaseReference ref;
    private DatabaseReference refA;
    private DatabaseReference refP;
    private DatabaseReference refM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_animals);

            Intent intent = getIntent();
            String animalID = intent.getStringExtra(AnimalsAdapter.EXTRA_TEXT);
            //toolbar
            Toolbar toolbar_animals = (Toolbar) findViewById(R.id.tlData);
            setSupportActionBar(toolbar_animals);
            getSupportActionBar().setTitle("حيوان رقم " + animalID);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar_animals.setTitleTextColor(Color.WHITE);

            //objects
            first = findViewById(R.id.first);
            second = findViewById(R.id.second);
            third = findViewById(R.id.third);
            fat = findViewById(R.id.fatP);
            protein = findViewById(R.id.proteinR);
            type = findViewById(R.id.type);
            date = findViewById(R.id.date);

            age=findViewById(R.id.age);
            animalNo=findViewById(R.id.animalid);
            animalType=findViewById(R.id.animaltypee);
            maleNo=findViewById(R.id.maleid);
            status=findViewById(R.id.statusan);
            previousBirth=findViewById(R.id.noPrevious);
            fBirth=findViewById(R.id.fBirth);
            sBirth=findViewById(R.id.sBirth);
            tBirth=findViewById(R.id.tBirth);
            forBirth=findViewById(R.id.foBirth);
            fifBirth=findViewById(R.id.fifBirth);

            numberpollination=findViewById(R.id.numberpollination);
            resultPoll=findViewById(R.id.resultPoll);

            misedAnimal=findViewById(R.id.misedAnimal);

            missed=findViewById(R.id.missed);
            animall=findViewById(R.id.annimal);
            milkl=findViewById(R.id.mlk);
            poll=findViewById(R.id.poll);
            fortl=findViewById(R.id.fort);


        firebaseDatabase = FirebaseDatabase.getInstance();
            refA = firebaseDatabase.getReference().child("animals").child("newAnimal").child(animalID);
            refA.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()) {
                        animall.setVisibility(View.VISIBLE);
                        NewAnimals newAnimals = dataSnapshot.getValue(NewAnimals.class);
                        readDataAnimal(newAnimals);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

            databaseReference = firebaseDatabase.getReference().child("animals").child("fortification").child(animalID);
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()) {
                        fortl.setVisibility(View.VISIBLE);
                        Fortification fortification = dataSnapshot.getValue(Fortification.class);
                        readFortification(fortification);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

            ref = firebaseDatabase.getReference().child("animals").child("milk").child(animalID);
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()) {
                        milkl.setVisibility(View.VISIBLE);
                        AmountOfMilk amountOfMilk = dataSnapshot.getValue(AmountOfMilk.class);
                        readMilk(amountOfMilk);
                    }
                }


                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

            refP = firebaseDatabase.getReference().child("animals").child("pollinations").child(animalID);
            refP.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()) {
                        poll.setVisibility(View.VISIBLE);
                        Pllinations pllinations = dataSnapshot.getValue(Pllinations.class);
                        readPollination(pllinations);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            refM = firebaseDatabase.getReference().child("animals").child("MissedAnimal").child(animalID);
            refM.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()) {
                        missed.setVisibility(View.VISIBLE);
                        AnimalMised animalMised = dataSnapshot.getValue(AnimalMised.class);
                        readMissedAnimal(animalMised);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });



        // readMilk(new AmountOfMilk("","","","",""));
            //Fortification fortification=new Fortification("aaaa","ssss");
            //readFortification(fortification);

        }
        private void readMilk (AmountOfMilk amountOfMilk){
            first.setText("كمية الحليب فى الحلبه الاولى =" + amountOfMilk.getMilkFirstTime());
            second.setText("كمية الحليب فى الحلبه الثانية = " + amountOfMilk.getMilkSecondTime());
            third.setText("كمية الحليب فى الحلبه الثالثة = " + amountOfMilk.getMilkThirdTime());
            fat.setText("نسبة الدهن = " + amountOfMilk.getFatPercentage());
            protein.setText("نسبة البروتين= " + amountOfMilk.getProteinRatio());
        }
        private void readFortification (Fortification fortification){

            type.setText("نوع التحصين =" + fortification.getTypeOfFortification());
            date.setText("ميعاد الجرعة القادمة =" + fortification.getDateOfNextDose());
        }
        private void readDataAnimal(NewAnimals newAnimals){

            age.setText("العمر = "+newAnimals.getAgeText()+newAnimals.getAge());
            animalNo.setText("رقم الحيوان = "+newAnimals.getAnimalNumber());
            animalType.setText("نوع الحيوان = "+newAnimals.getAnimalType());
            status.setText("الحاله التناسليه = "+newAnimals.getStatus());
            maleNo.setText("رقم الذكر = "+newAnimals.getMaleNumber());
            previousBirth.setText("عدد الولادات السابقه = "+newAnimals.getPreviousBirth());
            fBirth.setText("نوع المولود فى الولاده الاولى = "+newAnimals.getFirstBirth());
            sBirth.setText("نوع المولود فى الولاده الثانيه = "+newAnimals.getSecondBirth());
            tBirth.setText("نوع المولود فى الولاده الثالثه = "+newAnimals.getThirdBirth());
            forBirth.setText("نوع المولود فى الولاده الرابعه = "+newAnimals.getFourthBirth());
            fifBirth.setText("نوع المولود فى الولاده الخامسه = "+newAnimals.getFifthBirth());

        }
        private void readPollination(Pllinations pllinations){

            numberpollination.setText("عدد التلقيحات للأخصاب = "+pllinations.getPollinationNumber());
            resultPoll.setText("نتيجه التلقيح = "+pllinations.getResult());
        }
    private void readMissedAnimal(AnimalMised animalMised){

            misedAnimal.setText("نوع الفقد = "+animalMised.getMissedType());
    }
    }