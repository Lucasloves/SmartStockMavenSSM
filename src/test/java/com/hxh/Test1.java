package com.hxh;

import com.hxh.mapper.UserMapper;
import com.hxh.pojo.User;
import com.hxh.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;

public class Test1 {

    @Test
    public void m1() {
        SqlSession sqlSession = MybatisUtil.getSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setName("黄厦华");
        user.setPhone("18959262402");
        user.setPassword("123");

        userMapper.insert(user);
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void m2() {
        SqlSession sqlSession = MybatisUtil.getSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.queryById(1);

        System.out.println(user.getName());

        sqlSession.close();
    }

    @Test
    public void m3() {
        SqlSession sqlSession = MybatisUtil.getSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.queryByNameAndPhone("h", "123123");

        System.out.println(user.getUserId());

        sqlSession.close();
    }

}
