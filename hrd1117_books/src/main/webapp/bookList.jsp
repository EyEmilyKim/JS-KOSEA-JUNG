<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Book, java.util.*"  %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<header>
	<h3>도서 정보 관리 ver1.0</h3>
</header>
<menu>
<%@ include file ="menu_header.jsp" %>
</menu>
<section>
<h4>도서 목록 화면</h4>
<table border="1">
	<tr><th>도서번호</th><th>도서명</th><th>저자명</th><th>출판사명</th>
		<th>가격</th><th>출판일</th><th>변경/삭제</th></tr>
<%
	ArrayList<Book> list = (ArrayList) request.getAttribute("LIST");
	for(Book bk : list){
%> 
	<tr><td><%= bk.getId() %></td>
		<td><%= bk.getName() %></td>
		<td><%=bk.getWriter()%></td>
		<td><%= bk.getPublisher() %></td>
		<td><%= bk.getPrice() %></td>
		<td><%= bk.getP_date() %></td>
		<td>변경/삭제</td></tr>
<%		
	}
%>		
</table>

</section>
<footer>
	<h5>Copyright 2021 코세아 인재 개발원 All Right Reserved</h5>
</footer>
</div>
</body>
</html>