<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	header, nav, section, footer {text-align:center; border: 1px solid gray; padding: 10px;}
	th, td {padding:0 10px; text-align:center;}
</style>
</head>
<body>
<header>
	<h4>(과정평가형 정보처리산업기사) 지역구의원투표 프로그램 ver 2020-05</h4>
</header>
<nav>
	<%@ include file="menu_header.jsp" %>
</nav>
<section>
	<h3>후보자 등수</h3>
	<div class="contents" align="center">
<%
	ArrayList<Member> list = (ArrayList)request.getAttribute("LIST");
%>	
	<table border="1">
	<tr><th>후보번호</th><th>성명</th><th>총투표건수</th></tr>
<%
	for(Member mem : list){
%>
	<tr><td><%=mem.getM_no()%></td>
		<td><%=mem.getM_name()%></td>
		<td><%=mem.getM_votedAmnt()%></td>
<%		
	}
%>	
	</table>
	</div>
</section>
<footer>
	<h4>HRDKorea Copyright@2015 All rights reserved. 2022.11.29 Developed by EyKim</h4>
</footer>
</body>
</html>