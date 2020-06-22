<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>图书管理员-修改图书信息</title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
	<link rel="stylesheet" type="text/css" href="../font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="../style/adminMain.css">
  <link rel="stylesheet" type="text/css" href="../style/adBook.css">
	<script type="text/javascript" src="../script/jquery-2.1.4.min.js"></script>
   <script type="text/javascript" src="../layer-v2.0/layer/layer.js"></script>
   <script type="text/javascript" src="../layer-v2.0/layer/extend/layer.ext.js"></script>
	<script type="text/javascript">
	   $(document).ready(function() {
          $(".left ul li:eq(4)").css("color","#FFF");
          $(".left ul li:eq(4)").css("background-color","#BBCAF1");
          $(".left ul").find('li:eq(4)').children(".trig").css('display', 'block');
	   });
	</script>
</head>
<body>
<%
	String s = (String) session.getAttribute("为空");
	String s1 = (String) session.getAttribute("修改");
	if(s!=null) {
		out.print(s);
		session.setAttribute("为空","");
	}
	else if(s1!=null){
		out.print(s1);
		session.setAttribute("修改","");
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
				<form action="getBookInfo" method="get">
					<div class="data data_1"><label>图书编号</label><input  value="输入图书编号" name="BookId" onfocus="if(value=='输入图书编号') {value=''}" onblur="if (value=='') {value='输入图书编号'}"/></div>
					<input class="add_btn" value="查询" type="submit" />
				</form>
				<form action="UpdateBook" method="get">
					<input type="hidden" value="${books.bookId}" name="BookId"/>
					<div class="data"><label>图书名称</label><input type="text" name="BookName" value="${books.bookName}" /></div>
					<div class="data"><label>作者</label><input type="text" name="Author" value="${books.author}"/></div>
					<div class="data"><label>译者</label><input type="text" name="Translator" value="${books.translator}"/></div>
					<div class="data"><label>价格</label><input type="text" name="Price" value="${books.price}"/></div>
					<div class="data"><label>ISBN编码</label><input type="text" name="ISBNCode" value="${books.ISBNCode}"/></div>
					<div class="data"><label>出版社</label><input type="text" name="PublishCompany" value="${books.publishCompany}"/></div>
					<div class="data"><label>出版日期</label><input type="text" name="ComeUpTime" value="${books.comeUpTime}"/></div>
					<div class="data"><label>借阅状态</label><input type="text" name="State" value="${books.state}"/></div>
					<div class="data"><label>在库数量</label><input type="text" name="Number" value="${books.number}"/></div>
					<div class="data"><label>入库者</label><input type="text" name="EnteringMen" value="${books.enteringMen}"/></div>
					<input class="add_btn" value="提交修改" type="submit" />
					<div class="noadd_btn">取消</div>
				</form>
   			</div>
   		</div>
   		<div class="clear"></div>
   	</div>
   </div>
</body>
</html>