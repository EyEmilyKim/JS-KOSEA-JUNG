<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	header, menu, footer {text-align: center;}
	.container {text-align: center;}
	th, td {padding:0px 10px;}
</style>
</head>
<body>
<header>
	<h3>상품정보 관리 시스템</h3>
</header>
<menu>
<%@ include file="menu_header.jsp" %>
</menu>
<section>
<div class="container">
	<h2>상품 정보 등록</h2>
	<form action="insertGoods.do" method="post" onSubmit="return check(this);">
	<table border="1" align="center">
	<tr><th>상품번호</th>
		<td><input type="text" name="GID" placeholder="000000"/></td></tr>
	<tr><th>상품이름</th>
		<td><input type="text" name="NAME" placeholder="000"/></td></tr>
	<tr><th>원산지</th>
		<td><input type="text" name="MADE" placeholder="예) KOREA"/></td></tr>
	<tr><th>상품가격</th>
		<td><input type="number" name="PRICE" placeholder=""/></td></tr>
	</table><br/>
	<input type="submit" value="주문등록" >
	</form>
</div>	
</section>
<footer>
	<h4>Copyright 2021 코세아 인재 개발원 All Right Reserved</h4>
</footer>
</body>
<script type="text/javascript">
function check(fm, list) {
	let gid = fm.GID.value;
	let name = fm.NAME.value;
	let str = "\n\ngid : "+gid+", name : "+name;
	if(! confirm("등록하시겠습니까?"+str) ) return false;
}
</script>
</html>