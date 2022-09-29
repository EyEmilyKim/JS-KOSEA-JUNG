<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>allMembers</title>
<link type="text/css" rel="stylesheet" href="myStyle.css">
</head>
<body>
<header>
	<h1 align="center">쇼핑몰 회원관리 ver1.0</h1>
</header>
<nav>
	<%@ include file="menu_header.jsp" %>
</nav>
<section>
	<div align="center">
	<h2 align="center">회원목록 조회/수정</h2>
	<table border="1">
	<tr>
		<th>회원번호</th><th>회원성명</th><th>전화번호</th>
		<th>주소</th><th>가입일자</th><th>고객등급</th>
		<th>거주지역</th></tr>
	<c:forEach items="${requestScope.LIST }" var="m">
	<tr>
		<td><a href="getMemberDetail.do?NO=${m.custno }">${m.custno }</a></td>
		<td>${m.custname }</td>
		<td>${m.phone }</td>
		<td>${m.address }</td>
		<td>${m.joindate }</td>
		<td>${m.grade }</td>
		<td>${m.city }</td></tr>
	</c:forEach>
	</table>
	</div>
</section>
<footer>
	<h3 align="center">코세아 Copyright 2022.</h3>
</footer>
</body>
</html>