package com.example.virus.cinemalineproject.apies;

import com.example.virus.cinemalineproject.theatre_model.TheatreFeed;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TheatreApi {
    public final String BASE_URL = "https://kinoafisha.ua/ajax/";

    @GET("kinoteatrs_load")
    Call<TheatreFeed> getTheatres();
}
