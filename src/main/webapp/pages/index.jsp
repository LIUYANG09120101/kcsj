<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>首页</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <link rel="stylesheet" type="text/css" href="../font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="../style/Carousel.css">
    <link rel="stylesheet" type="text/css" href="../style/index.css">
    <script type="text/javascript" src="../script/jquery-2.1.4.min.js"></script>
    <script src="../script/jquery.slides.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
        	 $('#slides').slidesjs({
             width: 1080,
             height: 435,
             play: {
               active: true,
               auto: true,
               interval: 4000,
               swap: true
               }
		    });
        });
    </script>
</head>
<body>
<div class="index">
	<div class="header">
	    <div class="state">
<%--	    	<div class="perphoto"><img src="../images/perphoto.png"></div>--%>
<%--	    	<div class="username" title="张三李斯李斯">张三</div>--%>
	    	<div class="delete">退出</div>
	    </div>
		<%
			String readername = (String) session.getAttribute("username");
			String adname = (String) session.getAttribute("Adname");
			String sysname = (String) session.getAttribute("SysAdname");
			if(readername!=null){
				out.print("<div class=\"login\"><a href=\"readerPersonal\">"+readername+"</a></div>");
			}
			else if(adname!=null){
				out.print("<div class=\"login\"><a href=\"adPersonal\">"+adname+"</a></div>");
			}
			else if (sysname!=null){
				out.print("<div class=\"login\"><a href=\"adminPersonal\">"+sysname+"</a></div>");
			}
			else {
				out.print("<div class=\"login\"><a href=\"login\">登录</a></div>");
			}
		%>

	</div>
	<div class="menu">
		<div class="logo"><img src="../images/logo.png"></div>
		<div class="menu_list">
			<ul>
				<li>首页</li>
			</ul>
			<div class="clear"></div>
		</div>
		<div class="clear"></div>
	</div>
	<div class="grey_one"></div>
	<div class="banner">
		<div class="photo">
		 <div class="container" style="width:1080px;">
		    <div id="slides" style="width:1080px;">
		      <img src="../images/photo.png" >
		      <img src="../images/slide-2.jpg" >
		      <img src="../images/slide-3.jpg">
		      <img src="../images/slide-4.jpg">
		      <a href="#" class="slidesjs-previous slidesjs-navigation"><i class="icon-chevron-left icon-large"></i></a>
		      <a href="#" class="slidesjs-next slidesjs-navigation"><i class="icon-chevron-right icon-large"></i></a>
		    </div>
  		</div>
		<div class="search">
			<form action="findNameBookInfo" method="get">
				<input class="search_input" type="text" name="BookName"/>
				<button class="search_btn">搜索</button>
			</form>
		</div>
		</div>

	</div>
	<div class="grey_two">
		<marquee direction="left" align="bottom" onmouseout="this.start()" onmouseover="this.stop()" scrollamount="2" scrolldelay="1">
		图书馆本周周一至周日正常开放，开馆时间：8:20,闭馆时间：22:00
	   </marquee>
	</div>

	<div class="footer">
	    <br/>   
		<p>@Copyright重庆理工大学中山图书馆</p>
	</div>
</div>
</body>
</html>