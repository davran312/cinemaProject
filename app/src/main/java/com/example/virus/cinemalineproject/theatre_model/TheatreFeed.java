package com.example.virus.cinemalineproject.theatre_model;

import com.example.virus.cinemalineproject.theatre_model.children.Theatre;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TheatreFeed {
    @SerializedName("succes")
    private boolean succes;
    @SerializedName("count")
    private int count;
    @SerializedName("result")
    Result result;

    public boolean isSucces() {
        return succes;
    }

    public void setSucces(boolean succes) {
        this.succes = succes;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
