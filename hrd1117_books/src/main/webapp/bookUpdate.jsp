<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*, java.util.*"  %>        
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
<form action="bookUpdate.do" method="post" onSubmit="return check(this);">
<%
	Book bk = (Book) request.getAttribute("BOOK");
%>
<table border="1">
	<tr><th>도서번호</th>
		<td><input type="text" name="ID" value="<%=bk.getId()%>" readOnly="readOnly"></td></tr>
	<tr><th>도서명</th>
		<td><input type="text" name="NAME" value="<%=bk.getName()%>" ></td></tr>
	<tr><th>저자명</th>
		<td><select name="WRITER" >
<% 
	ArrayList<Writer> list = (ArrayList) request.getAttribute("LIST");
	String wno = bk.getWriter();
	for(Writer wr : list){
		if(wr.getNo().equals(wno)){
%>
			<option value="<%=wr.getNo()%>" selected="selected" ><%=wr.getName()%></option>
<%		
		}else {
%> 
			<option value="<%=wr.getNo()%>" ><%=wr.getName()%></option>
<%
		}
	}	
%>		
			</select></td></tr>
	<tr><th>출판사명</th>
		<td><input type="text" name="PUB" value="<%=bk.getPublisher()%>" ></td></tr>
	<tr><th>가격</th>
		<td><input type="text" name="PRICE" value="<%=bk.getPrice()%>" ></td></tr>
	<tr><th>출판일</th>
		<td><input type="text" name="P_DATE" value="<%=bk.getP_date()%>" placeholder="yyyy/mm/dd"></td></tr>
</table><br/>
	<input type="submit" value="변경 저장">
</form>
</section>
<footer>
	<h5>Copyright 2021 코세아 인재 개발원 All Right Reserved</h5>
</footer>
</div>
</body>
<script type="text/javascript">
function check(fm){
	let str = "\n\np_date : "+fm.P_DATE.value;
	if(! confirm("저장하시겠습니까?"+str) ) return false;
}
</script>
</html>