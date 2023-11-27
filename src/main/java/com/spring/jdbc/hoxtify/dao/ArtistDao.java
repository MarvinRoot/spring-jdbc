package com.spring.jdbc.hoxtify.dao;

import com.spring.jdbc.hoxtify.model.Artist;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ArtistDao implements DaoImpl{

    RowMapper<Artist> rowMapper = (rs, rowNum) -> {
        Artist artist = new Artist();
        artist.setId(rs.getInt("id"));
        artist.setName(rs.getString("name"));
        return artist;
    };
    private final JdbcTemplate jdbcTemplate;

    public ArtistDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Artist> getList() {
        String sql = "Select * from artist";
        return jdbcTemplate.query(sql, rowMapper);
    }
}
