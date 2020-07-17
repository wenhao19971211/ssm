package com.igeek.dao;

import com.igeek.pojo.User;

public interface UserDao {

    public User findByName(String userName);
}
