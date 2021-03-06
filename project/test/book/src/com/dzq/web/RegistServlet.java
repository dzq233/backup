package com.dzq.web;

import com.dzq.pojo.User;
import com.dzq.service.Impl.UserServiceImpl;
import com.dzq.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//1.获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");


        //2.检查 验证码是否正确===写死，要求验证码为：abcde
        if ("abcde".equalsIgnoreCase(code)) {
            //正确
            //3.检查 用户名是否可用
            if (userService.existUsername(username)) {
                System.out.println("用户名[" + username + "]已存在");
                req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);
                //      不可用
                //跳回注册页面
            } else {

                //可用
                //调用Service保存到数据库
                userService.registUser(new User(null, username, password, email));
                req.getRequestDispatcher("/pages/user/regist_success.html").forward(req, resp);
                //跳到注册成功页面 regist_success.html
            }


        } else {
            System.out.println("验证码"+code+"错误");
            req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);
        }


    }
}
