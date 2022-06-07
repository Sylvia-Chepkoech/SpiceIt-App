package com.example.spiceit_app.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static Retrofit retrofit = null;

    public static Api getClient() {
        if (retrofit == null){

            retrofit = new Retrofit.Builder()
                    .baseUrl("COCKTAIL_BASE_URL")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit.create(Api.class);
    }

}
