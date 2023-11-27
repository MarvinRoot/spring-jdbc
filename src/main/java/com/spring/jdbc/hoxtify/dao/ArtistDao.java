package com.spring.jdbc.hoxtify.dao;

import com.spring.jdbc.hoxtify.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ArtistDao implements DaoImpl{

    RowMapper<Artist> rowMapper = (rs, rowNum) -> {
        Artist artist = new Artist();
        artist.setId(rs.getInt("id"));
        artist.setName(rs.getString("name"));
        return artist;
    };
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ArtistDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Artist> getList() {
        String sql = "Select * from artist";
        return jdbcTemplate.query(sql, rowMapper);
    }
}
