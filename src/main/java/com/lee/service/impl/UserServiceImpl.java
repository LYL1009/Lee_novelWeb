package com.lee.service.impl;

import com.lee.entity.User;
import com.lee.entity.UserExample;
import com.lee.mapper.UserMapper;
import com.lee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUsers() {
        return userMapper.selectByExample(new UserExample());
    }

    @Override
    public Integer updateUserByUserIdSelective(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public Integer addUser(User user) {
        return userMapper.insertSelective(user);
    }
}
