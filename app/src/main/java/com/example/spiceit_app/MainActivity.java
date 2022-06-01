package com.example.spiceit_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.spiceit_app.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    int[] imageId = {R.drawable.appetizers, R.drawable.main, R.drawable.dessert, R.drawable.healthy, R.drawable.logo};
    String[] course = {"Appetizers", "Main Course", "Dessert", "Healthy Foods", "Drinks"};
    String [] recipes = {"Chicken wings", "Butter chicken", "Chocolate cake", "Cobbs salad", "Cosmopolitan"};


        ArrayList<MealCourse> mealCourseArrayList = new ArrayList<>();

        for(int i = 0; i< imageId.length; i++) {
            MealCourse mealCourse = new MealCourse(course[i], recipes[i], imageId[i]);
        }

        MealTypeAdapter mealTypeAdapter = new MealTypeAdapter(MainActivity.this, mealCourseArrayList);

        binding.mealtypes.setAdapter(mealTypeAdapter);
        binding.mealtypes.setClickable(true);
        binding.mealtypes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, RecipesActivity.class);
                i.putExtra("mealtype", course[position]);
                i.putExtra("recipes", recipes[position]);
                i.putExtra("image", imageId[position]);
                startActivity(i);

            }
        });
    }






}