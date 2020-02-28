package com.example.farmproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class FarmAnimals extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabse;
    private DatabaseReference databaseRef;
    private RecyclerView recyclerView;
    private AnimalsAdapter animalsAdapter;
    private ChildEventListener childEventListener;

    private List<FarmAnimal>f=new ArrayList<>();
    private List<String> ss=new ArrayList<>();

    EditText search;

    public String check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm_animals);

        Intent intent=getIntent();
        check=intent.getStringExtra(MainActivity.CHECK);

        //toolbar
        Toolbar toolbar_animals = (Toolbar) findViewById(R.id.tl_animals);
        setSupportActionBar(toolbar_animals);
        getSupportActionBar().setTitle("قطيع المزرعة");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar_animals.setTitleTextColor(Color.WHITE);

        //firebase objects
        firebaseDatabse=FirebaseDatabase.getInstance();
        databaseRef=firebaseDatabse.getReference().child("animals").child("animalId");

        //search EditText
        search = findViewById(R.id.searchId);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }


            @Override
            public void afterTextChanged(Editable s) { filter(s.toString());
            }
        });

        //listView&&Adapter
       /* listView=findViewById(R.id.list_item);
        List<FarmAnimal> farmAnimal=new ArrayList<>();
        farmAnimal.add(new FarmAnimal("واحد"));
        farmAnimal.add(new FarmAnimal("اثنان"));
        farmAnimal.add(new FarmAnimal("واحد"));
        farmAnimal.add(new FarmAnimal("1"));
        farmAnimal.add(new FarmAnimal("واحد"));
        farmAnimal.add(new FarmAnimal("5"));
        // animalsAdapter =new AnimalsAdapter(this,R.layout.item_animal,farmAnimal);
        animalsAdapter=new AnimalsAdapter(this,R.layout.item_animal,farmAnimal);
        listView.setAdapter(animalsAdapter);**/
       /*
        f.add(new FarmAnimal("واحد"));
        f.add(new FarmAnimal("اثنان "));
        f.add(new FarmAnimal("2"));
        f.add(new FarmAnimal("1"));
        f.add(new FarmAnimal("1"));
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        animalsAdapter=new AnimalsAdapter(f,this);
        recyclerView.setAdapter(animalsAdapter);**/


/*
        animalsAdapter=new AnimalsAdapter(f,this);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(animalsAdapter);**/


        databaseRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                String key =dataSnapshot.getKey();
                ss.add(key);
                animalsAdapter.notifyDataSetChanged();
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


        recyclerView=findViewById(R.id.recyclerView);
        animalsAdapter=new AnimalsAdapter(ss,this,check);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(animalsAdapter);

    }
    /*
    private void filters(String text){
        ArrayList<String> filteredList=new ArrayList<>();
        for(String item :far){
            if(item.getAnimal_id().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }
        animalsAdapter.filterList(filteredList);
    }**/

    private void filter(String text){
        ArrayList<String> filteredList=new ArrayList<>();
        for(String item :ss){
           if(item.toLowerCase().contains(text.toLowerCase())){
               filteredList.add(item);
           }
        }
        animalsAdapter.filterList(filteredList);
    }





}