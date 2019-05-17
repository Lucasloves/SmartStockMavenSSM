package com.hxh.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns = {}, loadOnStartup = 2)
public class WebPathServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        // 在整体应用上下文当中存储一个ctx值，用它来引用上下文
        config.getServletContext().setAttribute("ctx", config.getServletContext().getContextPath());
        super.init(config);
    }
}
