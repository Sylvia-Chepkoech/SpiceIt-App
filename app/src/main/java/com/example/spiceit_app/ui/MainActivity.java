package com.example.spiceit_app.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.example.spiceit_app.adapters.MealRecyclerAdapter;
import com.example.spiceit_app.adapters.MealTypeAdapter;
import com.example.spiceit_app.R;
import com.example.spiceit_app.databinding.ActivityMainBinding;
import com.example.spiceit_app.models.Drink;
import com.example.spiceit_app.models.RandomCocktails;
import com.example.spiceit_app.network.Api;
import com.example.spiceit_app.network.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    List<Drink> allDrinks;
    RecyclerView.LayoutManager manager;
    MealRecyclerAdapter adapter;

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

            Api client = ApiClient.getClient();
            Call<RandomCocktails> allCocktails = client.getCocktails('a');

            allCocktails.enqueue(new Callback<RandomCocktails>() {
                @Override
                public void onResponse(Call<RandomCocktails> call, Response<RandomCocktails> response) {
                    if(response.isSuccessful()){
                        allDrinks = response.body().getDrinks();

                        adapter = new MealRecyclerAdapter(MainActivity.this, allDrinks);
                        binding.recyclerView.setAdapter(adapter);
                        manager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
                        binding.recyclerView.setLayoutManager(manager);
                        binding.recyclerView.setHasFixedSize(true);
                        binding.recyclerView.setVisibility(View.VISIBLE);
                        binding.progressBar.setVisibility(View.GONE);

                        
                    }
                }

                @Override
                public void onFailure(Call<RandomCocktails> call, Throwable t) {

                }
            });




    }






}