<%--
  Created by IntelliJ IDEA.
  User: dzq
  Date: 2021/9/2
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert title here</title>
</head>
<body>
    <h1>提交的信息展示</h1>
        <hr>
        用户名：<%=request.getParameter("username") %><br><br>
        密码：<%=request.getParameter("password")%><br><br>
</body>
</html>
