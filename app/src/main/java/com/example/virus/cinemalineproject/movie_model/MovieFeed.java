package com.example.virus.cinemalineproject.movie_model;

import com.example.virus.cinemalineproject.movie_model.children.Movie;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieFeed {
    @SerializedName("succes")
    private boolean success;
    @SerializedName("count")
    private int count;
    @SerializedName("result")
    private List<Movie> movieList;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }
}