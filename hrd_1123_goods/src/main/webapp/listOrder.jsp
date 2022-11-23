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
	<h2>상품 주문 정보</h2>
	<table border="1" align="center">
	<tr><th>상품번호</th><th>상품명</th><th>주문자명</th><th>상품가격</th>
		<th>주문자 주소</th><th>주문자 연락처</th><th>주문일</th><th>삭제</th></tr>
<%
	ArrayList<Order> list = (ArrayList) request.getAttribute("LIST");
	for(Order odr : list){
%>
	<tr><td><%=odr.getId()%></td>	
		<td><%=odr.getName()%></td>	
		<td><%=odr.getG_name()%></td>	
		<td><%=odr.getPrice()%></td>	
		<td><%=odr.getAddr()%></td>	
		<td><%=odr.getPhone()%></td>	
		<td><%=odr.getO_date()%></td>	
		<td><a href="deleteOrder.do?CNO=<%=odr.getG_name()%>&GID=<%=odr.getId()%>&ODATE=<%=odr.getO_date()%>">
		삭제</a></td></tr>
				
<% 		
	}
%>	
	</table><br/>
	<input type="button" value="주문등록" onclick="addOrder()">
</div>	
</section>
<footer>
	<h4>Copyright 2021 코세아 인재 개발원 All Right Reserved</h4>
</footer>
</body>
<script type="text/javascript">
function addOrder() {
	location.href = "addOrder.do";
}
</script>
</html>