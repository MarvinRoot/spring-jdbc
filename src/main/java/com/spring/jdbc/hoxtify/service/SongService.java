package com.spring.jdbc.hoxtify.service;

import com.spring.jdbc.hoxtify.dao.SongDaoImpl;
import com.spring.jdbc.hoxtify.model.Song;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {
    private final SongDaoImpl songDao;

    public SongService(SongDaoImpl songDao) {
        this.songDao = songDao;
    }

    public List<Song> getSongList() {
        return songDao.getSongList();
    }
}
