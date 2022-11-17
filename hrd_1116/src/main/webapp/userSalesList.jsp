<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*, java.util.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<header>
<h2>쇼핑몰 회원관리 ver1.0</h2>
</header>
<menu>
<%@ include file="menu_header.jsp" %>
</menu>
<section>

<h2 align="center">회원매출 조회</h2>
<br/>

<table border="1">
<tr><th>회원번호</th><th>회원성명</th><th>고객등급</th><th>매출</th></tr>
<%
	ArrayList<UserSales> list = (ArrayList) request.getAttribute("LIST");
	for(UserSales us : list){
%>
<tr><td><%= us.getId() %></td>
	<td><%= us.getName() %></td>
	<td><%= us.getGrade() %></td>
	<td><%= us.getAmount() %></td></tr>
<%		
	}
%>
</table>

<br/>
</section>
<footer>
<h4>HRDKorea Copyright 2022. 과정평가형 시스템 작성</h4>
</footer>
</div>
</body>
</html>