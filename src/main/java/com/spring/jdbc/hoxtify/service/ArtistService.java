package com.spring.jdbc.hoxtify.service;

import com.spring.jdbc.hoxtify.dao.ArtistDaoImpl;
import com.spring.jdbc.hoxtify.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {
    @Autowired
    private ArtistDaoImpl artistDao;

    public List<Artist> getArtistList() {
        return artistDao.getArtistList();
    }

    public Artist getArtistById(int id) {
        return artistDao.getArtistById(id);
    }
}
