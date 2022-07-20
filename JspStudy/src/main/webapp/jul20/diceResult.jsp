<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>diceResult.jsp</title>
</head>
<body>
<%
String result = request.getParameter("R");
String com = request.getParameter("COM");
String gamer = request.getParameter("GAMER");
out.println("컴퓨터 눈금 : "+com+" vs 게이머 눈금 : "+gamer+"<br/>");
if(result.equals("C")){
	out.println("<strong>컴퓨터 승..</strong>");
}else if(result.equals("G")){
	out.println("<strong>게이머 승!</strong>");
}else {
	out.println("<strong>무승부~~</strong>");
}
%>
</body>
</html>