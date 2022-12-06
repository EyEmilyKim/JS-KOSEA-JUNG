<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.* , java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
header, section, footer {text-align: center; } 
	nav {text-align: left; background-color:skyblue; color:white; padding:10px; }
	.main {align-content: center; padding: 10px;}
	th, td {text-align:center; padding: 0px 30px;}
 	.right {text-align:right; padding: 0 5px;} 
</style>
</head>
<body>
<header>
 	<h3>(과정평가형 정보처리산업기사)물류창고 입출고 프로그램</h3>
</header>
<nav>
<%@ include file="menu_header.jsp" %>
</nav>
<section>
	<div align="center">
	<h3>제품조회</h3>
	<div class="main">
	<table border="1">
	<tr><th>제품코드</th><th>제품명</th>
		<th>사이즈</th><th>매입단가</th><th>출고단가</th></tr>
<%
	ArrayList<Product> list = (ArrayList) request.getAttribute("LIST");
	for(Product prd : list){
%>	
	<tr><td><%=prd.getP_code()%></td>
		<td><%=prd.getP_name()%></td>
		<td><%=prd.getP_size()%>mm</td>
		<td class="right">￦<%=prd.getP_incost_str()%></td>
		<td class="right">￦<%=prd.getP_outcost_str()%></td></tr>
<%
	}
%>
	</table>
	</div>
	</div>
</section>
<footer>
	<h4>HRDKOREA Copyrightⓒ2020 All right reserved. Human Resources Development Service of Korea</h4>
</footer>
</body>
</html>