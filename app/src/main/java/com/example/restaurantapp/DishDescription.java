package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DishDescription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_description);

        Intent i =getIntent();

        String name = i.getExtras().getString("name");

        String price=i.getExtras().getString("price");
        String ingredients=i.getExtras().getString("ingredients");
        TextView tv1=findViewById(R.id.name1);
        tv1.setText(name);
        TextView tv2=findViewById(R.id.price);
        tv2.setText(price);
        TextView tv3=findViewById(R.id.i);
        tv3.setText(ingredients);


    }
}