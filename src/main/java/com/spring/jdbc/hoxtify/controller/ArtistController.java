package com.spring.jdbc.hoxtify.controller;

import com.spring.jdbc.hoxtify.exception.ResourceNotFoundException;
import com.spring.jdbc.hoxtify.model.Artist;
import com.spring.jdbc.hoxtify.service.ArtistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ArtistController {
    private final ArtistService artistService;
    public ArtistController(ArtistService service) {
        this.artistService = service;
    }

    @GetMapping("/artists")
    public ResponseEntity<List<Artist>> getAllTutorials(@RequestParam(required = false) String title) {
        try {
            List<Artist> artists = new ArrayList<>(artistService.getArtistList());

            if (artists.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(artists, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/artists/{id}")
    public ResponseEntity<Artist> getArtistById(@PathVariable(value = "id") int id) {

        Artist artist = artistService.getArtistById(id);

        if (artist == null) {
            throw new ResourceNotFoundException("Not found Artist with id = " + id);
        }

        return new ResponseEntity<>(artist, HttpStatus.OK);
    }

    @PostMapping("/artists")
    public ResponseEntity<String> createArtist(@RequestBody Artist artist) {
        try {
            artistService.saveArtist(artist);
            return new ResponseEntity<>("Artist was created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/artists/{id}")
    public ResponseEntity<String> createArtist(@RequestBody Artist artist, @PathVariable(value = "id") int id) {
        try {
            artist.setId(id);
            artistService.updateArtist(artist);
            return new ResponseEntity<>("Artist was updated successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
