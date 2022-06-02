package com.example.spiceit_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.example.spiceit_app.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    int[] imageId = {R.drawable.appetizers, R.drawable.main, R.drawable.dessert, R.drawable.healthy, R.drawable.logo};
    String[] course = {"Appetizers", "Main Course", "Dessert", "Healthy Foods", "Drinks"};
    String[] title = {"Chicken wings", "Butter chicken", "Brownies", "Cobb's salad", "Cosmopolitan"};




        MealTypeAdapter mealTypeAdapter = new MealTypeAdapter(course, imageId, MainActivity.this, title);

        binding.mealtypes.setAdapter(mealTypeAdapter);
        binding.mealtypes.setClickable(true);
        binding.mealtypes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, RecipesActivity.class);
                i.putExtra("mealtype", course[position]);
                Log.d(TAG, i.getStringExtra("mealtype"));
                i.putExtra("image", imageId[position]);
                i.putExtra("steps", title[position]);
                startActivity(i);

            }
        });
    }






}