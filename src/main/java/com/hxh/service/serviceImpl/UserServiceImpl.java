package com.hxh.service.serviceImpl;

import com.hxh.mapper.UserMapper;
import com.hxh.pojo.User;
import com.hxh.service.UserService;
import com.hxh.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 *
 * 用户业务逻辑方法实现
 * serviceImpl
 *
 * */

@Service
public class UserServiceImpl implements UserService {

    // 登录验证
    @Override
    public int login(User user) {
        SqlSession sqlSession = MybatisUtil.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user1 = userMapper.queryByPhone(user.getPhone());
        try {
            if (user1 == null){
                // 不存在账号
                return 202;
            }
        }catch (Exception e){
            if (user1.getPassword().contains(user.getPassword())){
                // 存在账号 密码正确
                return 200;
            }else {
                // 存在账号 密码错误
                return 201;
            }
        }
        return 202;
    }

    // 获取全部用户信息
    @Override
    public List<User> allUser() {
        SqlSession sqlSession = MybatisUtil.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.queryAllUser();
        return list;
    }
}
