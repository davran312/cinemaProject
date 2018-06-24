package com.example.virus.cinemalineproject.theatre_model.children;

import com.google.gson.annotations.SerializedName;

public class Theatre {
    @SerializedName("name")
    private String name;
    @SerializedName("image")
    private String image;
    @SerializedName("vote")
    private String vote;
    @SerializedName("count_vote")
    private String count_vote;
    @SerializedName("phone")
    private String phoneNumber;
    @SerializedName("address")
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
