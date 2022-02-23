package com.dzq;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.getRequestURI()               获取请求的资源路径
        System.out.println("URI => "+req.getRequestURI());
        //2.getRequestURL()               获取请求的统一资源定位符(绝对路径)
        System.out.println("URL =>"+req.getRequestURL());
        //3.getRemoteHost()               获取客户端的ip地址
        /*
        *在IDEA中，使用localhost访问时，得到的客户端ip地址是 ===> 127.0.0.1
        *在IDEA中，使用127.0.0.1访问时，得到的客户端ip地址是 ===> 127.0.0.1
        * 在IDEA中，使用真实ip访问时，得到的客户端ip地址是 ===> 真实的客户端ip地址*/
        System.out.println("客户端ip地址 =>"+req.getRemoteHost());
        //4.getHeader()                   获取请求头
        System.out.println("请求头User-Agent ==>"+req.getHeader("User-Agent"));
        //5.getMethod()                   获取请求的方式GET 或POST
        System.out.println("请求的方式==>"+req.getMethod());
    }
}
