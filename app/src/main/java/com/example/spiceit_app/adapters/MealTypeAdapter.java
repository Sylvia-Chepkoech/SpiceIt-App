package com.example.spiceit_app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.spiceit_app.R;

import java.util.ArrayList;
import java.util.List;

public class MealTypeAdapter extends BaseAdapter {

  String[] foodType;
  int[] images;
    Context context;

    String[] recipes;

    public MealTypeAdapter(String[] foodType, int[] images, Context context, String[] recipes) {
        this.foodType = foodType;
        this.images = images;
        this.context = context;
        this.recipes = recipes;
    }

    @Override
    public int getCount() {
        return foodType.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {



        if (convertView == null){

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.meal_item, null);
        }

//            ImageView imageView = convertView.findViewById(R.id.mealimage);
//        TextView course = convertView.findViewById(R.id.mealtype);
//        TextView recipesText = convertView.findViewById(R.id.recipe_item);



//        imageView.setImageResource(images[position]);
//        course.setText(foodType[position]);
//        recipesText.setText(recipes[position]);




        return convertView;
    }
}
