<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>study1.jsp</title>
</head>
<body>
<%!
	int j = 1;
%>
<%
	int i = 1;
	i = 1 + 1;
	j = j + 1;
%>
변수 i = <%= i %> , j = <%= j %>
</body>
</html>