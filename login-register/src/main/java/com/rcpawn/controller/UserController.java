package com.rcpawn.controller;

import com.rcpawn.pojo.User;
import com.rcpawn.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/LoginSuccess")
    public String LoginSuccess(Model model, User user){
        //先查询看该用户名是否存在
        User user1 = userServiceImpl.queryByName(user.getUsername(),user.getPassword());
        if(user1 != null){ //  如果查询的用户不为空
            log.info("用户登录：{}",user);
            return "success";
        }
        else{
            //返回到登录页面
            model.addAttribute("error","用户名或密码错误！");
            return "login";
        }
    }
    //登录界面
    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    }
    @RequestMapping("/RegisterSuccess")
    public String toRegisterSuccess(Model model, User user){
        //将账号密码加入到数据库中
        int add = userServiceImpl.add(user);
        log.info("注册成功：{}",user);
        model.addAttribute("success","注册成功，请登录！");
        return "login";
    }
}
