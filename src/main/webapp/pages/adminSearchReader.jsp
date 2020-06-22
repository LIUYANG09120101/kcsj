<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>系统管理员-查看读者信息</title>
  <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
  <link rel="stylesheet" type="text/css" href="../font-awesome/css/font-awesome.min.css">
  <link rel="stylesheet" type="text/css" href="../style/adminMain.css">
  <link rel="stylesheet" type="text/css" href="../style/searchTable.css">
  <script type="text/javascript" src="../script/jquery-2.1.4.min.js"></script>
  <script type="text/javascript">
     $(document).ready(function() {
          $(".left ul li:eq(6)").css("color","#FFF");
          $(".left ul li:eq(6)").css("background-color","#B78DE7");
          $(".left ul").find('li:eq(6)').children(".trig").css('display', 'block');
          $(".table tbody tr:odd").css("backgroundColor","#DFF0D8");
     });
  </script>
</head>
<body>
<%
    String s = (String) session.getAttribute("infokong");
    if(s!=null){
        out.print(s);
        session.setAttribute("infokong","");
    }
%>
   <div class="ad_page">
    <div class="header">
      <img src="../images/logo.png">
      <div class="state">
      <div class="ad_name"><div class="fa_i"><i class="fa fa-user"></i></div><a href="adminPersonal">${sessionScope.SysAdname}</a></div>
        <div class="out"><a href="out">退出</a></div>
      </div>
      <div class="clear"></div>
    </div>
    <div class="content">
      <div class="left">
        <ul>
          <a href="adminAddReader"><li>录入新读者<div class="trig"></div></li></a>
          <a href="adminOutReader"><li>删除读者<div class="trig"></div></li></a>
          <a href="adminAlterReader"><li>修改读者信息<div class="trig"></div></li></a>
          <a href="adminAddAd"><li>录入图书管理员<div class="trig"></div></li></a>
          <a href="adminOutAd"><li>删除图书管理员<div class="trig"></div></li></a>
          <a href="adminAlterAd"><li>修改管理员信息<div class="trig"></div></li></a>
          <a href="adminSearchReader"><li>查看读者信息<div class="trig"></div></li></a>
          <a href="adminSearchAd"><li>查看管理员信息<div class="trig"></div></li></a>
          <a href="adminPersonal"><li>管理员中心<div class="trig"></div></li></a>
        </ul>
      </div>
      <div class="right">
      <!-- class="ad_data"的div中是系统管理员系统的切换部分 -->
        <div class="ad_data">
         <div class="search">
              <input type="text" value="输入搜索信息" onfocus="if(value=='输入搜索信息') {value=''}" onblur="if (value=='') {value='输入搜索信息'}" />
              <div class="btn">搜索</div>
          </div>
                 <div class="table_div">
                     <table class="table">
                       <thead>
                          <tr>
                             <th class="tdOne">借阅号</th>
                             <th class="tdOne">用户名</th>
                             <th>学院</th>
                             <th>专业</th>
                             <th>电话</th>
                             <th class="tdOne">邮箱</th>
                             <th>借阅上限</th>
                             <th>借阅期限</th>
                             <th>在借数量</th>
                          </tr>
                       </thead>
                       <tbody>
                       <c:forEach items="${sessionScope.userInfoList}" var="user">
                           <tr>
                               <td>${user.userId}</td>
                               <td>${user.userName}</td>
                               <td>${user.departments}</td>
                               <td>${user.major}</td>
                               <td>${user.phone}</td>
                               <td>${user.email}</td>
                               <td>${user.max}</td>
                               <td>${user.time}</td>
                               <td>${user.lendedNum}</td>
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