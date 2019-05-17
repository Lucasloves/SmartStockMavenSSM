package com.hxh.controller;

import com.hxh.pojo.User;
import com.hxh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 *
 * 用户控制器 用来获取前端发来的信息
 * 匹配指定接口进行返回数据
 *
 * */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 登录
    @RequestMapping("/login")
    public int login(User user){
        return userService.login(user);
    }

    // 获取全部数据
    @RequestMapping(value = "/allUser")
    public List<User> allUser(){
        // JSON.parseObject(字符串, User.class);// json转javabean
        // String json = JSONArray.toJSONString(userService.allUser());// javabean转json
        // System.out.println(json)
        return userService.allUser();
    }

    @RequestMapping("m1")
    @ResponseBody
    public User m1(){
        System.out.println(1111);
        User user = new User();
        user.setName("小明");
        user.setPhone("123");
        user.setPassword("123");
        return user;
    }
}
