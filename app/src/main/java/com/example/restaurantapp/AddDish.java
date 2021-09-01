package com.example.restaurantapp;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Insert;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddDish extends AppCompatActivity {
    public static final String DISH_ITEM = "dish_item";
    public DishDatabase db;
    public  DishDao dishDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dish);
        db = Room.databaseBuilder(getApplicationContext(),
                DishDatabase.class, DISH_ITEM).allowMainThreadQueries()
                .build();
        dishDao = db.dishDao();


    }
    public void addDishtoDB(View view){
        //get data from edit text
        EditText et1=findViewById(R.id.name);
        EditText et2=findViewById(R.id.price);
        EditText et3=findViewById(R.id.ingredients);


        //create new object and add data to it

        Dish newDish=new Dish(et1.getText().toString(),et2.getText().toString(),et3.getText().toString());

        //save new object in dataBase
        dishDao.insertOne(newDish);
        Toast.makeText(this,"the dish saved you can see it in menu",Toast.LENGTH_SHORT).show();

    }
    public void gomenu(View view){
        Intent i=new Intent(this,Menu.class);
        startActivity(i);
    }
    public void gohome(View view){
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
}