<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gababoResult</title>
</head>
<body>
<div align="center">
<strong>
게이머 : 
<font color="blue"><c:choose>
	<c:when test="${param.G==1 }">가위</c:when>
	<c:when test="${param.G==2 }">바위</c:when>
	<c:when test="${param.G==3 }">보</c:when>
</c:choose></font>
 vs 컴퓨터 : 
<font color="blue"><c:choose>
	<c:when test="${param.C==1 }">가위</c:when>
	<c:when test="${param.C==2 }">바위</c:when>
	<c:when test="${param.C==3 }">보</c:when>
</c:choose></font>
</strong><br/>
<font color="red" size="5">
<!-- EL & JSTL 로 JAVA 대체 -->
<c:choose>
	<c:when test="${param.R ==1 }">
		게이머 승 !
	</c:when>
	<c:when test="${param.R ==0 }">
		무승부~~
	</c:when>
	<c:otherwise>
		컴퓨터 승...
	</c:otherwise>
</c:choose>
<%-- <%
	String r = request.getParameter("R");
	int result = Integer.parseInt(r);
	if(result==1){
		out.print("YOU WIN!!");
	}else if(result==0){
		out.print("DRAW~~");
	}else{
		out.print("YOU LOSE...");
	}
%> --%>
</font>
</div>
</body>
</html>