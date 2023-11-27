package com.spring.jdbc.hoxtify.controller;

import com.spring.jdbc.hoxtify.dao.DaoImpl;
import com.spring.jdbc.hoxtify.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ArtistController {
    @Autowired
    DaoImpl artistDao;

    @GetMapping("/artists")
    public ResponseEntity<List<Artist>> getAllTutorials(@RequestParam(required = false) String title) {
        try {
            List<Artist> artists = new ArrayList<>(artistDao.getList());

            if (artists.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(artists, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
