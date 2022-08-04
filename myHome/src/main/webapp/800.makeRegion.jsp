<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>800.makeRegion</title>
</head>
<body>
<%
	String[] zone = TimeZone.getAvailableIDs();
	//showWorld.jsp로 전환 => Forward 방식
	request.setAttribute("ZONE", zone);
	RequestDispatcher r = request.getRequestDispatcher("template.jsp?BODY=801.showRegion.jsp");
	r.forward(request, response);
	
%>
</body>
</html>