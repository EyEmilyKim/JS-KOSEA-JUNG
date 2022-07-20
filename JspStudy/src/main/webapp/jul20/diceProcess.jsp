<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>diceProcess.jsp</title>
</head>
<body>
<%
int com = (int)(Math.random()*6+1);
int gamer = (int)(Math.random()*6+1);
String result = "";
if(com>gamer){
	result = "C";
}else if(gamer > com){
	result = "G";
}else{
	result = "D";
}
//1.Redirect
response.sendRedirect("diceResult.jsp?R="+result+"&COM="+com+"&GAMER="+gamer);
//2.Forward
// RequestDispatcher rd = request.getRequestDispatcher("diceResult.jsp?R="+result+"&COM="+com+"&GAMER="+gamer);
// rd.forward(request, response);
%>
</body>
</html>