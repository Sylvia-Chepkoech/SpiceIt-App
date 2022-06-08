package com.example.spiceit_app.network;

import com.example.spiceit_app.models.Drink;
import com.example.spiceit_app.models.RandomCocktails;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("search.php")
    Call<RandomCocktails> getCocktails(
            @Query("f") char a

    );

//    @GET("search.php")
//    Call<SearchableInfo> getCocktailByName(
//            @Query("search") String searchQuery
//    );
}
