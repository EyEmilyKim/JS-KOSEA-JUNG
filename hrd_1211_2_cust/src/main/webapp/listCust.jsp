<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	section, footer {text-align: center; padding: 10px;}
	th, td {padding: 0 10px;}
	.jump {margin: 10px;}
</style>
</head>
<body>
<header></header>
<nav>
</nav>
<section>
<div class="container">
<h3>회원 목록 조회</h3>
	<table border="1" align="center">
	<tr><th>회원아이디</th><th>회원이름</th><th>이메일</th><th>연락처</th></tr>
<%
	ArrayList<Customer> list = (ArrayList) request.getAttribute("LIST"); 
	for(Customer cst : list){
%>
	<tr><td><%=cst.getP_id()%></td>
		<td><%=cst.getC_name()%></td>
		<td><%=cst.getC_email()%></td>
		<td><%=cst.getC_tel()%></td>
<%
	}
%>	
	</table>	
	<div class="jump">
	<button onClick="jumpTo()">제3과제 html(jsp)로</button>
	</div>
</div>
</section>
<footer>HRDKOREA Copyright@2015 developed by EyKim 2022.12.02</footer>
</body>
<script type="text/javascript">
function jumpTo() {
	location.href="quest3.jsp";
}
</script>
</html>