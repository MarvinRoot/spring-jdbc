package com.spring.jdbc.hoxtify.service;

import com.spring.jdbc.hoxtify.dao.UserDaoImpl;
import com.spring.jdbc.hoxtify.model.User;
import com.spring.jdbc.hoxtify.model.filter.UserFilter;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
public class UserService {
    private final UserDaoImpl userDao;
    public UserService(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public List<User> getUsers(UserFilter filter) {
        return userDao.getUserList(filter);
    }
}
