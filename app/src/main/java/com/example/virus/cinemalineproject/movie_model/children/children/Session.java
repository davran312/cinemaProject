package com.example.virus.cinemalineproject.movie_model.children.children;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Session {
    @SerializedName("h_name")
    private String hallName;
    @SerializedName("sessions")
    private String sessions;





    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public String getSessions() {
        return sessions;
    }

    public void setSessions(String sessions) {
        this.sessions = sessions;
    }

}
