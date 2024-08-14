package com.spring.jdbc.hoxtify.dao;

import com.spring.jdbc.hoxtify.model.Artist;
import com.spring.jdbc.hoxtify.model.Song;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class SongDaoImpl {
    private final JdbcTemplate jdbcTemplate;

    public SongDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Song> getSongList() {
        StringBuilder sql = new StringBuilder("Select song.*" +
                " ,artist.name as artistName " +
                " ,artist.id as artistId " +
                " from song " +
                "         left join artist_songs on artist_songs.song_id = song.id " +
                "         left join artist on artist.id = artist_songs.artist_id;");
//                "       left join artist on song.id = artist.genreId ");
        String string_sql = sql.toString();
        Map<Long, Song> songMap = new LinkedHashMap<>();
        jdbcTemplate.query(string_sql, (rs, rowNum) -> {
            Long songId = rs.getLong("id");
            Song song = songMap.get(songId);

            if (song == null) {
                song = new Song();
                song.setId(songId);
                song.setTitle(rs.getString("title"));
                songMap.put(songId, song);
            }

            int artistId = rs.getInt("artistId");
            if (artistId != 0) {
                Artist artist = new Artist();
                artist.setId(artistId);
                artist.setName(rs.getString("artistName"));
                song.getArtists().add(artist);
            }
            return song;
        });
        return new ArrayList<>(songMap.values());
    }
}
