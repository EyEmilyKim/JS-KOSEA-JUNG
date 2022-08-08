<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>802.makeDate</title>
</head>
<body>
<%
	String area = request.getParameter("AREA");
	Date today = new Date();
	//showDate.jsp로 전환 => Forward
	request.setAttribute("AREA", area);
	request.setAttribute("TODAY", today);
	RequestDispatcher r = request.getRequestDispatcher("template.jsp?BODY=803.showDate.jsp");
	r.forward(request, response);
%>

</body>
</html>