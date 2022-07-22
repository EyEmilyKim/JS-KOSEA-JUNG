<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>study1result</title>
</head>
<body>
<%
 	String s = request.getParameter("S");
	String u = request.getParameter("U");
	String m = request.getParameter("M"); 
	String d = request.getParameter("D");
%>
<p>
덧셈의 결과 : <%=s %>, 뺄셈의 결과 : <%=u %>, 곱셈의 결과 : <%=m %>, 나눗셈의 결과 : <%=d %>
</p>
</body>
</html>