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
	<h2>주문 정보 등록</h2>
	<form action="addOrder.do" method="post" onSubmit="return check(this);">
	<table border="1" align="center">
	<tr><th>상품번호</th>
		<td><input type="text" name="GID" placeholder="000000"/></td></tr>
	<tr><th>고객번호</th>
		<td><input type="text" name="CNO" placeholder="000"/></td></tr>
	<tr><th>주문일</th>
		<td><input type="text" name="O_DATE" placeholder="yyyymmdd"/></td></tr>

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
function check(fm) {
	let gid = fm.GID.value;
	let cno = fm.CNO.value;
	let odate = fm.O_DATE.value;
	let str = "\n\ngid : "+gid+", cno : "+cno+", odate : "+odate;
	if(! confirm("등록하시겠습니까?"+str) ) return false;
}
</script>
</html>