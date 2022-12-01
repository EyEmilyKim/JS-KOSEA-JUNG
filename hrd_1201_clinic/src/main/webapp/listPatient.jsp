<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.* , java.util.* " %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	header, nav, section, footer {text-align:center; }
	th, td {text_align:center; padding:0 10px;}
</style>
</head>
<body>
<header>
<h4>환자 관리 시스템</h4>
</header>
<nav>
<%@ include file="menu_header.jsp" %>
</nav>
<section>
<div class="container">
<h3>환자 목록</h3>
<%
	ArrayList<Patient> list = (ArrayList)request.getAttribute("LIST");
%>
<table align="center" border="1">
	<tr><th>의사코드</th><th>의사명</th><th>주소</th><th>연락처</th></tr>
<%
	for(Patient pt : list){
%>
	<tr><td><%=pt.getP_code()%></td>
		<td><%=pt.getP_name()%></td>
		<td><%=pt.getAddr()%></td>
		<td><%=pt.getTel()%></td></tr>
<%		
	}
%>	
	
</table>
</div>
</section>
<footer>
<h4>Copyright 2021 Kosea All Right Reserved. 2022.12.01 Developed by EyKim</h4>
</footer>
</body>
</html>