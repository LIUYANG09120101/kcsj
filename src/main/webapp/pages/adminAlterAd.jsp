<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>系统管理员-修改管理员信息</title>
  <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
  <link rel="stylesheet" type="text/css" href="../font-awesome/css/font-awesome.min.css">
  <link rel="stylesheet" type="text/css" href="../style/adminMain.css">
  <link rel="stylesheet" type="text/css" href="../style/adminReader.css">
  <script type="text/javascript" src="../script/jquery-2.1.4.min.js"></script>
  <script type="text/javascript">
     $(document).ready(function() {
          $(".left ul li:eq(5)").css("color","#FFF");
          $(".left ul li:eq(5)").css("background-color","#B78DE7");
          $(".left ul").find('li:eq(5)').children(".trig").css('display', 'block');
     });
  </script>
</head>
<body>
<%
    String s = (String) session.getAttribute("bookadminkong1");
    String s1 = (String) session.getAttribute("bookminxiugaicg");
    if(s!=null){
        out.print(s);
        session.setAttribute("bookadminkong1","");
    }
    else if(s1!=null){
        out.print(s1);
        session.setAttribute("bookminxiugaicg","");
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
            <form action="getBookAdmins1" method="get">
                <div class="data"><label>编号</label><input type="text" name="AdId"/></div>
                <input class="add_btn" value="查询" type="submit" />
            </form>
            <form action="AlterBookAdmin" method="get">
                <input name="AdId" type="hidden" value="${sessionScope.bookAdminss2.adId}">
                <div class="data"><label>编号</label><input value="${sessionScope.bookAdminss2.adId}" name="AdIdx"/></div>
                <div class="data"><label>用户名</label><input value="${sessionScope.bookAdminss2.adName}" name="AdName"/></div>
                <div class="data"><label>初始密码</label><input value="${sessionScope.bookAdminss2.adPassword}" name="AdPassword"/></div>
                <div class="data"><label>电话</label><input value="${sessionScope.bookAdminss2.adPhone}" name="AdPhone"/></div>
                <div class="data"><label>邮箱</label><input value="${sessionScope.bookAdminss2.adEmail}" name="AdEmail"/></div>
                <button class="add_btn">确认修改</button>
                <div class="noadd_btn">取消</div>
            </form>
        </div>
      </div>
      <div class="clear"></div>
    </div>
   </div>
</body>
</html>