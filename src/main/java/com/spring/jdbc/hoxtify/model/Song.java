package com.spring.jdbc.hoxtify.model;

import java.util.ArrayList;
import java.util.List;

public class Song {
    private long id;
    private String title;
    private String src;
    private String image;
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Artist> artists = new ArrayList<>();
    private ArrayList<Playlist> playlists = new ArrayList<>();
    private Genre genre;

    public Song() {
    }

    public Song(long id, String title, String src, String image, ArrayList<User> users, ArrayList<Artist> artists, ArrayList<Playlist> playlists, Genre genre) {
        this.id = id;
        this.title = title;
        this.src = src;
        this.image = image;
        this.users = users;
        this.artists = artists;
        this.playlists = playlists;
        this.genre = genre;
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

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
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

    public ArrayList<Artist> getArtists() {
        return artists;
    }

    public void setArtists(ArrayList<Artist> artists) {
        this.artists = artists;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
