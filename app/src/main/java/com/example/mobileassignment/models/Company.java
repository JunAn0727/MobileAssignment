package com.example.mobileassignment.models;

public class Company {
    private String location;
    private User user;

    public Company(){
    }

    public Company(String location, User user) {
        this.location = location;
        this.user = user;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
