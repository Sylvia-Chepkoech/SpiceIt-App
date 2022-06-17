package com.example.spiceit_app.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SearchView;

import com.example.spiceit_app.adapters.MealRecyclerAdapter;
import com.example.spiceit_app.adapters.MealTypeAdapter;
import com.example.spiceit_app.R;
import com.example.spiceit_app.databinding.ActivityMainBinding;
import com.example.spiceit_app.models.Drink;
import com.example.spiceit_app.models.RandomCocktails;
import com.example.spiceit_app.network.Api;
import com.example.spiceit_app.network.ApiClient;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
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

            binding.saveButton.setOnClickListener(this);
            Api client = ApiClient.getClient();
            Call<RandomCocktails> allCocktails = client.getCocktails("a");

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.cocktails, menu);
        MenuItem item = menu.findItem(R.id.search);
        SearchView userSearch = (SearchView) item.getActionView();

        userSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                Api client = ApiClient.getClient();
                Call<RandomCocktails> allCocktails = client.getCocktails(query);

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


                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        int id = item.getItemId();
        if(id == R.id.logout){
            logout();
        }
        return true;
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(this, LogInActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        if(v == binding.saveButton){
            Intent intent = new Intent(MainActivity.this, FavoriteDrinkActivity.class);
            startActivity(intent);
        }
    }
}