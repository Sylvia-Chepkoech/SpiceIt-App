package com.example.spiceit_app.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.example.spiceit_app.adapters.MealTypeAdapter;
import com.example.spiceit_app.R;
import com.example.spiceit_app.databinding.ActivityMainBinding;
import com.example.spiceit_app.models.RandomCocktails;
import com.example.spiceit_app.network.Api;
import com.example.spiceit_app.network.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    List<RandomCocktails> allDrinks;
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

                Api client = ApiClient.getClient();
                Call<RandomCocktails> allCocktails = client.getCocktails('a');

                allCocktails.enqueue(new Callback<RandomCocktails>() {
                    @Override
                    public void onResponse(Call<RandomCocktails> call, Response<RandomCocktails> response) {

                        if(response.isSuccessful()){
                            allDrinks = response.body().getDrinks();

                            adp = new MealTypeAdapter(allDrinks, MainActivity.this)
                        }
                    }

                    @Override
                    public void onFailure(Call<RandomCocktails> call, Throwable t) {

                    }
                });

            }
        });
    }






}