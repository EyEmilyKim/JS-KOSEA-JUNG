<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>beerResult.jsp</title>
</head>
<body>
<%
String beerName = request.getParameter("BN");
out.print("추천된 맥주 : "+beerName);
%>
</body>
</html>