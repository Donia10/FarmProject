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

public class BabyIDAdapter  extends RecyclerView.Adapter<BabyIDAdapter.BabyHolder>{

    public static final String EXTRA_TXT="com.example.farmproject.EXTRA_TXT";

    List<FarmAnimal> farmAnimal;
    List<String> farm;
    Context context;

    public BabyIDAdapter(List<String> farm, Context context) {
        this.farm = farm;
        this.context = context;
    }

    @NonNull
    @Override
    public BabyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View babyRow= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_baby_animal,parent,false);
        BabyHolder babyHolder=new BabyHolder(babyRow);
        return babyHolder;    }

    @Override
    public void onBindViewHolder(@NonNull final BabyHolder holder, int position) {

        final String s=farm.get(position);
        holder.button.setText(s);
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(context,DataBaby.class);
                i.putExtra(EXTRA_TXT,s);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return farm.size();
    }

    public void filterlist(ArrayList<FarmAnimal> filteredList){
        farmAnimal=filteredList;
        notifyDataSetChanged();
    }
    class BabyHolder  extends RecyclerView.ViewHolder{

        Button button;
        public BabyHolder(@NonNull View itemView) {
            super(itemView);
            itemView.getContext();
            button=itemView.findViewById(R.id.babyB_id);
        }
    }
}
