<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>借阅记录</title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
	<link rel="stylesheet" type="text/css" href="../font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="../style/readerMain.css">
	<link rel="stylesheet" type="text/css" href="../style/readerBorrowed.css">
	<script type="text/javascript" src="../script/jquery-2.1.4.min.js"></script>
	<script type="text/javascript">
	  $(function(){
	  	 var Lis=$(".menu ul li").eq(4);
	  	 Lis.css('border-bottom', '7px solid #419EDC');
	  	 Lis.css('margin-top', '-7px');
	  	 Lis.css('color', '#419EDC');
	  	 $(".table tbody tr:odd").css("backgroundColor","#F2F2D6");
	  })
	</script>
</head>
<body>
<div class="header">
	<div class="header">
		<div class="home_logo"><a  href="index"><i class="fa fa-home">首页</i></a></div>
		<div class="page_title">个人中心</div>
        <div class="home_logo"><a href="out"><i class="fa fa-sign-out">退出</i></a></div>
	</div>
</div>
<div class="book_logo">
	<img src="../images/booklogo.png">
</div>
<div class="reader_name">${sessionScope.username}</div>
<div class="menu">
	<ul>
		<a href="readerPersonal"><li class="first_li">基本资料</li></a>
		<a href="readerAlterData"><li class="other_li">修改资料</li></a>
		<a href="readerAlterPaswd"><li class="other_li">修改密码</li></a>
		<a href="readerBorrowing"><li class="other_li">在借图书</li></a>
		<a href="readerBorrowed"><li class="last_li">借阅记录</li></a>
	</ul>
	<div class="clear"></div>
</div>
<!-- class="content"的div中是个人中心的切换部分 -->
<div class="content">
	<div class="table_div">
          <table class="table">
            <thead>
              <th>序号</th>
              <th>借阅号</th>
              <th>图书名</th>
              <th>借书日期</th>
              <th>还书日期</th>
            </thead>
            <tbody>
			<c:set var="index" value="1"></c:set>
            <c:forEach items="${sessionScope.borrowRecordsList2}" var="book">
                <tr>
                    <td>${index}</td>
                    <td>${book.userId}</td>
                    <td>${book.bookName}</td>
                    <td>${book.borrowTime}</td>
                    <td>${book.returnTime}</td>
                </tr>
				<c:set var="index" value="${index + 1}"></c:set>
            </c:forEach>
            </tbody>
           </table>
        </div>
</div>
<div class="footer" style="width: 100%">
	    <br/>   
		<p>@Copyright重庆理工大学中山图书馆</p>
	</div>
</body>
</html>