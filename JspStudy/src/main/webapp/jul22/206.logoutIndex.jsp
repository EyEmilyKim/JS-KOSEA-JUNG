<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>206.logoutIndex</title>
</head>
<body>
<%
	session.invalidate();
	response.sendRedirect("2.index.jsp");
%>
</body>
</html>