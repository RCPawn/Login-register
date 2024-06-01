package com.rcpawn.service.impl;

import com.rcpawn.mapper.UserMapper;
import com.rcpawn.pojo.User;
import com.rcpawn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> queryAll() {
        return userMapper.queryAll();
    }

    @Override
    public int add(User user) {
        return userMapper.add(user);
    }

    @Override
    public User queryByName(String username,String password) {
        return userMapper.queryByName(username,password);
    }
}