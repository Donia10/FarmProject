package com.example.farmproject;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

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

public class BabyAnimalId extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabse;
    private DatabaseReference databaseRef;
    private RecyclerView recyclerView;
    private BabyIDAdapter babyIDAdapter;
    private ChildEventListener childEventListener;

    private List<FarmAnimal> f=new ArrayList<>();
    private List<String> babyids=new ArrayList<>();

    EditText search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby_animal_id);

        //toolbar
        Toolbar toolbar_animals = (Toolbar) findViewById(R.id.babyID);
        setSupportActionBar(toolbar_animals);
        getSupportActionBar().setTitle("قطيع المزرعة");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar_animals.setTitleTextColor(Color.WHITE);


        //firebase objects
        firebaseDatabse=FirebaseDatabase.getInstance();
        databaseRef=firebaseDatabse.getReference().child("animals").child("babyId");

        //search EditText
        search = findViewById(R.id.searchBabyId);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                filterl(s.toString());
            }
        });


        databaseRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                if (dataSnapshot.exists()) {
                    String key = dataSnapshot.getKey();
                    babyids.add(key);
                    babyIDAdapter.notifyDataSetChanged();
                }else {
                    Toast.makeText(getApplicationContext(),"Not found Data",Toast.LENGTH_SHORT).show();

                }
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

        recyclerView = findViewById(R.id.recyclerView);
        babyIDAdapter = new BabyIDAdapter(babyids, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(babyIDAdapter);

    }
    private void filterl(String text){
        ArrayList<FarmAnimal> filteredList=new ArrayList<>();
        for(FarmAnimal item :f){
            if(item.getAnimal_id().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }

        babyIDAdapter.filterlist(filteredList);
    }

}
