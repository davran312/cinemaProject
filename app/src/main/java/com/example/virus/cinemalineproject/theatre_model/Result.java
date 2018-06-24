package com.example.virus.cinemalineproject.theatre_model;

import com.example.virus.cinemalineproject.theatre_model.children.Theatre;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Result {
    @SerializedName("unmain")
    private ArrayList<Theatre> theatres;

    public ArrayList<Theatre> getTheatres() {
        return theatres;
    }

    public void setTheatres(ArrayList<Theatre> theatres) {
        this.theatres = theatres;
    }
}
