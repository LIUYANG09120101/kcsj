<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>搜索结果</title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
	<link rel="stylesheet" type="text/css" href="../style/searchResult.css">
	<link rel="stylesheet" type="text/css" href="../font-awesome/css/font-awesome.min.css">
	<script type="text/javascript" src="../script/jquery-2.1.4.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
        	$(".bor_btn").click(function() {
        		var num=$(this).find("span").html();
        		if (num<=0) {
        			alert("该书被借光了~~");
        		}
        		else{
        			alert("请到图书管理员处借阅~~");
        		}
        	});
        	var btns=$(".bor_btn");
        	for (var i = 0; i < btns.length; i++) {
        		var num=$(btns[i]).find("span").html();
        		if (num==0) {
                    $(".bor_btn").eq(i).css('backgroundColor', '#BCBCBC');
        		}
        		else{
        			$(".bor_btn").eq(i).css('backgroundColor', '#28B138');
        		}
        	};
        });
    </script>
</head>
<body>
<div class="search_page">
	<div class="header">
		<div class="home"><a href="index"><i class="fa fa-home"></i>首页</a></div>
		<%
			String readername = (String) session.getAttribute("username");
			String adname = (String) session.getAttribute("Adname");
			String sysname = (String) session.getAttribute("SysAdname");
			if(readername!=null){
				out.print("<div class=\"login\"><a href=\"readerPersonal\" style=\"text-decoration:none; color: white\">"+readername+"</a></div>");
			}
			else if(adname!=null){
				out.print("<div class=\"login\"><a href=\"adPersonal\" style=\"text-decoration:none; color: white\">"+adname+"</a></div>");
			}
			else if (sysname!=null){
				out.print("<div class=\"login\"><a href=\"adminPersonal\" style=\"text-decoration:none; color: white\">"+sysname+"</a></div>");
			}
			else {
				out.print("<div class=\"login\"><a href=\"login\" style=\"text-decoration:none; color: white\">登录</a></div>");
			}
		%>
		<div class="clear"></div>
	</div>
	<div class="content">
        <div class="search">
            <form action="findNameBookInfo" method="get">
                <input class="search_input" type="text" name="BookName" value="${BookName}"/>
                <button class="sch_btn">搜索</button>
            </form>
        </div>

		<c:forEach items="${Books}" var="book">
		<div class="result">
			<div class="book_result">
				<div class="bk_name">${book.bookName}</div>
				<ul>
					<li>作者：${book.author}</li>
					<li>出版社：${book.publishCompany}</li>
				</ul>

				<div class="bor_btn">
					<div class="btn_name">借阅</div>
					<div class="bk_num">在库数量：<span>${book.number}</span>本</div>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		</c:forEach>
	</div>
</div>
</body>
</html>