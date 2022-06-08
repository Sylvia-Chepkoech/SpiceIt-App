package com.example.spiceit_app.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.spiceit_app.R;
import com.example.spiceit_app.databinding.FragmentCocktailBinding;
import com.example.spiceit_app.models.Drink;
import com.squareup.picasso.Picasso;


import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CocktailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CocktailFragment extends Fragment {

    Drink drink;
    FragmentCocktailBinding cocktailBinding;



    public CocktailFragment() {
        // Required empty public constructor
    }


    public static CocktailFragment newInstance(Drink cocktail) {
        CocktailFragment fragment = new CocktailFragment();
        Bundle args = new Bundle();
        args.putSerializable("cocktailDrink", cocktail);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            drink = (Drink) getArguments().getSerializable("cocktailDrink");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        cocktailBinding = FragmentCocktailBinding.inflate(inflater, container, false);
        View v = cocktailBinding.getRoot();

        cocktailBinding.course.setText(drink.getStrDrink());
        cocktailBinding.ingredients1.setText(drink.getStrIngredient1());
        cocktailBinding.ingredients2.setText(drink.getStrIngredient2());
        cocktailBinding.ingredients3.setText(drink.getStrIngredient3());
        cocktailBinding.ingredients4.setText(drink.getStrIngredient4());
        cocktailBinding.ingredients5.setText((CharSequence) drink.getStrIngredient5());
        cocktailBinding.instructions.setText(drink.getStrInstructions());
        cocktailBinding.measure1.setText(drink.getStrMeasure1());
        cocktailBinding.measure2.setText(drink.getStrMeasure2());
        cocktailBinding.measure3.setText(drink.getStrMeasure3());
        cocktailBinding.measure4.setText(drink.getStrMeasure4());

        cocktailBinding.recipe.setText(drink.getStrGlass());
        Picasso.get().load(drink.getStrDrinkThumb()).into(cocktailBinding.mealImage);





        return v;
    }
}