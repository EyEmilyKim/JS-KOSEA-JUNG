<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.* , java.util.* " %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	header , section , footer {text-align:center; }
</style>
</head>
<body>
<header>
<h4>환자 관리 시스템</h4>
</header>
<section>
<div class="container">
<h3>환자 진료 목록</h3>
<%
	ArrayList<Patient> list = (ArrayList)request.getAttribute("LIST");
%>
<table align="center" border="1">
	<tr><th>환자코드</th><th>환자명</th><th>주소</th><th>진료과목</th>
		<th>담당의사</th><th>병실번호</th><th>등록일</th><th>삭제</th></tr>
<%
	for(Patient pt : list){
%>
	<tr><td><%=pt.getP_code()%></td>
		<td><%=pt.getP_name()%></td>
		<td><%=pt.getAddr()%></td>
		<td><%=pt.getM_title()%></td>
		<td><%=pt.getD_name()%></td>
		<td><%=pt.getRoom()%></td>
		<td><%=pt.getReg_date()%></td>
		<td>삭제</td></tr>
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