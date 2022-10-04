<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
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
	<h2 align="center">쇼핑몰 로그인</h2>
	<div align="center">
	<form action="login.do" method="post" onSubmit="return check(this)">
	<table>
		<tr><th>사용자 ID</th>
			<td><input type="text" name="ID"/></td></tr>
		<tr><th>암 호</th>
			<td><input type="password" name="PWD"/></td></tr>
	</table>
	<table>
		<tr><td align="center">
			<input type="submit" value="로그인"/></td>
			<td align="center">
			<input type="reset" value="취소"/></td></tr>
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
	if(fm.ID.value==''){
		alert("계정을 입력하세요."); return false;	
	}
	if(fm.PWD.value==''){
		alert("암호를 입력하세요."); return false;	
	}
	
}
</script>
</html>