package com.example.farmproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DataAnimal extends AppCompatActivity {

    public static final String EXTRA="com.example.farmproject.EXTRA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_animal);

        //Intent
        Intent intent=getIntent();
        String textToolbar=intent.getStringExtra(AnimalsAdapter.EXTRA_TEXT);

        //ToolBar
        Toolbar toolbar=findViewById(R.id.tlData);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("حيوان رقم "+textToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
