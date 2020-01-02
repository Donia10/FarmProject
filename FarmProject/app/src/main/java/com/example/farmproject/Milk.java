package com.example.farmproject;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class Milk extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milk);
       //toolbar
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("كمية إدرار اللبن");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(Color.WHITE);
        //spinner
        Spinner spinner=findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.items, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        EditText editText1=findViewById(R.id.item1);
        EditText editText2=findViewById(R.id.item2);
        EditText editText3=findViewById(R.id.item3);

        if(position==1){
            editText1.setVisibility(View.VISIBLE);
            editText2.setVisibility(View.GONE);
            editText3.setVisibility(View.GONE);

        }else if(position==2){
            editText1.setVisibility(View.VISIBLE);
            editText2.setVisibility(View.VISIBLE);
            editText3.setVisibility(View.GONE);

        }else if(position==3){
            editText1.setVisibility(View.VISIBLE);
            editText2.setVisibility(View.VISIBLE);
            editText3.setVisibility(View.VISIBLE);

        }else {
            editText1.setVisibility(View.GONE);
            editText2.setVisibility(View.GONE);
            editText3.setVisibility(View.GONE);

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
