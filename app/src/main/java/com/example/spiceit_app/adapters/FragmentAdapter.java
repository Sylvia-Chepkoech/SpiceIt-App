package com.example.spiceit_app.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.spiceit_app.fragments.CocktailFragment;
import com.example.spiceit_app.models.Drink;

import java.util.List;

public class FragmentAdapter extends FragmentPagerAdapter {

    List<Drink> allDrinks;



    public FragmentAdapter(@NonNull FragmentManager fm, int behavior,  List<Drink> allDrinks) {
        super(fm, behavior);
        this.allDrinks = allDrinks;

    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        CocktailFragment cocktailFragment = CocktailFragment.newInstance(allDrinks.get(position));
        return cocktailFragment;
    }

    @Override
    public int getCount() {
        return allDrinks.size();
    }
}
