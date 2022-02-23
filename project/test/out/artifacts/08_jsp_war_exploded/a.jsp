<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: dzq
  Date: 2021/12/22
  Time: 下午10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- 练习：
1.声名类属性
2.声名static静态代码块
3.声名类方法
4.声名内部类--%>
<%--1.声名类属性--%>
<%! private Integer id;
    private String name;
    private static Map<String, Object> map;
%>
<%--2.声名static静态代码块--%>
<%!
    static {
        map = new HashMap<String, Object>();
        map.put("key1", "value1");
        map.put("key2", "value1");
        map.put("key3", "value1");

    }
%>
<%!
    public int abc() {
        return 12;
    }

%>
<%!
    public static class A {
        private Integer id = 12;
        private String abc = "abc";
    }
%>
<%= 12 %><br>
<%= 12.12 %><br>
<%= "字符串" %><br>
<%= map %><br>
<%=request.getParameter("username")%>
<%--if语句--%>
<%
    int i = 12;
    if (i == 12) {
%>
<%
        System.out.println("123");
    } else {
        System.out.println("321");
    }
%>
<table border="1" cellspacing="0">


    <%--for循环--%>
    <%
        for (int j = 0; j < 10; j++) {
    %>
    <tr>
        <td>第<%=j + 1%>行</td>
    </tr>

    <%
        }
    %>
</table>
<%--在翻译后的java文件中_jspService方法内的代码都可以写--%>
<%
    String username = request.getParameter("username");
    System.out.println("用户名的请求参数值是：" + username);
%>
</body>
</html>
