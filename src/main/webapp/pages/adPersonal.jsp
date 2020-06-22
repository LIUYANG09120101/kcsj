<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>图书管理员-管理管中心</title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
	<link rel="stylesheet" type="text/css" href="../font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="../style/adminMain.css">
  <link rel="stylesheet" type="text/css" href="../style/adBook.css">
	<script type="text/javascript" src="../script/jquery-2.1.4.min.js"></script>
   <script type="text/javascript" src="../layer-v2.0/layer/layer.js"></script>
   <script type="text/javascript" src="../layer-v2.0/layer/extend/layer.ext.js"></script>
	<script type="text/javascript">
	   $(document).ready(function() {
          $(".left ul li:eq(7)").css("color","#FFF");
          $(".left ul li:eq(7)").css("background-color","#BBCAF1");
          $(".left ul").find('li:eq(7)').children(".trig").css('display', 'block');
          $(".data input").attr('disabled', 'true');
         
          $(".inputBtn").click(function() {
             $(".data input").removeAttr('disabled');
          });
          $(".noadd_btn").click(function() {
            $(".data input").attr('disabled', 'true');
          });
	   });
	</script>
</head>
<body>
<%
	String s = (String) session.getAttribute("xinxicg");
	String s1 = (String) session.getAttribute("qmima");
	String s3 = (String) session.getAttribute("mimabu");
	String s4 = (String) session.getAttribute("mimacw");
	String s5 = (String) session.getAttribute("ymimano");
	if(s!=null) {
		out.print(s);
		session.setAttribute("xinxicg","");
	}
	else if(s1!=null){
		out.print(s1);
		session.setAttribute("qmima","");
	} else if(s3!=null){
		out.print(s3);
		session.setAttribute("mimabu","");
	}
	else if(s4!=null){
		out.print(s4);
		session.setAttribute("mimacw","");
	}
	else if(s5!=null){
		out.print(s5);
		session.setAttribute("ymimano","");
	}
%>
   <div class="ad_page">
   	<div class="header">
   		<img src="../images/logo.png">
   		<div class="state">
   			<div class="ad_name"><div class="fa_i"><i class="fa fa-user"></i></div><a href="adPersonal">${sessionScope.Adname}</a></div>
   			<div class="out"><a href="out">退出</a></div>
   		</div>
   		<div class="clear"></div>
   	</div>
   	<div class="content">
   		<div class="left">
   			<ul>
				<a href="adBorrowBook"><li>读者借书<div class="trig"></div></li></a>
               <a href="adReturnBook"><li>读者还书<div class="trig"></div></li></a>
               <a href="adAddBook"><li>新书入库<div class="trig"></div></li></a>
               <a href="adOutBook"><li>图书出库<div class="trig"></div></li></a>
               <a href="adAlterBook"><li>修改图书信息<div class="trig"></div></li></a>
               <a href="adCheckBook"><li>查阅借阅记录<div class="trig"></div></li></a>
               <a href="adSearchBook"><li>查阅图书信息<div class="trig"></div></li></a>
               <a href="adPersonal"><li>管理员中心<div class="trig"></div></li></a>
   			</ul>
   		</div>
   		<div class="right">
      <!-- class="ad_data"的div中是图书管理员系统的切换部分 -->
   			<div class="ad_data">
               <input class="inputBtn" style="width:100px;height:34px;margin:0px 0px 20px 150px;font-size:16px"
                type="button" value="修改资料" />
				<div class="data data_1"><label style="color:red">原密码必填。不修改密码时，新密码、确认密码留空</label></div>
				<form action="adPersonal_xiugai" method="get">
					<input type="hidden" name="AdName" value="${sessionScope.Adname}">
					<div class="data"><label>原密码</label><input type="password" name="yPassword"/></div>
					<div class="data"><label>新密码</label><input type="password" name="xPassword"/></div>
					<div class="data"><label>确认新密码</label><input type="password" name="qPassword"/></div>
					<div class="data"><label>电话</label><input type="text" value="${sessionScope.bookadmin[0].adPhone}" name="adPhone"/></div>
					<div class="data"><label>邮箱</label><input type="email" value="${sessionScope.bookadmin[0].adEmail}" name="adEmail"/></div>
					<button class="add_btn">提交修改</button>
					<div class="noadd_btn">取消</div>
				</form>

   			</div>
   		</div>
   		<div class="clear"></div>
   	</div>
   </div>
</body>
</html>