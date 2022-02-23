package com.dzq;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取ServletContext对象
        ServletContext context = getServletContext();
        System.out.println("保存之前：Context1获取 key1的值是："+context.getAttribute("key1"));
        context.setAttribute("key1","value1");
        System.out.println("Context1中获取域数据key1的值是"+context.getAttribute("key1"));
    }

}
