package com.example.spiceit_app.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.spiceit_app.R;
import com.example.spiceit_app.adapters.MealRecyclerAdapter;
import com.example.spiceit_app.models.Constants;
import com.example.spiceit_app.models.Drink;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class FavoriteDrinkActivity extends AppCompatActivity {
    @BindView(R.id.recyclerView)
    RecyclerView myRecycler;
    @BindView(R.id.progressBar)
    ProgressBar progress;
    MealRecyclerAdapter adapt;
    RecyclerView.LayoutManager layoutManager;
    DatabaseReference reference;
    List<Drink> drinkList;
    @BindView(R.id.saveButton)
    Button saveButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapt = new MealRecyclerAdapter(FavoriteDrinkActivity.this, drinkList);
        layoutManager = new LinearLayoutManager(FavoriteDrinkActivity.this, RecyclerView.VERTICAL, false);
        myRecycler.setAdapter(adapt);
        myRecycler.setLayoutManager(layoutManager);
        myRecycler.setHasFixedSize(true);

        drinkList = new ArrayList<>();

        reference = FirebaseDatabase.getInstance().getReference().child(Constants.DRINKS);
        FirebaseRecyclerOptions<Drink> myDrinks =



        progress.setVisibility(View.GONE);


    }
}