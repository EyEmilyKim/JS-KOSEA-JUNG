<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	header, nav, section, footer {text-align: center;}
	th, td {padding: 0 10px;}
</style>
</head>
<body>
<header></header>
<nav>
<%@ include file = "menu_header.jsp" %>
</nav>
<section>
<div class="container">
<h3>도서대출내역 조회</h3>
	<table border="1" align="center">
	<tr><th>대출번호</th><th>대출자</th><th>도서명</th>
		<th>대출일</th><th>반납일</th></tr>
<%
	ArrayList<Reservation> list = (ArrayList) request.getAttribute("LIST"); 
	for(Reservation rsv : list){
%>
	<tr><td><%=rsv.getLentno() %></td>
		<td><%=rsv.getCustname() %></td>
		<td><%=rsv.getBookname() %></td>
		<td><%=rsv.getOutdate() %></td>
		<td><%=rsv.getIndate() %></td></tr>
<%
	}
%>	
	</table>	
</div>
</section>
<footer></footer>
</body>
</html>