package com.hxh.controller;

import com.hxh.pojo.Orders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class ordersController {

    // 方法返回是String，其实就是逻辑的视图名称
    @RequestMapping("/addOrder")
    public String addOrders(Model model){
        List<Orders> list = new ArrayList<Orders>();
        Orders orders1 = new Orders();
        orders1.setId(1);
        orders1.setName("洗衣机");
        orders1.setPrice(1000.99);
        Orders orders2 = new Orders();
        orders2.setId(2);
        orders2.setName("油烟机");
        orders2.setPrice(999.99);
        list.add(orders1);
        list.add(orders2);
        model.addAttribute("orders", list);
        // 这个return 就是原本的 setViewName() return modelAndView
        return "orders";
    }

    // 模拟请求 接收前端传来的值
    @RequestMapping("/request")
    public String request(WebRequest request){
        // 拿到orderData的值
        System.out.println(request.getParameter("orderData"));
        return "orders";
    }

    // 请求映射的路径path可以写多个值
    // 如果method没有限定，啥请求都可以过来
    @RequestMapping(value = {"/m1","/m2"}, method = RequestMethod.GET)
    public String m1(){
        System.out.println("m1测试");
        return "orders";
    }

    // @GetMapping就是requestMapping里面的method指定为get请求
    // @GetMapping(path = {"/m3"})
    // public String m3(){
    //     System.out.println("m1测试");
    //     return "orders";
    // }
}
