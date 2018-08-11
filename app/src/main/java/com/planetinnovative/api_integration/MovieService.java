package com.planetinnovative.api_integration;

import com.planetinnovative.api_integration.Moview.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface  MovieService {
    @GET("123?api_key=d5964a8f114f649087dad1f842c55fb9")
    public Call<MovieResponse> getMovie();
}
