package com.example.spiceit_app.interfaces;

import android.app.SearchableInfo;

import com.example.spiceit_app.models.RandomCocktails;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("random.php")
    Call<RandomCocktails> getRandomCocktails();

    @GET("search.php")
    Call<SearchableInfo> getCocktailByName(
            @Query("search") String searchQuery
    );
}
