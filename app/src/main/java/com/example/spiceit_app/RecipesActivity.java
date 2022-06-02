package com.example.spiceit_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.spiceit_app.databinding.ActivityMainBinding;
import com.example.spiceit_app.databinding.ActivityRecipesBinding;

public class RecipesActivity extends AppCompatActivity {
    ActivityRecipesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecipesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Intent intent = this.getIntent();

        if (intent != null){
            String course = intent.getStringExtra("mealtype");
            String recipe = intent.getStringExtra("steps");
            int imageid = intent.getIntExtra("image", R.drawable.ic_baseline_fastfood_24);

            binding.course.setText(course);
            binding.recipe.setText(recipe);
            binding.mealImage.setImageResource(imageid);
        }
    }
}