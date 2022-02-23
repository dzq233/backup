<%--
  Created by IntelliJ IDEA.
  User: dzq
  Date: 2021/9/9
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inset title here</title>
</head>
<body>
<!--html注释-->
<>
<h1>登陆系统页面</h1>
<hr color=red size=7>
<div style="width:400px; height: 280px; border:1px solid #ccc; margin:0 auto;padding:50px 0 0 100px">
    <form action="show.jsp">
        用户:<input type="text" name="username"><br><br>
        密码:<input type="text" name="username"><br><br>
        <input type="submit" value="提交">&nbsp&nbsp<input type="reset" value="重置">
    </form>
</div>
<div style="width: 100%;height: 80px;background: pink; text-align:center;position:fixed;bottom:0">移动2班版权所有</div>
<%
    int i = 0;
    i++;
    out.println("当前页面你是第" + i + "位访问者");
%>
</body>
</html>
