package com.spring.jdbc.hoxtify.dao;

import com.spring.jdbc.hoxtify.model.Artist;
import com.spring.jdbc.hoxtify.model.Genre;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ArtistDaoImpl {
    RowMapper<Artist> rowMapper = (rs, rowNum) -> {
        System.out.println(rs);
        Artist artist = new Artist();
        artist.setId(rs.getInt("id"));
        artist.setName(rs.getString("name"));
        Genre genre = new Genre();
        genre.setName(rs.getString("genreName"));
        genre.setId(rs.getLong("genreId"));
        artist.setGenre(genre);
        return artist;
    };
    private final JdbcTemplate jdbcTemplate;

    public ArtistDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Artist> getArtistList() {
        StringBuilder sql = new StringBuilder("Select artist.*, genre.name as genreName from artist" +
                "       left join genre on genre.id = artist.genreId ");
        String string_sql = sql.toString();

        return jdbcTemplate.query(string_sql, rowMapper);
    }

    public Artist getArtistById(int id) {
        String sql = "Select * from artist where id = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            System.out.println(rs);
            Artist artist = new Artist();
            artist.setId(rs.getInt("id"));
            artist.setName(rs.getString("name"));
            return artist;
        }, id).get(0);
    }

    public void saveArtist(Artist artist) {
        String sql = "Insert into artist(image, name, genre_id) " +
                " VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, artist.getImage(), artist.getName(), artist.getGenre().getId());
    }

    public void updateArtist(Artist artist) {
        String sql = "Update artist set image=?, name=?, genre_id=? " +
                " where id = ?";
        jdbcTemplate.update(sql, artist.getImage(), artist.getName(), artist.getGenre().getId(), artist.getId());
    }
}
