<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginResult</title>
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
	<h2 align="center">로그인 결과</h2>
	<c:choose>
		<c:when test="${param.R == 'NOID' }">
			<h3>계정이 존재하지 않습니다.</h3>
		</c:when>
		<c:when test="${param.R == 'NOPWD' }">
			<h3>암호가 일치하지 않습니다.</h3>
		</c:when>
		<c:otherwise>
			<h3>로그인 되었습니다.</h3>
		</c:otherwise>
	</c:choose>
	
	</div>
</section>
<footer>
	<h3 align="center">코세아 Copyright 2022.</h3>
</footer>
</body>
</html>