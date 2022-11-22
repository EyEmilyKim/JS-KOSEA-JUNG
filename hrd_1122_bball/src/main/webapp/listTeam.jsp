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
	<h2>팀 정보</h2>
	<table border="1" align="center">
	<tr><th>팀번호</th><th>팀이름</th><th>연고지역</th><th>구단주</th><th>창단일</th></tr>
<%
	ArrayList<Team> list = (ArrayList) request.getAttribute("LIST");
	for(Team tm : list){
%>
	<tr><td><%=tm.getT_id()%></td>	
		<td><%=tm.getTitle()%></td>	
		<td><%=tm.getTown()%></td>	
		<td><%=tm.getOwner()%></td>	
		<td><%=tm.getFounding()%></td></tr>	
<% 		
	}
%>	
	</table><br/>
	<input type="button" value="선수등록" onclick="addPlayer()">
	<input type="button" value="선수목록" onclick="listPlayer()">
</div>	
</section>
<footer>
	<h4>Copyright 2021 코세아 인재 개발원 All Right Reserved</h4>
</footer>
</body>
<script type="text/javascript">
function listPlayer() {
	location.href = "listPlayer.do";
}
function addPlayer() {
	location.href = "addPlayer.do";
}
</script>
</html>