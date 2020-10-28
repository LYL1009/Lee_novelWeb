package com.lee.service;

import com.lee.entity.User;

import java.util.List;

public interface UserService {

    default List<User> getUsers() {
        return null;
    }

    default Integer updateUserByUserIdSelective(User user) {
        return null;
    }

    default Integer addUser(User user) {
        return null;
    }

}
