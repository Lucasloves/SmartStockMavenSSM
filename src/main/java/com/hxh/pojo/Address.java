package com.hxh.pojo;

import java.io.Serializable;

// implements Serializable 这是开启二级缓存需要的序列化 就是内存-》硬盘  反序列化是硬盘-》内存

public class Address implements Serializable {

    private Integer addressId;
    private String country;
    private String city;
    private String state;
    private String street;
    private String zip;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
