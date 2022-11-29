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
	<h3>후보 조회</h3>
	<div class="contents" align="center">
<%
	ArrayList<Member> list = (ArrayList)request.getAttribute("LIST");
%>	
	<table border="1">
	<tr><th>후보번호</th><th>성명</th><th>소속정당</th><th>학력</th>
		<th>주민번호</th><th>지역구</th><th>대표전화</th></tr>
<%
	for(Member mem : list){
%>
	<tr><td><%=mem.getM_no()%></td>
		<td><%=mem.getM_name()%></td>
		<td><%=mem.getP_name()%></td>
		<td><%=mem.getP_school_str()%></td>
		<td><%=mem.getM_jumin_full()%></td>
		<td><%=mem.getM_city()%></td>
		<td><%=mem.getP_tel_full()%></td></tr>
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