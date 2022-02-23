package com.dzq.web;

import com.dzq.pojo.User;
import com.dzq.service.Impl.UserServiceImpl;
import com.dzq.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //2.调用userService.login处理业务
        User loginUser = userService.login(new User(null, username, password, null));
        //如果等于null,登陆失败
        if (loginUser ==null){
            //跳回登陆页面
            req.getRequestDispatcher("/pages/user/login.html").forward(req,resp);
        }else {
            //登陆成功，跳回Login_success.html
            req.getRequestDispatcher("/pages/user/login_success.html").forward(req,resp);
        }

    }
}
