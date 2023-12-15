package com.spring.jdbc.hoxtify.service;

import com.spring.jdbc.hoxtify.dao.ArtistDaoImpl;
import com.spring.jdbc.hoxtify.model.Artist;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {
    private final ArtistDaoImpl artistDao;
    public ArtistService(ArtistDaoImpl artistDao) {
        this.artistDao = artistDao;
    }

    public List<Artist> getArtistList() {
        return artistDao.getArtistList();
    }

    public Artist getArtistById(int id) {
        return artistDao.getArtistById(id);
    }

    public void saveArtist(Artist artist) {
        artistDao.saveArtist(artist);
    }

    public void updateArtist(Artist artist) {
        artistDao.updateArtist(artist);
    }
}
