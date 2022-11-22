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
	<h3>야구선수 관리 시스템</h3>
</header>
<menu>
<%@ include file="menu_header.jsp" %>
</menu>
<section>
<div class="container">
	<h2>야구 선수 목록</h2>
	<table border="1" align="center">
	<tr><th>번호</th><th>이름</th><th>주소</th><th>생년월일</th>
		<th>소속팀</th><th>연봉</th><th>등번호</th></tr>
<%
	ArrayList<Player> list = (ArrayList) request.getAttribute("LIST");
	for(Player pl : list){
%>
	<tr><td><a href="detailPlayer.do?SEQNO=<%=pl.getSeqno()%>"><%=pl.getSeqno()%></a></td>	
		<td><%=pl.getName()%></td>	
		<td><%=pl.getAddr()%></td>	
		<td><%=pl.getBirth()%></td>	
		<td><%=pl.getT_title()%></td>	
		<td><%=pl.getAnn_sal()%></td>	
		<td><%=pl.getB_num()%></td></tr>	
<% 		
	}
%>	
	</table><br/>
	
</div>	
</section>
<footer>
	<h4>Copyright 2021 코세아 인재 개발원 All Right Reserved</h4>
</footer>
</body>
</html>