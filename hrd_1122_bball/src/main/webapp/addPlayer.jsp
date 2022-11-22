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
	th {text-align:center; padding: 0px 10px;}
	td {text-align:left; padding: 0px 10px;}
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
	<h2>야구 선수 등록</h2>
	<form action="insertPlayer.do" method="post" onsubmit="return check(this);">
	<table border="1" align="center">
<%
	Integer seqno = (Integer) request.getAttribute("MaxSeqno") + 1;
%>	
	<input type="hidden" value="<%=seqno%>">
	<tr><th>이름</th>
		<td><input type="text" name="NAME"/></td></tr>
	<tr><th>주소</th>
		<td><input type="text" name="ADDR"/></td></tr>
	<tr><th>생년월일</th>
		<td><input type="text" name="BIRTH"/></td></tr>
	<tr><th>소속팀</th>
		<td><select name="T_ID">
<%
	ArrayList<Team> list = (ArrayList) request.getAttribute("LIST");
	for(Team tm : list){
%>
			<option value="<%=tm.getT_id()%>"><%=tm.getTitle()%></option>	
<% 		
	}
%>	
			</select></td></tr>
	<tr><th>등번호</th>
		<td><input type="text" name="B_NUM"/></td></tr>
	<tr><th>연봉</th>
		<td><input type="number" name="ANN_SAL"/></td></tr>
	
	</table><br/>
	<input type="submit" value="등 록">
	<input type="reset" value="취 소">
	</form>
</div>	
</section>
<footer>
	<h4>Copyright 2021 코세아 인재 개발원 All Right Reserved</h4>
</footer>
</body>
<script type="text/javascript">
function check(fm) {
	let seqno = fm.SEQNO.value;
	let name = fm.NAME.value;
	let str = "\n\n일련번호: "+seqno+", 이름: "+name;
	if(! confirm("등록하시겠습니까?"+str)) return false;
}
</script>
</html>