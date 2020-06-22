<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>登录</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <link rel="stylesheet" type="text/css" href="../style/login.css">
    <link rel="stylesheet" type="text/css" href="../font-awesome/css/font-awesome.min.css">
    <script type="text/javascript" src="../script/jquery-2.1.4.min.js"></script>
    <script type="text/javascript">
        function password_f(){
            alert("亲，请到教务系统修改密码！");
        }
    </script>
</head>
<body>
<%
    String error = (String) session.getAttribute("error");
    String s = (String) session.getAttribute("3");
    String s1 = (String) session.getAttribute("mimacg");
    if(error!=null){
        out.print(error);
        session.setAttribute("error","");
    }
    else if(s!=null)
    {
        out.print(s);
        session.setAttribute("3","");
    }
    else if(s1!=null)
    {
        out.print(s1);
        session.setAttribute("mimacg","");
    }
%>
<div class="login_page">
	<div class="page_top"></div>
	<div class="header"> 
		<img src="../images/logo.png">
		<div class="hello_word">中山图书馆欢迎您</div>
		<div class="clear"></div>
	</div>
	<div class="login">
		<div class="login_part" >
            <form action="logins" method="get">
                <select class="role" name="type">
                    <option value="1">读者</option>
                    <option value="2">图书管理员</option>
                    <option value="3">系统管理员</option>
                </select>
                <hr class="lion" />
                <div class="login_input">
                    <div class="user"><i class="fa fa-user"></i></div>
                    <input type="text" value="请输入通行证号"onfocus="if (value =='请输入通行证号'){value=''}" onblur="if (value=='') {value='请输入通行证号'}" name="UserName"/>&nbsp;<span class="text_red">*</span>
                    <div class="user"><i class="fa fa-lock"></i></div>
                    <input type="password" name="Password"/>&nbsp;<span class="text_red">*</span>
                </div>
                <button class="login_btn">登录</button>
                <div class="password_f" onclick="password_f()">忘记密码 ？</div>
            </form>
		</div>
		<div class="clear"></div>
		<div class="from">@Copyright重庆理工大学中山图书馆</div>
	</div>
</div>
</body>
</html>