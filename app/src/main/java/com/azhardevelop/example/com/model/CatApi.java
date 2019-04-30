package com.azhardevelop.example.com.model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CatApi {
    //ini adalah URL database-nya
    private static final String CAT_URL = "https://api.thecatapi.com/";
    private static Retrofit retrofit;

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(CAT_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
