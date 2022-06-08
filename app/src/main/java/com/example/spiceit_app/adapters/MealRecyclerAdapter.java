package com.example.spiceit_app.adapters;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.example.spiceit_app.models.RandomCocktails;

import java.util.List;

public class MealRecyclerAdapter extends RecyclerView.Adapter<MealTypeAdapter.MealViewHolder> {
    private Context context;
    private List<RandomCocktails> allCocktails;

    public MealRecyclerAdapter(Context context, List<RandomCocktails> allCocktails) {
        this.context = context;
        this.allCocktails = allCocktails;
    }
}
