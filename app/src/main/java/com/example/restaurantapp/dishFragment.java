package com.example.restaurantapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link dishFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
//create the fragment that represents a single item
public class dishFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String NAME = "dishName";
    private static final String PRICE = "dishPrice";
    private static final String INGREDIENTS = "dishIngredients";


    // TODO: Rename and change types of parameters
    private String dishName;
    private String dishPrice;
    private String dishIngredients;

    public dishFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment dishFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static dishFragment newInstance(String param1, String param2,String param3) {
        dishFragment fragment = new dishFragment();
        Bundle args = new Bundle();
        args.putString(NAME, param1);
        args.putString(PRICE, param2);
        args.putString(INGREDIENTS, param3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            dishName = getArguments().getString(NAME);
            dishPrice = getArguments().getString(PRICE);
            dishIngredients = getArguments().getString(INGREDIENTS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_menu, container, false);
    }
}