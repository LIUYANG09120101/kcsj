<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>基本资料</title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
	<link rel="stylesheet" type="text/css" href="../font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="../style/readerMain.css">
	<link rel="stylesheet" type="text/css" href="../style/readerPersonal.css">
	<script type="text/javascript" src="../script/jquery-2.1.4.min.js"></script>
	<script type="text/javascript">
	  $(function(){
	  	 var Lis=$(".menu ul li").eq(0);
	  	 Lis.css('border-bottom', '7px solid #419EDC');
	  	 Lis.css('margin-top', '-7px');
	  	 Lis.css('color', '#419EDC');
	  })
	</script>
</head>
<body>
<%
	String s = (String) session.getAttribute("s");
	if(s!=null){
		out.print(s);
	}
	session.setAttribute("s","");
%>
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
	<div class="data"><label>借阅号</label><div>${sessionScope.userinfos[0].userId}</div></div>
	<div class="data"><label>用户名</label><div>${sessionScope.userinfos[0].userName}</div></div>
    <div class="data"><label>学院</label><div>${sessionScope.userinfos[0].departments}</div></div>
    <div class="data"><label>专业</label><div>${sessionScope.userinfos[0].major}</div></div>
	<div class="data"><label>电话</label><div>${sessionScope.userinfos[0].phone}</div></div>
    <div class="data"><label>邮箱</label><div>${sessionScope.userinfos[0].email}</div></div>
    <div class="data"><label>借阅上限</label><div>${sessionScope.userinfos[0].max}</div></div>
    <div class="data"><label>借阅期限</label><div>${sessionScope.userinfos[0].time}天</div></div>
    <div class="data"><label>已借数量</label><div>${sessionScope.userinfos[0].lendedNum}</div></div>
</div>
<div class="footer" style="width: 100%">
	    <br/>   
		<p>@Copyright重庆理工大学中山图书馆</p>
	</div>
</body>
</html>