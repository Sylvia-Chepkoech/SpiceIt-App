package com.example.spiceit_app.adapters;


import com.example.spiceit_app.R;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spiceit_app.models.Constants;
import com.example.spiceit_app.models.Drink;
import com.example.spiceit_app.models.RandomCocktails;
import com.example.spiceit_app.ui.CocktailDetailActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;


import java.io.Serializable;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MealRecyclerAdapter extends RecyclerView.Adapter<MealRecyclerAdapter.MealViewHolder>  {
    private Context context;
    private List<Drink> allCocktails;

    public MealRecyclerAdapter(Context context, List<Drink> allCocktails) {
        this.context = context;
        this.allCocktails = allCocktails;
    }



    @NonNull
    @Override
    public MealRecyclerAdapter.MealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.meal_item, parent, false);
        MealViewHolder viewHolder = new MealViewHolder(view, context);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MealRecyclerAdapter.MealViewHolder holder, int position) {
        holder.setCocktailData(allCocktails.get(position));

    }

    @Override
    public int getItemCount() {
        return allCocktails.size();
    }

    public class MealViewHolder extends RecyclerView.ViewHolder {
        TextView cocktailName;
        TextView cocktailCategory;
        TextView cocktailAlcoholic;
        ImageView imageView;
        Context cont;
        DatabaseReference ref;
        Drink margarita;


        public MealViewHolder(@NonNull View itemView, Context sylvia) {
            super(itemView);

            this.cont = sylvia;

            cocktailName = itemView.findViewById(R.id.cocktailName);
            cocktailCategory = itemView.findViewById(R.id.cocktailCategory);
            cocktailAlcoholic = itemView.findViewById(R.id.cocktailAlcoholic);
            imageView = itemView.findViewById(R.id.cocktailImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ref = FirebaseDatabase.getInstance().getReference();
                    ref.child(Constants.DRINKS).child(margarita.getIdDrink()).setValue(margarita);

                    int position = getLayoutPosition();
                    Intent i = new Intent(cont, CocktailDetailActivity.class);
                    i.putExtra("position", position);
                    i.putExtra("cock", (Serializable) allCocktails);
                    cont.startActivity(i);
                }
            });


        }
        public void setCocktailData(Drink cocktail){
            cocktailName.setText(cocktail.getStrDrink());
            cocktailCategory.setText(cocktail.getStrCategory());
            cocktailAlcoholic.setText(cocktail.getStrAlcoholic());
            Picasso.get().load(cocktail.getStrDrinkThumb()).into(imageView);
            margarita = cocktail;


        }

    }
}





