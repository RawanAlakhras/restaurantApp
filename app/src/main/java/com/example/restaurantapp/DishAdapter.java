package com.example.restaurantapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


//1-create class with extends
//2-implement the 3 method
//3-create class ViewHolder
public class DishAdapter extends RecyclerView.Adapter<DishAdapter.ViewHolder>{
    List <Dish>allDish=new ArrayList<>();

    public DishAdapter(List<Dish> allDish) {
        this.allDish = allDish;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        // 4- The model object
        public Dish dish;
        // 5- view object
        View itemView;
        // + setting the itemView value
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView=itemView;
            //set on click on fragement to handel item's click
            itemView.findViewById(R.id.frag).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(),DishDescription.class);
                    //send data to DishDescription activity
                   i.putExtra("name",dish.name);
                    i.putExtra("price",dish.getPrice());
                    i.putExtra("ingredients",dish.getIngredients());
                    v.getContext().startActivity(i);
                }
            });
        }
    }
    @NonNull
    @Override
    public DishAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 6- create the view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_dish,parent,false);
        ViewHolder dishViewHolder = new ViewHolder(view);

        return dishViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull DishAdapter.ViewHolder holder, int position) {
        holder.dish = allDish.get(position);

        TextView tv1 = holder.itemView.findViewById(R.id.name);
        TextView tv2 = holder.itemView.findViewById(R.id.price);

        tv1.setText(holder.dish.getName());
        tv2.setText(holder.dish.getPrice());

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i=new Intent(this,DishDescription.class);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return allDish.size();
    }


}
