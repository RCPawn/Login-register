package com.rcpawn.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.rcpawn.pojo.User;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    //查询
    public List<User> queryAll();
    //添加数据
    public int add(User user);
    //根据用户名查询数据
    public User queryByName(String username,String password);
}