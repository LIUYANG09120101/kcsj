<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>系统管理员-管理员中心</title>
  <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
  <link rel="stylesheet" type="text/css" href="../font-awesome/css/font-awesome.min.css">
  <link rel="stylesheet" type="text/css" href="../style/adminMain.css">
  <link rel="stylesheet" type="text/css" href="../style/adminReader.css">
  <script type="text/javascript" src="../script/jquery-2.1.4.min.js"></script>
  <script type="text/javascript">
     $(document).ready(function() {
          $(".left ul li:eq(8)").css("color","#FFF");
          $(".left ul li:eq(8)").css("background-color","#B78DE7");
          $(".left ul").find('li:eq(8)').children(".trig").css('display', 'block');
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
    String s = (String) session.getAttribute("xinxicg1");
    String s1 = (String) session.getAttribute("qmima1");
    String s3 = (String) session.getAttribute("mimabu1");
    String s4 = (String) session.getAttribute("mimacw1");
    String s5 = (String) session.getAttribute("ymimano1");
    if(s!=null) {
        out.print(s);
        session.setAttribute("xinxicg1","");
    }
    else if(s1!=null){
        out.print(s1);
        session.setAttribute("qmima1","");
    } else if(s3!=null){
        out.print(s3);
        session.setAttribute("mimabu1","");
    }
    else if(s4!=null){
        out.print(s4);
        session.setAttribute("mimacw1","");
    }
    else if(s5!=null){
        out.print(s5);
        session.setAttribute("ymimano1","");
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
                <input class="inputBtn" style="width:100px;height:34px;margin:0px 0px 20px 150px;font-size:16px"
                type="button" value="修改资料" />
               <div class="data data_1"><label style="color:red">原密码必填。不修改密码时，新密码、确认密码留空</label></div>
            <form action="adminPersonal_xiugai" method="get">
                <input type="hidden" value="${sessionScope.SysAdname}" name="AdminName"/>
                <div class="data"><label>原密码</label><input type="password" name="ypassword"/></div>
                <div class="data"><label>新密码</label><input type="password" name="xpassword"/></div>
                <div class="data"><label>确认新密码</label><input type="password" name="qpassword"/></div>
                <div class="data"><label>电话</label><input value="${sessionScope.systemAdmin1.adminPhone}" name="adminPhone"/></div>
                <div class="data"><label>邮箱</label><input type="email" value="${sessionScope.systemAdmin1.adminEmail}" name="adminEmail"/></div>
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