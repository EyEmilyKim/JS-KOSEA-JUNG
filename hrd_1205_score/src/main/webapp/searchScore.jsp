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
	#fm {margin: 10px;}
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
	<h3>성적 검색</h3>
		
	<form action="searchScore.do" method="post" id="fm" onclick="return check(this)">
	<select name="SUBCODE">
<%
	ArrayList<Subject> list = (ArrayList) request.getAttribute("LIST");
	for(Subject sbj : list){
%>	
		<option value="<%=sbj.getSubcode()%>"><%=sbj.getSubcode()%> - <%=sbj.getSubcode()%></option>
<%
	}
%>	
	
	</select>
	<input type="submit" value="조회">
	</form>
	
	<table border="1">
	<tr><th>학번</th><th>학생이름</th>
		<th>교과목</th><th>교과목코드</th><th>담당교수</th>
		<th>중간</th><th>기말</th><th>출석</th><th>레포트</th><th>기타</th>
		<th>평균</th><th>총점</th><th>학점</th></tr>	

	</table>	
	</div>
</section>
<footer>
	<h4>HRDKorea Copyright 2022. Developed by EyKim 2022.12.05</h4> 
</footer>
</body>
<script type="text/javascript">
</script>
</html>