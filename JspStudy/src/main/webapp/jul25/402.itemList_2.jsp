<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>402.itemList_2</title>
</head>
<body>
<div align="center">
<h2>상 품 목 록</h2>
<c:forEach items="${request.ITEMS }" var="item">
	${item.code }
	${item.name }
	${item.price }
</c:forEach>
<!-- <table border="1">
	<tr><th>상품번호</th><th>상품이름</th><th>가 격</th></tr>
	 -->
	<%-- <%
	Item[] items = (Item[])request.getAttribute("ITEMS");
	for(int i=0; i<items.length; i++){
	%>
	<tr><td><%=items[i].code %></td>
		<td><%=items[i].name %></td>
		<td><%=items[i].price %></td>
	<%	
	}
	%> --%>
</table>
</div>
</body>
</html>