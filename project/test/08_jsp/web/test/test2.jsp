<%@ page import="com.dzq.pojo.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: dzq
  Date: 2021/12/25
  Time: 下午4:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--练习2：jsp输出一个表格，里面有16个学生信息。--%>
<%
    List<Student> studentList = new ArrayList<Student>();
    for (int i = 0; i < 10; i++) {
        int t=i+1;
        studentList.add(new Student(i+1,"name"+t,18+t,"phone"+t));
    }
%>
<%
    for (Student student : studentList) {

    }
%>
</body>
</html>
