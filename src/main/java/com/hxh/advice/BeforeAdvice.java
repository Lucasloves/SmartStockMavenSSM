package com.hxh.advice;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect// 这个是注解 进行切面注册
@Component// 注册为spring的一个组件
public class BeforeAdvice {

    // Before注解 当execution里面的其他注册的类 在执行前会使用一下建议方法
    @Before("execution(* com..*.*(..))")
    public void methodBefore() {
        System.out.println("我在最前面。。。");
    }

}
