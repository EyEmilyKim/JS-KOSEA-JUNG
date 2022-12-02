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
	<tr><th>도서번호</th><th>도서명</th><th>도서상태</th></tr>
<%
	ArrayList<Book> list = (ArrayList) request.getAttribute("LIST"); 
	for(Book bk: list){
		switch(bk.getStatus()){
		case "1":
			bk.setStatus_str("대출중");
			break;
		case "2":
			bk.setStatus_str("대출가능");
			break;
		}
%>
	<tr><td><%=bk.getBookno()%></td>
		<td><%=bk.getBookname()%></td>
		<td><%=bk.getStatus_str()%></td></tr>
<%
	}
%>	
	</table>	
</div>
</section>
<footer></footer>
</body>
</html>