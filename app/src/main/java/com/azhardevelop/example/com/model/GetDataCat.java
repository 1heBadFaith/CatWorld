package com.azhardevelop.example.com.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataCat {
    //ini adalah URL Parameter
    @GET("v1/breeds")
    Call<List<ApiServiceCat>> getAllInfo();

}
