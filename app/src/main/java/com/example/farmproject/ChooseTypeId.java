package com.example.farmproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ChooseTypeId extends AppCompatActivity {

    Button animal;
    Button baby;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_type_id);
        /*

        //toolbar
        Toolbar toolbar_animals = (Toolbar) findViewById(R.id.ChooseTl);
        setSupportActionBar(toolbar_animals);
        getSupportActionBar().setTitle("قطيع المزرعة");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar_animals.setTitleTextColor(Color.WHITE);


        animal=findViewById(R.id.CAnimalId);
        baby=findViewById(R.id.CBabyId);
        animal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openActivityAnimalId();

            }
        });
        baby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityBabyAnimalId();
            }
        });

        **/
    }
    private void openActivityBabyAnimalId(){
        Intent intent=new Intent(this,BabyAnimalId.class);
        startActivity(intent);
    }
    private void openActivityAnimalId(){
        Intent intent=new Intent(this,FarmAnimals.class);
        startActivity(intent);
    }
}
