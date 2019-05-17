package com.hxh.mapper;

import com.hxh.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int insert(User user);
    User queryById(int id);
    User queryByPhone(String phone);
    List<User> queryAllUser();
    User queryByNameAndPhone(@Param("name") String name, @Param("phone") String phone);
}
