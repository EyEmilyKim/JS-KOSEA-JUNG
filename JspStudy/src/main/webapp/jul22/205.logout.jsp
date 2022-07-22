<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>205.logout</title>
</head>
<body>
<!-- <h3 align="center">로그아웃 결과</h3> -->
<%-- <%@ include file="101.menu_header.jsp" %> --%>
<%
// session.invalidate();
// out.print("로그아웃 되었습니다~<br/>");
// out.print("또 방문해주세요~<br/>");
	String id = (String)session.getAttribute("MEMBER");
%>
<form action="206.logoutIndex.jsp">
환영합니다~ <%= id %>님~<br/>
<input type="submit" value="로그아웃"/>
</form>
</body>
</html>