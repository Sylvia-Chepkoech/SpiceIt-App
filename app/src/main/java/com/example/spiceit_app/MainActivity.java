package com.example.spiceit_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.spiceit_app.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater())
        setContentView(binding.getRoot());

    int[] imageId = {R.drawable.appetizers, R.drawable.main, R.drawable.dessert, R.drawable.healthy, R.drawable.logo};
    String[] course = {"Appetizers", "Main Course", "Dessert", "Healthy Foods", "Drinks"};


    }






}