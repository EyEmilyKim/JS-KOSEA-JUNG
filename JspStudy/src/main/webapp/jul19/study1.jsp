<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2>상 품 목 록</h2>
<%
String[] items = {"포도","키위","딸기","레몬","오렌지"};
String[] code = {"A001","A002","A003","A004","A005"};
int[] price={10000,9000,11000,6000,5000};
%>
<table border="1">
	<tr><th>상품번호</th><th>상품이름</th><th>상품가격</th>
		<th>개수</th><th>구매</th></tr>
<%
	for(int i=0; i<items.length; i++){
%>		
	<form action="makeTotal.jsp">
	<input type="hidden" name="PRICE" value="<%=price[i] %>"/>
	<tr><td><%=code[i]%></td><td><%=items[i]%></td>
		<td><%=price[i]%></td>
		<td><select name="NUM">
		<% 
		 for(int cnt=1; cnt<11; cnt++){
			 out.print("<option>"+cnt+"</option>");
		 }
		%>
		</select></td>
		<td><input type="submit" value="구매하기"/><a href="#" 
		onClick="window.open('makeTotal.jsp?PRICE=<%=price[i] %>&NUM=1','_blank_','width=200 height=200')">구매하기</a></td></tr></form>		
<%
	}
%>
</div>
</body>
</html>