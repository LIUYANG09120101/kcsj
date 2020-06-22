<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>图书管理员-读者还书</title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
	<link rel="stylesheet" type="text/css" href="../font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="../style/adminMain.css">
   <link rel="stylesheet" type="text/css" href="../style/adReturnBook.css">
	<script type="text/javascript" src="../script/jquery-2.1.4.min.js"></script>
	<script type="text/javascript">
	   $(document).ready(function() {
	   	 $(".left ul li:eq(1)").css("color","#FFF");
          $(".left ul li:eq(1)").css("background-color","#BBCAF1");
          $(".left ul").find('li:eq(1)').children(".trig").css('display', 'block');
          $('input[type=text]:first').focus();//默认光标位置在input
	   });
	</script>
</head>
<body>
<%
	String s = (String) session.getAttribute("还书");
	if(s!=null) {
		out.print(s);
		session.setAttribute("还书","");
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
				<form action="huanshu" method="get">
					<div class="data data_1"><label>借阅号</label><input type="text" name="UserId"/></div>
					<div class="data"><label>图书编号</label><input type="text" name="BookId"/></div>
					<button class="add_btn">确认归还</button>
				</form>

   			</div>
   		</div>
   		<div class="clear"></div>
   	</div>
   </div>
</body>
</html>