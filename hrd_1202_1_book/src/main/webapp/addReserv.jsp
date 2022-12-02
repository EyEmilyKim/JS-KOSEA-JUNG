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
	th, td {padding: 0 10px;}
	.btns {margin: 10px;}
</style>
</head>
<body>
<header></header>
<nav>
<%@ include file = "menu_header.jsp" %>
</nav>
<section>
<div class="container">
<h3>도서대출내역 등록</h3>
	<form action="insertReserv.do" method="post" onSubmit="return check(this)">
	<table border="1" align="center">
	<tr><th>대출번호</th>
<%
	Integer last = (Integer) request.getAttribute("LAST");
%>
		<td><input type="text" value="<%=last + 1 %>" name="LENTNO" readonly="readonly"></td></tr>
	<tr><th>대출자</th>
		<td><input type="text" placeholder="이름을 입력하세요" name="CUSTNAME"></td></tr>
	<tr><th>도서명</th>
		<td><select name="BOOKNO">
			<option value="">--도서를 선택하세요--</option>
<%
	ArrayList<Book> list = (ArrayList) request.getAttribute("LIST"); 
	for(Book bk : list){
%>
			<option value="<%=bk.getBookno()%>"><%=bk.getBookname()%></option>
<%
}
%>	
			</select></td></tr>
	<tr><th>대출일</th>
		<td><input type="text" placeholder="yyyy-mm-dd" name="OUTDATE"></td></tr>
	</table>
	<div class="btns">
		<input type="submit" value="등록">
		<input type="reset" value="취소">
	</div>
	</form>
</div>
</section>
<footer></footer>
</body>
<script type="text/javascript">
function check(fm){
	if(! confirm("등록하시겠습니까?")) return false;
}
</script>
</html>