<%--
  Created by IntelliJ IDEA.
  User: 刘阳
  Date: 2020/6/2
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>所有书籍</title>
</head>
<body>
<h3>显示所有书籍信息</h3>

    <table border="1">
        <tr>
            <th>图书ID</th>
            <th>图书名称</th>
            <th>图书作者</th>
            <th>图书译者</th>
            <th>价格</th>
            <th>ISBN编码</th>
            <th>出版日期</th>
            <th>出版社</th>
            <th>图书状态</th>
            <th>入库者</th>
            <th>入库日期</th>
            <th>在库数量</th>
        </tr>
        <tbody>
        <c:forEach items="${BookInfolist}" var="book">
            <tr>
                <td>${book.bookId}</td>
                <td>${book.bookName}</td>
                <td>${book.author}</td>
                <td>${book.translator}</td>
                <td>${book.price}</td>
                <td>${book.ISBNCode}</td>
                <td>${book.comeUpTime}</td>
                <td>${book.publishCompany}</td>
                <td>${book.state}</td>
                <td>${book.enteringMen}</td>
                <td>${book.enteringDate}</td>
                <td>${book.number}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
