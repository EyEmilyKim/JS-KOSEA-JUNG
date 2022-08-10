<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>busResult</title>
<style type="text/css">
.center { text-align:center; }
</style>
</head>
<body>
<div align="center">
<p>총 구매액은 <font color='blue'><fmt:formatNumber value="${param.SUM}" groupingUsed="true"/></font>원입니다.</p>
<table>
	<tr><td class="center">목적지</td><td>${param.D }</td></tr>
	<tr><td class="center">좌 석</td>
	<td>
		<c:choose>
			<c:when test="${param.S=='1' }">일반</c:when>
			<c:when test="${param.S=='2' }">우등</c:when>
		</c:choose>
	</td></tr>
	<tr><td class="center">인 원</td><td>${param.N }</td></tr>
	<tr><td class="center">총 액</td>
	<td><fmt:formatNumber>${param.SUM }</fmt:formatNumber></td></tr></table>
<p>이용해주셔서 감사합니다.</p>
</div>

<%-- <%
String total = request.getParameter("SUM");
out.print("총 구매액은 <font color='blue'>"+total+"</font>원입니다.<br/>");
out.print("이용해주셔서 감사합니다.<br/>");
%> --%>
</body>
</html>