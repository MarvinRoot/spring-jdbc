package com.spring.jdbc.hoxtify.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Playlist {
    private long id;
    private String title;
    private ArrayList<Song> songs = new ArrayList<>();
    private User user;

    public Playlist() {
    }

    public Playlist(long id, String title, ArrayList<Song> songs, User user) {
        this.id = id;
        this.title = title;
        this.songs = songs;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
