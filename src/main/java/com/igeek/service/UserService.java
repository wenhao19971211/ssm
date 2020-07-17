package com.igeek.service;

import com.igeek.dao.UserDao;
import com.igeek.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User findByName(String userName){
        return userDao.findByName(userName);
    }
}
