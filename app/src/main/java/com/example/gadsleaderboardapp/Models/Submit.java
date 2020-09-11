package com.example.gadsleaderboardapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Submit {


@SerializedName("Email Address")
@Expose
private String email;

@SerializedName("Name")
@Expose
private String username;

    @SerializedName("Last Name")
    @Expose
private String lastname;

    @SerializedName("Link to Project")
    @Expose
private String link;

    public Submit(String email, String username, String lastname, String link) {
        this.email = email;
        this.username = username;
        this.lastname = lastname;
        this.link = link;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
