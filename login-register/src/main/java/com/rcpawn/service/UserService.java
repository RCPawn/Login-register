package com.rcpawn.service;

import com.rcpawn.pojo.User;

import java.util.List;

public interface UserService {
    //查询
    public List<User> queryAll();
    //添加数据
    public int add(User user);
    //根据用户名查询数据
    public User queryByName(String username,String password);
}