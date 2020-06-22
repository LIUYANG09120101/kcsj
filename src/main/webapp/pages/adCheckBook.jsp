<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>图书管理员-借阅查询</title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
	<link rel="stylesheet" type="text/css" href="../font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="../style/adminMain.css">
   <link rel="stylesheet" type="text/css" href="../style/adCheckBook.css">
	<script type="text/javascript" src="../script/jquery-2.1.4.min.js"></script>
	<script type="text/javascript">
	   $(document).ready(function() {
         var left_li= $(".left ul li:eq(5)");
	   	    left_li.css("color","#FFF");
          left_li.css("background-color","#BBCAF1");
          $(".left ul").find('li:eq(5)').children(".trig").css('display', 'block');
          $(".table tbody tr:odd").css("backgroundColor","#E3F2F5");
	   });
	</script>
</head>
<body>
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
   				 <div class="search">
                     <form action="adCheckBookss" method="get">
                         <input type="text" name="BookId" value="图书编号/图书名/借阅号" onfocus="if(value=='图书编号/图书名/借阅号') {value=''}" onblur="if (value=='') {value='图书编号/图书名/借阅号'}" />
                         <button class="btn">搜索</button>
                     </form>

                </div>
                      <div class="table_div">
                     <table class="table">
                     <thead>
                        <tr>
                           <th class="tdOne">图书编号</th>
                           <th>图书名称</th>
                           <th class="tdTwo">作者</th>
                           <th class="tdTwo">译者</th>
                           <th class="tdTwo">价格</th>
                           <th>出版社</th>
                           <th class="tdOne">出版日期</th>
                           <th>ISBN编码</th>
                           <th class="tdTwo">入库者</th>
                           <th class="tdOne">借阅号</th>
                           <th class="tdOne">应还日期</th>
                           <th class="tdOne">实还日期</th>
                        </tr>
                     </thead>
                     <tbody>
                     <c:forEach items="${sessionScope.borrowRecordsjiluList}" var="book">
                         <tr>
                             <td>${book.bookId}</td>
                             <td>${book.bookName}</td>
                             <td>${book.author}</td>
                             <td>${book.translator}</td>
                             <td>${book.price}</td>
                             <td>${book.publishCompany}</td>
                             <td>${book.comeUpTime}</td>
                             <td>${book.ISBNCode}</td>
                             <td>${book.enteringMen}</td>
                             <td>${book.userId}</td>
                             <td>${book.shouldTime}</td>
                             <td>${book.returnTime}</td>
                         </tr>
                     </c:forEach>
                     </tbody>
                     </table>
                     <table class="table">
                        <thead>
                          <th>借阅号</th>
                          <th>图书名</th>
                          <th>应还日期</th>
                          <th>实还日期</th>
                        </thead>
                        <tbody>
                        <c:forEach items="${sessionScope.borrowRecordsjiluList}" var="book">
                            <tr>
                                <td>${book.userId}</td>
                                <td>${book.bookName}</td>
                                <td>${book.shouldTime}</td>
                                <td>${book.returnTime}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                     </table>
                  </div>
                 
   			</div>
   		</div>
   		<div class="clear"></div>
   	</div>
   </div>
</body>
</html>