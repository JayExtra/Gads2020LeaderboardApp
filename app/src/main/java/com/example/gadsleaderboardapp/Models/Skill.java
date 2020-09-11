package com.example.gadsleaderboardapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Skill {


    @SerializedName("name")
    @Expose
    private String username;

    @SerializedName("score")
    @Expose
     private Integer score;

    @SerializedName("country")
    @Expose
     private String country;

    @SerializedName("badgeUrl")
    @Expose
    private String badgeUrl;


    public void setUsername(String username) {
        this.username = username;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }



    public String getUsername() {
        return username;
    }

    public Integer getScore() {
        return score;
    }

    public String getCountry() {
        return country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }
}
