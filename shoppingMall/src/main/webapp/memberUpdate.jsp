<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberUpdate</title>
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
	<h2 align="center">홈쇼핑 회원 정보 수정</h2>
	<form action="">
	<table border="1">
		<tr><th>회원번호</th>
			<td><input type="text" name="NO" value="${MEM.custno }" readOnly="readOnly"/></td></tr>
		<tr><th>회원성명</th>
			<td><input type="text" name="NAME" value="${MEM.custname }"/></td></tr>
		<tr><th>전화번호</th>
			<td><input type="text" name="TEL" value="${MEM.phone }"/></td></tr>
		<tr><th>주 소</th>
			<td><input type="text" name="ADDR" value="${MEM.address }"/></td></tr>
		<tr><th>가입일자</th>
			<td><input type="text" name="DATE" value="${MEM.joindate }"/></td></tr>
		<tr><th>고객등급[A:VIP, B:일반, C:직원]</th>
			<td>
<%--			<input type="text" name="GRADE" value="${MEM.grade}"/> --%>
<!-- 콤보박스가 뜰 때, 해당 회원정보의 등급 데이터가 디폴트 값으로 입력돼있도록 만들어야 함 -->
				<select name="GRADE">
				<c:if test="${MEM.grade == 'A' }">
					<option selected="seleceted">A</option>
				</c:if>
				<c:if test="${MEM.grade != 'A' }">
					<option>A</option>
				</c:if>
				<c:if test="${MEM.grade == 'B' }">
					<option selected="seleceted">B</option>
				</c:if>
				<c:if test="${MEM.grade != 'B' }">
					<option>B</option>
				</c:if>
				<c:if test="${MEM.grade == 'C' }">
					<option selected="seleceted">C</option>
				</c:if>
				<c:if test="${MEM.grade != 'C' }">
					<option>C</option>
				</c:if>
				</select></td></tr>
		<tr><th>도시코드</th>
			<td><input type="text" name="CITY" value="${MEM.city }"/></td></tr>
		<tr><td colspan="2" align="center">
			<input type="submit" value="수정"/>
			<input type="submit" value="조회"/></td></tr>
	</table>
	</form>
	</div>
</section>
<footer>
	<h3 align="center">코세아 Copyright 2022.</h3>
</footer>
</body>
</html>