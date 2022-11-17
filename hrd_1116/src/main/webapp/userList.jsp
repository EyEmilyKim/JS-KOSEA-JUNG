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

<h2 align="center">회원목록 조회/수정</h2>
<br/>

<table border="1">
<tr><th>회원번호</th><th>회원성명</th><th>전화번호</th><th>주소</th>
	<th>가입일자</th><th>고객등급</th><th>거주지역</th></tr>
<%
	ArrayList<Member> list = (ArrayList) request.getAttribute("LIST");
	for(Member mem : list){
%>
<tr><td><a href="memberDetail.do?ID=<%=mem.getId()%>"><%= mem.getId() %></a></td>
	<td><%= mem.getName() %></td>
	<td><%= mem.getTel() %></td>
	<td><%= mem.getAddr() %></td>
	<td><%= mem.getDate() %></td>
	<td><%= mem.getGrade() %></td>
	<td><%= mem.getCity() %></td></tr>
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