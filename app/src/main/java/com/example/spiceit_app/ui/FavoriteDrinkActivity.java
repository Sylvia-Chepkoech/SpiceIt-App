package com.example.spiceit_app.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.spiceit_app.R;
import com.example.spiceit_app.adapters.MealRecyclerAdapter;
import com.example.spiceit_app.models.Constants;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;

public class FavoriteDrinkActivity extends AppCompatActivity {
    @BindView(R.id.recyclerView)
    RecyclerView myRecycler;
    @BindView(R.id.progressBar)
    ProgressBar progress;
    MealRecyclerAdapter adapt;
    RecyclerView.LayoutManager layoutManager;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reference = FirebaseDatabase.getInstance().getReference().child(Constants.DRINKS);

    }
}