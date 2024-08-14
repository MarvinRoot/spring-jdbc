package com.spring.jdbc.hoxtify.dao;

import com.spring.jdbc.hoxtify.model.Artist;
import com.spring.jdbc.hoxtify.model.Song;
import com.spring.jdbc.hoxtify.model.User;
import com.spring.jdbc.hoxtify.model.filter.UserFilter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl {
    private final JdbcTemplate jdbcTemplate;
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> getUserList(UserFilter filter) {
        List<Object> params = new ArrayList<>();
        StringBuilder sql = new StringBuilder("Select user.* from user ");
        if (filter.hasEntityId()) {
            sql.append("where id = ?");
            params.add(filter.getEntityId());
        }
        if (filter.hasEmailSet() && filter.hasPasswordSet()) {
            sql.append(" where LOWER(email) =  ? and" +
                    " password = ?");
            params.add(filter.getEmail().toLowerCase());
            params.add(filter.getPassword());
        }
        if (filter.hasUsernameSet() && filter.hasPasswordSet()) {
            sql.append(" where LOWER(username) =  ? and" +
                    " password = ?");
            params.add(filter.getUsername().toLowerCase());
            params.add(filter.getPassword());
        }
        String string_sql = sql.toString();
        return jdbcTemplate.query(string_sql, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            return user;
        }, params.toArray());
    }
}
