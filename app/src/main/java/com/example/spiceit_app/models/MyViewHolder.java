package com.example.spiceit_app.models;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spiceit_app.R;
import com.example.spiceit_app.ui.CocktailDetailActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.io.Serializable;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView cocktailName;
    TextView cocktailCategory;
    TextView cocktailAlcoholic;
    ImageView imageView;
    Context cont;
    DatabaseReference ref;
    Drink margarita;


    public MyViewHolder(@NonNull View itemView, Context sylvia) {
        super(itemView);

        this.cont = sylvia;

        cocktailName = itemView.findViewById(R.id.cocktailName);
        cocktailCategory = itemView.findViewById(R.id.cocktailCategory);
        cocktailAlcoholic = itemView.findViewById(R.id.cocktailAlcoholic);
        imageView = itemView.findViewById(R.id.cocktailImage);




    }
    public void setCocktailData(Drink cocktail){
        cocktailName.setText(cocktail.getStrDrink());
        cocktailCategory.setText(cocktail.getStrCategory());
        cocktailAlcoholic.setText(cocktail.getStrAlcoholic());
        Picasso.get().load(cocktail.getStrDrinkThumb()).into(imageView);
        margarita = cocktail;


    }

}
