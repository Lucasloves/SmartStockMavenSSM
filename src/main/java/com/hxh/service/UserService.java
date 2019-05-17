package com.hxh.service;

import com.hxh.pojo.User;

import java.util.List;

/*
*
* 用户业务逻辑接口
* service
*
* */

public interface UserService {

    // 登录验证接口
    public int login(User user);

    // 获取全部用户数据
    public List<User> allUser();
}
