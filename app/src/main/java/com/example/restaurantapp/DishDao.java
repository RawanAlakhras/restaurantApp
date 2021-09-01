package com.example.restaurantapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DishDao {
    @Query("SELECT * FROM dish")
    List<Dish> getAll();

    @Query("SELECT * FROM dish WHERE id IN (:dishIds)")
    List<Dish> loadAllByIds(int[] dishIds);

    @Query("SELECT * FROM dish WHERE name LIKE :name LIMIT 1")
    Dish findByName(String name);

    @Insert
    void insertAll(Dish... dishes);

    @Delete
    void delete(Dish dish);

    @Insert
    void insertOne(Dish dish);
}
