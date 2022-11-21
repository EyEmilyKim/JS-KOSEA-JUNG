<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Course, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	header, section, footer {border: 1px solid gray; text-align:center; }
	th, td {text-align:center; padding:0 5px;}
	.left {text-align:left; margin:10px 60px;}
	.right {text-align:right; margin:10px 60px;}
</style>
</head>
<body>
<header>
	<h2>수강신청 도우미 사이트</h2>
</header>
<section>
<%
	ArrayList<Course> list = (ArrayList) request.getAttribute("LIST");
%>
	<div align="center">
	<div class="left">총 <%= list.size() %>개의 교과목이 있습니다.</div>
	<table border="1" >
	<tr><th>과목코드</th><th>과목명</th><th>학점</th><th>담당강사</th>
		<th>요일</th><th>시작시간</th><th>종료시간</th><th>관리</th></tr>
<%
	for(Course crs : list){
%>
	<tr><td><%=crs.getId() %></td>
		<td><%=crs.getName() %></td>
		<td><%=crs.getCredit() %></td>
		<td><%=crs.getLecturer_name() %></td>
		<td><%=crs.getWeek() %></td>
		<td><%=crs.getStart_hour() %></td>
		<td><%=crs.getEnd_hour() %></td>
		<td><a href="courseModify.do?ID=<%=crs.getId() %>">수정</a>
			<a href="courseDelete.do?ID=<%=crs.getId() %>">삭제</a></td>
	</tr>		
<%		
	}
%>	
	</table>
	<div class="right"><input type="button" value="작성" onclick="toAdd()"></div>
	</div>
</section>
<footer>
	<h4>Copyright (C) 2018 정보처리산업기사 All Right Reserved</h4>
</footer>
</body>
<script type="text/javascript">
function toAdd() {
	location.href = "courseAdd.do";
}
</script>
</html>