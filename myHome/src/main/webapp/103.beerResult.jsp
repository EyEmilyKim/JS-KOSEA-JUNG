<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>beerResult</title>
</head>
<body>
<div>
<h2>추천된 맥주 목록</h2>
<table border="1">
<tr><th>일련번호</th><th>추천된 맥주 이름</th></tr>
<c:set var="cnt" value="1"/>
<c:forEach items="${requestScope.BRAND}" var="name">
	<tr>
		<td>${cnt }</td>
		<c:set var="cnt" value="${cnt+1}"/>
		<td>${name}</td>
	</tr>	 
</c:forEach>
<%-- <%
	String[] names = (String[])request.getAttribute("BRAND");
	int count = names.length;
	for(int i=0; i<count; i++){
		out.print("<tr><td>"+(i+1)+"</td>");
		out.print("<td>"+names[i]+"</td></tr>");
	}
%> --%>
</table>
</div>
</body>
</html>