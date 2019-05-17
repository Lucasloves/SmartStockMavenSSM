package com.hxh;

import com.hxh.mapper.AddressMapper;
import com.hxh.mapper.UserMapper;
import com.hxh.pojo.Address;
import com.hxh.pojo.User;
import com.hxh.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Test2 {

    @Test
    public void m1() {
        SqlSession sqlSession = MybatisUtil.getSession();
        AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);
        List<Address> addressList = addressMapper.queryByCountryCity("china", "");
        System.out.println(addressList);
        sqlSession.close();
    }

    @Test
    public void m2() {
        SqlSession sqlSession = MybatisUtil.getSession();
        AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);

        Address address = new Address();
        address.setAddressId(2);
        address.setCountry("china");
        address.setCity("fuzhou");
        address.setState("jiangxi");
        address.setStreet("siming");
        addressMapper.update(address);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void m3() {
        SqlSession sqlSession = MybatisUtil.getSession();
        AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);

        Address address = new Address();
        address.setCountry("china");
        List<Address> addressList = addressMapper.query(address);
        System.out.println(addressList);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void m4() {
        SqlSession sqlSession = MybatisUtil.getSession();
        AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);

        Address address = new Address();
        address.setState("beijing");
        List<Address> addressList = addressMapper.queryTrim(address);
        System.out.println(addressList);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void m5() {
        SqlSession sqlSession = MybatisUtil.getSession();
        AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        List<Address> addressList = addressMapper.queryByIds(list);
        System.out.println(addressList);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void m6() {
        SqlSession sqlSession = MybatisUtil.getSession();
        AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);
        List<Address> addressList = addressMapper.queryLike("fu");
        System.out.println(addressList);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void m7() {
        SqlSession sqlSession = MybatisUtil.getSession();
        AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);
        List<Address> addressList = addressMapper.queryAll();
        System.out.println(addressList);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void m71() {
        SqlSession sqlSession = MybatisUtil.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.queryAllUser();
        System.out.println(userList);
        sqlSession.commit();
        sqlSession.close();
    }

    // 缓存
    /*
    *
    * 如果开启了二级缓存 先找二级缓存
    * 二级找不到 就去一级找 一级是默认一直开启的
    * 一级找不到 才到数据库找
    * 一级缓存是在同一个会话下才可以 不同就不会有缓存 例如又新来一句addressMapper = sqlSession.getMapper(AddressMapper.class);
    * 缓存失效
    * 方法一：如果在查询完之后 进行增删改操作 之前的查询的一级缓存就失效了 再次查询就会重新去数据库查询
    * 方法二：强制清空所有缓存 sqlSession.clearCache();
    *
    *  */
    @Test
    public void m8() {
        SqlSession sqlSession = MybatisUtil.getSession();
        AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);
        // 查询会先去 一级缓存找，找到就不查，找不到才继续查询语句
        List<Address> addressList = addressMapper.queryAll();
        System.out.println(addressList);
        // 这个下边有查询一次 因为上边已经查过了 一级缓存有数据 所以下边语句不执行 需要日志插件可以看到 总共就执行了一次sql语句
        List<Address> addressList2 = addressMapper.queryAll();
        System.out.println(addressList2);
        sqlSession.commit();
        sqlSession.close();
    }

    /*
    *
    * 开启二级缓存 需要先在pojo的Address添加public class Address implements Serializable序列化
    * 然后配置 AddressMapper.xml 加这个标签<cache/> 才可以开启二级缓存
    * 最后在mybatis.hxh.xml重要的配置环境中的 setting标签加入 <setting name="cacheEnabled" value="true"/>
    *
    *  */
}
