package com.dzq.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SearchStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        //发sql语句查询学生的信息
        //使用for循环生成查询到的数据做模拟
        //保存查询到的结果(学生信息)到request域中
        //请求转发到showStudent.jsp页面
    }
}
