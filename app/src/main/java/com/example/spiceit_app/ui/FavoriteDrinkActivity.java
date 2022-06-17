package com.example.spiceit_app.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.spiceit_app.R;
import com.example.spiceit_app.adapters.MealRecyclerAdapter;
import com.example.spiceit_app.models.Constants;
import com.example.spiceit_app.models.Drink;
import com.example.spiceit_app.models.MyViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavoriteDrinkActivity extends AppCompatActivity {
    @BindView(R.id.recyclerView)
    RecyclerView myRecycler;
    @BindView(R.id.progressBar)
    ProgressBar progress;
//    FirebaseRecyclerAdapter adapt;
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

        ButterKnife.bind(this);

        layoutManager = new LinearLayoutManager(FavoriteDrinkActivity.this, RecyclerView.VERTICAL, false);


        drinkList = new ArrayList<>();

        reference = FirebaseDatabase.getInstance().getReference().child(Constants.DRINKS);
//        FirebaseRecyclerOptions<Drink> myDrinks = new FirebaseRecyclerOptions.Builder<Drink>().setQuery(reference, Drink.class).build();
//        adapt = new FirebaseRecyclerAdapter<Drink, MyViewHolder>(myDrinks) {
//            @NonNull
//            @Override
//            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.meal_item, parent, false);
//                MyViewHolder viewHolder = new MyViewHolder(view, FavoriteDrinkActivity.this);
//                return viewHolder;
//            }
//
//            @Override
//            protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull Drink model) {
//                holder.setCocktailData(model);
//                Log.d("drinkName", model.getStrCategory());
//            }
//        };

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    Drink drink = snapshot1.getValue(Drink.class);
                    drinkList.add(drink);
                }
                adapt.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        adapt = new MealRecyclerAdapter(FavoriteDrinkActivity.this, drinkList);
        myRecycler.setAdapter(adapt);
        myRecycler.setLayoutManager(layoutManager);
        myRecycler.setHasFixedSize(true);
        myRecycler.setVisibility(View.VISIBLE);
        progress.setVisibility(View.GONE);
        saveButton.setVisibility(View.GONE);



    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        adapt.startListening();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        adapt.stopListening();
//    }
}