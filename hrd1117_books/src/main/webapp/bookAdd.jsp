<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Writer, java.util.*"  %>        
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
<h4>도서 등록 화면</h4>
<form action="bookInsert.do" method="post" onSubmit="return check(this);">
<table border="1">
	<tr><th>도서번호</th>
		<td><input type="text" name="ID" placeholder="000000"></td></tr>
	<tr><th>도서명</th>
		<td><input type="text" name="NAME"></td></tr>
	<tr><th>저자명</th>
		<td><select name="WRITER">
<% 
	ArrayList<Writer> list = (ArrayList) request.getAttribute("LIST");
	for(Writer wr : list){
%>
			<option value="<%=wr.getNo() %>"><%=wr.getName() %></option>
<%		
	}
%>		
			</select></td></tr>
	<tr><th>출판사명</th>
		<td><input type="text" name="PUB"></td></tr>
	<tr><th>가격</th>
		<td><input type="text" name="PRICE"></td></tr>
	<tr><th>출판일</th>
		<td><input type="text" name="P_DATE" placeholder="yyyy/mm/dd"></td></tr>
</table><br/>
	<input type="submit" value="도서 등록">
</form>
</section>
<footer>
	<h5>Copyright 2021 코세아 인재 개발원 All Right Reserved</h5>
</footer>
</div>
</body>
<script type="text/javascript">
function check(fm){
	let str = "\n\nprice : "+fm.PRICE.value;
	if(! confirm("등록하시겠습니까?"+str) ) return false;
}
</script>
</html>