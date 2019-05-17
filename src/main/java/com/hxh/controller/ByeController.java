package com.hxh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// 注解 不要继承任何类或任何方法
@Controller
public class ByeController {

    // ModelAndView = Model + View
    @RequestMapping("/bye")
    public String bye(Model model){
        model.addAttribute("model", "modeller");
        // 这里return就是等同于接口实现里的viewName
        // 去到地方是 /jsp/bye.jsp页面
        return "bye";
    }

}
