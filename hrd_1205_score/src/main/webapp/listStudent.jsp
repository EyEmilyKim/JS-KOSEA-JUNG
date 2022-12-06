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
	th, td {text-align: center; padding: 0 5px;}
</style>
</head>
<body>
<header>
	<h4>(과정평가형 정보처리산업기사)실기복원 ver2022-10 성적 관리 프로그램</h4>
</header>
<nav>
	<%@ include file ="menu_header.jsp" %>
</nav>
<section>
	<div align="center">
	<h3>학생 조회</h3>
	<table border="1">
	<tr><th>학번</th><th>학생이름</th><th>주민번호</th><th>학과</th>
		<th>성별</th><th>전화번호</th><th>이메일</th></tr>	
<%
	ArrayList<Student> list = (ArrayList) request.getAttribute("LIST");
	for(Student std : list){
		String jumin_fmt = std.getJumin_first()+"-"+std.getJumin_last();
		String gender_str = "";
		if( Integer.parseInt(std.getGender_code())%2 == 0){
			gender_str = "여자";
		}else{
			gender_str = "남자";
		}
%>	
	<tr><td><%=std.getSid()%></td>
		<td><%=std.getSname()%></td>
		<td><%=jumin_fmt%></td>
		<td><%=std.getDept_name()%></td>
		<td><%=gender_str%></td>
		<td><%=std.getPhone()%></td>
		<td><%=std.getEmail()%></td></tr>
<%
	}
%>
	</table>	
	</div>
</section>
<footer>
	<h4>HRDKorea Copyright 2022. Developed by EyKim 2022.12.05</h4> 
</footer>
</body>
</html>