<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>图书管理员-读者借书</title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
	<link rel="stylesheet" type="text/css" href="../font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="../style/adminMain.css">
   <link rel="stylesheet" type="text/css" href="../style/adBorrowBook.css">
    <link rel="stylesheet" type="text/css" href="../layer-v2.0/layer/skin/layer.css">
	<script type="text/javascript" src="../script/jquery-2.1.4.min.js"></script>
   <script type="text/javascript" src="../layer-v2.0/layer/layer.js"></script>
	<script type="text/javascript">
	   $(document).ready(function() {
	   	 $(".left ul li:eq(0)").css("color","#FFF");
          $(".left ul li:eq(0)").css("background-color","#BBCAF1");
          $(".left ul").find('li:eq(0)').children(".trig").css('display', 'block');
          $(".A_btn").click(function() {
                var index = layer.load(1, {
                shade: [0.1,'#fff'] //0.1透明度的白色背景
                 // layer.close(index);   //关闭验证
            });
          });
          $(".B_btn").click(function() {
            $(".data input").val("");
          });
          $('input[type=text]:first').focus();//默认光标位置在input
          $(".table tbody tr:odd").css("backgroundColor","#FCF8E3");//表格奇数行背景
	   });
	</script>
</head>
<body>
<%
    String s = (String) session.getAttribute("s");
    if(s!=null) {
        out.print(s);
        session.setAttribute("s","");
    }
%>
   <div class="ad_page">
   	<div class="header">
   		<img src="../images/logo.png" alt=" ">
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
        <%
            Date d = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String now = df.format(d);
        %>

        <div class="right">
   			<div class="ad_data">
                <form action="check" method="get">
                    <div class="data data_1"><label>借阅号</label><input type="text" name="UserId"/></div>
                    <div class="data"><label>图书编号</label><input type="text" name="BookId"/></div>
                    <input class="btn A_btn" type="submit" value="验证" />
                    <div class="btn B_btn">清空</div>
                </form>

               <div class="table_div">
                  <table class="table">
                        <thead>
                          <th>借阅号</th>
                          <th>图书名</th>
                          <th>应还日期</th>
                        </thead>
                        <tbody>
                        <c:forEach items="${sessionScope.BorrowRecordsList}" var="book">
                                <tr>
                                    <td>${book.userId}</td>
                                    <td>${book.bookName}</td>
                                    <td>${book.shouldTime}</td>
                                </tr>
                        </c:forEach>
                        </tbody>
                     </table>
                     <div class="add_btn"><a href="insterBorrowBook" style="text-decoration:none;color: #0e0e0e">确认借阅</a> </div>
                     <div class="clear"></div>
               </div>
   			</div>
   		</div>
   		<div class="clear"></div>
   	</div>
   </div>
</body>
</html>