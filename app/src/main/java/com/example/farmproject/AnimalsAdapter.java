package com.example.farmproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AnimalsAdapter extends RecyclerView.Adapter <AnimalsAdapter.AnimalsHolder>{

    public static final String EXTRA_TEXT="com.example.farmproject.EXTRA_TEXT";

    List<FarmAnimal> farmAnimal;
    List<String> f;
    Context context;
    /*
    public AnimalsAdapter(List<FarmAnimal> farmAnimal,Context context){
        this.farmAnimal=farmAnimal;
        this.context=context;

    }**/
    public AnimalsAdapter(List<String> farmAnimal,Context context){
        this.f=farmAnimal;
        this.context=context;

    }



    @NonNull
    @Override
    public AnimalsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View row= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_animal,parent,false);
        AnimalsHolder holder=new AnimalsHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalsHolder holder, int position) {
       /* final FarmAnimal f=farmAnimal.get(position);
        holder.button.setText(f.animal_id);
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String textName=f.animal_id;
                Intent intent=new Intent(context,DataAnimal.class);
                intent.putExtra(EXTRA_TEXT,textName);
                context.startActivity(intent);
            }
        });**/
         final String s=f.get(position);
       holder.button.setText(s);
       holder.button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent intent=new Intent(context,DataAnimals.class);
               intent.putExtra(EXTRA_TEXT,s);
               context.startActivity(intent);
           }
       });
    }

    @Override
    public int getItemCount() {
      //  return farmAnimal.size();
        return f.size();
    }


    public void filterList(ArrayList<FarmAnimal> filteredList){
        farmAnimal=filteredList;
        notifyDataSetChanged();
    }

    class AnimalsHolder  extends RecyclerView.ViewHolder{

        Button button;
        public AnimalsHolder(@NonNull View itemView) {
            super(itemView);
            button=itemView.findViewById(R.id.animal_id);
        }
    }
}