package com.spring.jdbc.hoxtify.model;

import java.util.ArrayList;

public class Genre {
    private long id;
    private String name;
    private String image;
    private ArrayList<User> users = new ArrayList<>();

    public Genre() {
    }

    public Genre(long id, String name, String image, ArrayList<User> users) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.users = users;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
