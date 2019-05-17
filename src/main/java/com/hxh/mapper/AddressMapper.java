package com.hxh.mapper;

import com.hxh.pojo.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressMapper {

    Address queryById(Integer id);
    List<Address> queryByCountryCity(@Param("country") String country,@Param("city") String city);
    int update(Address address);
    List<Address> query(Address address);
    List<Address> queryTrim(Address address);
    List<Address> queryByIds(List<Integer> list);
    List<Address> queryLike(@Param("city") String city);
    List<Address> queryAll();
}
