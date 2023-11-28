package com.spring.jdbc.hoxtify.dao;

import com.spring.jdbc.hoxtify.model.Artist;
import com.spring.jdbc.hoxtify.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

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
        artist.setName(rs.getString("name"));
        return artist;
    };
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ArtistDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Artist> getArtistList() {
        String sql = "Select artist.*, genre.name as genreName from artist" +
                " left join genre on genre.id = artist.genreId";
        return jdbcTemplate.query(sql, rowMapper);
    }

    public Artist getArtistById(int id) {
        String sql = "Select * from artist where id = ?";
        return jdbcTemplate.query(sql, rowMapper, id).get(0);
    }
}
