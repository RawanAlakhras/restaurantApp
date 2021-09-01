package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        DishDatabase db = Room.databaseBuilder(getApplicationContext(),DishDatabase.class, "dish_item").allowMainThreadQueries().build();
        DishDao dishDao=db.dishDao();
        List<Dish> allDish = dishDao.getAll();
        RecyclerView rv=findViewById(R.id.recyclerview);
        // set a layout manager for this view
        rv.setLayoutManager(new LinearLayoutManager(this));
        // set the adapter for this recyclerView
        rv.setAdapter(new DishAdapter(allDish));
    }
}