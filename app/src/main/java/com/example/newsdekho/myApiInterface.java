package com.example.newsdekho;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface myApiInterface {

    @GET("top-headlines")
    Call<ResponseModel> getLatestNews(@Query("country") String source, @Query("apiKey") String apiKey);

}
