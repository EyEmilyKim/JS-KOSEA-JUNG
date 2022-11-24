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
	<h2>상품 목록</h2>
	<table border="1" align="center">
	<tr><th>상품번호</th><th>상품명</th><th>원산지</th><th>상품가격</th><th>삭제</th></tr>
<%
	ArrayList<Goods> list = (ArrayList) request.getAttribute("LIST");
	for(Goods gds : list){
%>
	<tr><td><%=gds.getId()%></td>	
		<td><%=gds.getName()%></td>	
		<td><%=gds.getPrice()%></td>	
		<td><%=gds.getMade()%></td>	
		<td><a href="deleteGoods.do?GID=<%=gds.getId()%>">
		삭제</a></td></tr>
				
<% 		
	}
%>	
	</table><br/>
	<input type="button" value="상품등록" onclick="addGoods()">
</div>	
</section>
<footer>
	<h4>Copyright 2021 코세아 인재 개발원 All Right Reserved</h4>
</footer>
</body>
<script type="text/javascript">
function addGoods() {
	location.href = "addGoods.do";
}
</script>
</html>