package com.tindia.network;


import com.tindia.model.AppBundle;
import com.tindia.model.Destination;
import com.tindia.model.DetailResponse;
import com.tindia.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {
    @GET("films")
    Call<List<Movie>> getMovies();


    @GET("bundle")
    Call<AppBundle> getBundle();

    @GET("destination")
    Call<List<Destination>> getDestination();

    @GET("getdestination")
    Call<DetailResponse> getDetailResponse(@Query("cityId") int cityId);
}