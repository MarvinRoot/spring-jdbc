package com.spring.jdbc.hoxtify.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private long id;
    private String username;
    private String email;
    private String password;
    private String profileImg;
    private ArrayList<Artist> favoriteArtists = new ArrayList<>();
    private ArrayList<Song> favoriteSongs = new ArrayList<>();
    private ArrayList<Genre> favoriteGenres = new ArrayList<>();

    public User() {
    }

    public User(long id, String username, String email, String password, String profileImg, ArrayList<Artist> favoriteArtists, ArrayList<Song> favoriteSongs, ArrayList<Genre> favoriteGenres) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.profileImg = profileImg;
        this.favoriteArtists = favoriteArtists;
        this.favoriteSongs = favoriteSongs;
        this.favoriteGenres = favoriteGenres;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public ArrayList<Artist> getFavoriteArtists() {
        return favoriteArtists;
    }

    public void setFavoriteArtists(ArrayList<Artist> favoriteArtists) {
        this.favoriteArtists = favoriteArtists;
    }

    public ArrayList<Song> getFavoriteSongs() {
        return favoriteSongs;
    }

    public void setFavoriteSongs(ArrayList<Song> favoriteSongs) {
        this.favoriteSongs = favoriteSongs;
    }

    public ArrayList<Genre> getFavoriteGenres() {
        return favoriteGenres;
    }

    public void setFavoriteGenres(ArrayList<Genre> favoriteGenres) {
        this.favoriteGenres = favoriteGenres;
    }
}