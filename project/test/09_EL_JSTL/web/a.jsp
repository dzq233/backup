<%--
  Created by IntelliJ IDEA.
  User: dzq
  Date: 2022/1/14
  Time: 下午5:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
request.setAttribute("key","request");
session.setAttribute("key","session");
application.setAttribute("key","application");
pageContext.setAttribute("key","application");

%>

</body>
</html>
