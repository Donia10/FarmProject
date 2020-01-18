package com.example.farmproject;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FarmAnimals extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AnimalsAdapter animalsAdapter;

    private List<FarmAnimal>f=new ArrayList<>();

    EditText search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm_animals);

        //toolbar
        Toolbar toolbar_animals=(Toolbar) findViewById(R.id.tl_animals);
        setSupportActionBar(toolbar_animals);
        getSupportActionBar().setTitle("قطيع المزرعة");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar_animals.setTitleTextColor(Color.WHITE);

        search=findViewById(R.id.searchId);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
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
        f.add(new FarmAnimal("واحد"));
        f.add(new FarmAnimal("اثنان "));
        f.add(new FarmAnimal("2"));
        f.add(new FarmAnimal("1"));
        f.add(new FarmAnimal("1"));
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        animalsAdapter=new AnimalsAdapter(f,this);
        recyclerView.setAdapter(animalsAdapter);


    }
    private void filter(String text){
        ArrayList<FarmAnimal> filteredList=new ArrayList<>();
        for(FarmAnimal item :f){
           if(item.getAnimal_id().toLowerCase().contains(text.toLowerCase())){
               filteredList.add(item);
           }
        }
        animalsAdapter.filterList(filteredList);
    }

}
