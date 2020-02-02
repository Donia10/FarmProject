package com.example.farmproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button milk;
    Button farmAnimals;
    Button fortifications;
    Button addBabyAniaml;

    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
//objects
        milk=findViewById(R.id.milk);
        addBabyAniaml=findViewById(R.id.add_baby);
        farmAnimals=findViewById(R.id.farm_animals);
        fortifications=findViewById(R.id.fortifications);

        milk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityMilk();
            }
        });

        farmAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityFarmAnimals();
            }
        });

        fortifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityFortifications();
            }
        });

        addBabyAniaml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityAddBabyAnimal();
            }
        });
    }

    public void openActivityMilk() {
        Intent intent = new Intent(this, Milk.class);
        startActivity(intent);

    }
    public void openActivityFarmAnimals() {
        Intent intent = new Intent(this, FarmAnimals.class);
        startActivity(intent);


    }
    public void openActivityFortifications() {
        Intent intent = new Intent(this, Fortifications.class);
        startActivity(intent);

    }
    public void openActivityAddBabyAnimal() {
        Intent intent = new Intent(this, BabyAnimal_Activity.class);
        startActivity(intent);

    }


}