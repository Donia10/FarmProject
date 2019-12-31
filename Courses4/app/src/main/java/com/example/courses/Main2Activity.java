package com.example.courses;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {
    public static  final String  EXTRA ="com.example.courses.EXTRA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent =getIntent();
        String text = intent.getStringExtra(MainActivity.EXTRA_TEXT);


        Toolbar toolbar= (Toolbar) findViewById(R.id.my_toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(text);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(Color.WHITE);


        // code of material button
        Button material= (Button) findViewById(R.id.material);
        material.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialActivity();
            }
        });

    }
    public void materialActivity(){
        Intent intent=new Intent(this,Materials.class);

        Intent intent1 =getIntent();
        String text = intent1.getStringExtra(MainActivity.EXTRA_TEXT);
        intent.putExtra(EXTRA,text);
        startActivity(intent);
    }
}
