<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>makePayment.jsp</title>
</head>
<body>
<%
String target = request.getParameter("TARGET");
String price = request.getParameter("PRICE");
out.print("목적지 : "+target+"<br/> ");
out.print("운임 : "+price+"<br/>  ");
%>
</body>
</html>