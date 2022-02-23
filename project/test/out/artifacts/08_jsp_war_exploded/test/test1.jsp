<%--
  Created by IntelliJ IDEA.
  User: dzq
  Date: 2021/12/23
  Time: 下午9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

    <title>Title</title>
    <style type="text/css">
        table{
            width: 600px;
        }
    </style>
</head>
<body>
<table style="margin: 50px auto" >
<%--在页面中输出99乘法表--%>
    <%
        for (int i = 1; i < 9; i++) {%>
    <tr>
        <%for (int j = 1; j < i; j++) {%>
        <td><%= j + "x" + i + "=" + (i * j)%></td>
    <% } %>
    </tr>
    <% } %>


</table>
</body>
</html>
