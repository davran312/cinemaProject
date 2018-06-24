package com.example.virus.cinemalineproject.apies;

import com.example.virus.cinemalineproject.movie_model.MovieFeed;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieApi {
    public final String BASE_URL="https://kinoafisha.ua/ajax/";

    @GET("kinoafisha_load")
    Call<MovieFeed> getMovies();
}
