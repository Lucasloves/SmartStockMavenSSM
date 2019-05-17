package com.hxh;

import com.hxh.pojo.User;
import com.hxh.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {

    @Test
    public void m1() {
        // 获取上下文对象，spring里面声明对象都需要通过上下文获取
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

        //通过这个对象获取pojo的User
        // User user = (User)applicationContext.getBean("user"); 这个需要强转类型
        User user = applicationContext.getBean("user", User.class);// 这个class加到后边 就不用强转
        System.out.println(user);
    }

    @Test
    public void m2() {
        // ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        // UserService userService = applicationContext.getBean("userService", UserService.class);
        // userService.eat();
    }

    @Test
    public void m3() {
        // ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        // ProviderService providerService = applicationContext.getBean("providerService", ProviderService.class);
        // providerService.add();
    }

}
