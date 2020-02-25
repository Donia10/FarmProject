package com.example.farmproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String CHECK ="com.example.farmproject.CHECK";

    Button milk;
    Button farmAnimals;
    Button fortifications;
    Button addBabyAniaml;
    Button loseAnimal;
    Button addnewanimal;
    Button pollinations;

    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
//objects
        milk=findViewById(R.id.milk);
        addBabyAniaml=findViewById(R.id.add_baby);
        farmAnimals=findViewById(R.id.farm_animals);
        fortifications=findViewById(R.id.fortifications);
        loseAnimal=findViewById(R.id.lost_animal);
        addnewanimal=findViewById(R.id.add_animal);
        pollinations=findViewById(R.id.Pollination);

        milk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityMilk();
            }
        });

        farmAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityChooseId();
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

        loseAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityMissedAnimal();
            }
        });

        addnewanimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityNewAnimal();

            }
        });

        pollinations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitypollination();

            }
        });
    }

    public void openActivityMilk() {
        Intent intent = new Intent(this, FarmAnimals.class);
        String milk="milk";
        intent.putExtra(CHECK,milk);
        startActivity(intent);

    }
    public void openActivityChooseId() {
        Intent intent = new Intent(this, ChooseTypeId.class);
        startActivity(intent);


    }
    public void openActivityFortifications() {
        Intent intent = new Intent(this, FarmAnimals.class);
        String forti="fortification";
        intent.putExtra(CHECK,forti);
        startActivity(intent);

    }
    public void openActivityAddBabyAnimal() {
        Intent intent = new Intent(this, BabyAnimal_Activity.class);
        startActivity(intent);

    }
    public void openActivityMissedAnimal() {
        Intent intent = new Intent(this, FarmAnimals.class);
        String missed="missedanimal";
        intent.putExtra(CHECK,missed);
        startActivity(intent);

    }

    public void openActivityNewAnimal() {
        Intent intent = new Intent(this,newAnimal.class);
        startActivity(intent);

    }

    public void openActivitypollination(){
        Intent intent = new Intent(this,Pollination.class);
        startActivity(intent);
    }



}