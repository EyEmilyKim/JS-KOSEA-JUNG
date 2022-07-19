<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>makeTotal.jsp</title>
</head>
<body>
<%
String price = request.getParameter("PRICE");
String num = request.getParameter("NUM");
int priceInt = Integer.parseInt(price);
int numInt = Integer.parseInt(num);
int total = priceInt * numInt;
%>
<div align="center">
총 액 : <%= total %>원 입니다.
</div>
</body>
</html>