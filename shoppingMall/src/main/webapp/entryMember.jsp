<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>entryMember</title>
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
	<h2 align="center">홈쇼핑 회원등록</h2>
	<div align="center">
	<form action="putMember.do" method="Post" onSubmit="return check(this)">
	<table border="1">
		<tr><th>회원번호(자동발생)</th>
			<td><input type="text" name="NO" value="${requestScope.MAX }" readOnly="readonly"/></td></tr>
		<tr><th>회원성명</th>
			<td><input type="text" name="NAME" size="20"/></td></tr>
		<tr><th>회원전화</th>
			<td><input type="text" name="TEL" size="20"/></td></tr>
		<tr><th>회원주소</th>
			<td><input type="text" name="ADDR" size="50"/></td></tr>
		<tr><th>가입일자</th>
			<td><input type="date" name="DATE" /></td></tr>
		<tr><th>고객등급[A:VIP, B:일반, C:직원]</th>
			<td><select name="GRADE">
				<option>A</option><option>B</option><option>C</option>
				</select></td></tr>
		<tr><th>도시코드</th>
			<td><input type="text" name="CITY" size="20"/></td></tr>
		<tr><td colspan="2" align="center">
			<input type="submit" value="등 록"/>		
			<input type="button" value="조 회"/></td></tr>		
	</table>
	</form>
	</div>
</section>
<footer>
	<h3 align="center">코세아 Copyright 2022.</h3>
</footer>
</body>
<script type="text/javascript">
function check(fm){
	if(fm.NAME.value==''){
		alert("이름을 입력하세요."); return false;
	}
	if(fm.TEL.value==''){
		alert("전화번호를 입력하세요."); return false;
	}
	if(fm.ADDR.value==''){
		alert("주소를 입력하세요."); return false;
	}
	if(fm.DATE.value==''){
		alert("가입일자를 입력하세요."); return false;
	}
	if(fm.GRADE.value==''){
		alert("고객등급을 입력하세요."); return false;
	}
	if(fm.CITY.value==''){
		alert("도시코드를 입력하세요."); return false;
	}
	if(! confirm("정말로 가입하시겠습니까?")) return false;
}
</script>
</html>