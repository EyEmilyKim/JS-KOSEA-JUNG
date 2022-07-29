<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>logout</title>
</head>
<body>
<c:set var="id" value="${sessionScope.LOGINID }"/>
<c:set var="man" value="${sessionScope.MANAGER }"/>
<%-- <%
	String id = (String)session.getAttribute("LOGINID");
	String man = (String)session.getAttribute("MANAGER");
%> --%>
<form action="405.logoutProcess.jsp">
<c:choose>
	<c:when test="${! empty man }">환영합니다~ ${man }님~~~</c:when>
	<c:when test="${id != null }">환영합니다~ ${id }님~~~</c:when>
</c:choose>
<%-- <%
	if(man != null) out.print("환영합니다~"+man+"님~~");
	else if(id != null) out.print("환영합니다~"+id+"님");
%> --%>
<input type="submit" value="로그아웃"/>
</form>
</body>
</html>