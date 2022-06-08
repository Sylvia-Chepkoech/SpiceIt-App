package com.example.spiceit_app.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;

import android.os.Bundle;

import com.example.spiceit_app.R;
import com.example.spiceit_app.adapters.FragmentAdapter;
import com.example.spiceit_app.databinding.ActivityCocktailDetailBinding;
import com.example.spiceit_app.models.Drink;


import java.util.List;

public class CocktailDetailActivity extends AppCompatActivity {
    ActivityCocktailDetailBinding detailBinding;
    FragmentAdapter adapt;
    List<Drink> cocktails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detailBinding = ActivityCocktailDetailBinding.inflate(getLayoutInflater());
        setContentView(detailBinding.getRoot());

        int position = getIntent().getIntExtra("position", 0);
        cocktails = (List<Drink>) getIntent().getSerializableExtra("cock");

        adapt = new FragmentAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, cocktails);

        detailBinding.viewPager.setAdapter(adapt);
        detailBinding.viewPager.setCurrentItem(position);
    }
}