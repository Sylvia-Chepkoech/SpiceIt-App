package com.example.spiceit_app.network;

import com.example.spiceit_app.models.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static Retrofit retrofit = null;

    public static Api getClient() {
        if (retrofit == null){

            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.COCKTAIL_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit.create(Api.class);
    }

}
