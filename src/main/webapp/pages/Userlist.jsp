<%--
  Created by IntelliJ IDEA.
  User: 刘阳
  Date: 2020/6/2
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>显示所有用户信息</h3>
<table border="1">
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>密码</th>
    </tr>
    <tbody>
    <c:forEach items="${Userlist}" var="user">
        <tr>
            <td>${user.userId}</td>
            <td>${user.userName}</td>
            <td>${user.password}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
