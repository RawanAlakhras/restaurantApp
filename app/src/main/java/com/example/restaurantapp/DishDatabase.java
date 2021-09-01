package com.example.restaurantapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {Dish.class}, version = 1)
public abstract class DishDatabase extends RoomDatabase {
    public abstract DishDao dishDao();
}
