package com.example.virus.cinemalineproject.movie_model.children;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.virus.cinemalineproject.movie_model.children.children.Session;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Movie implements Parcelable {

    @SerializedName("name")
    private String name;
    @SerializedName("url")
    private String url;
    @SerializedName("image")
    private String image;
    @SerializedName("vote")
    private String vote;
    @SerializedName("count_vote")
    private String count_vote;
    @SerializedName("countries")
    private String countries;
    @SerializedName("actors")
    private String actors;
    @SerializedName("rejisser")
    private String rejissers;
    @SerializedName("premier_ua")
    private String premier_ua;
    @SerializedName("sessions")
    private List<Session> sessionList;
    @SerializedName("age_limit")
    private int age_limit;

    public Movie(Parcel in) {
        name = in.readString();
        url = in.readString();
        image = in.readString();
        vote = in.readString();
        count_vote = in.readString();
        countries = in.readString();
        actors = in.readString();
        rejissers = in.readString();
        premier_ua = in.readString();
        age_limit = in.readInt();
    }


    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image ;
    }

    public void setMovieImageList(String image) {
        this.image = image;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public String getCount_vote() {
        return count_vote;
    }

    public void setCount_vote(String count_vote) {
        this.count_vote = count_vote;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }



    public String getPremier_ua() {
        return premier_ua;
    }

    public void setPremier_ua(String premier_ua) {
        this.premier_ua = premier_ua;
    }

    public int getAge_limit() {
        return age_limit;
    }

    public void setAge_limit(int age_limit) {
        this.age_limit = age_limit;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getRejissers() {
        return rejissers;
    }

    public void setRejissers(String rejissers) {
        this.rejissers = rejissers;
    }

    public List<Session> getSessionArrayList() {
        return sessionList;
    }

    public void setSessionArrayList(ArrayList<Session> sessionArrayList) {
        this.sessionList = sessionArrayList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(name);
        dest.writeString(url);
        dest.writeString(image);
        dest.writeString(vote);
        dest.writeString(count_vote);
        dest.writeString(countries);
        dest.writeString(actors);
        dest.writeString(rejissers);
        dest.writeString(premier_ua);
        dest.writeInt(age_limit);

    }
}
