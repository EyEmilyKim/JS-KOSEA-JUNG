<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>second.jsp</title>
</head>
<body>
<%
////////////third.jsp로 전환
/* 
페이지 전환 방법 2가지 : Redirect, Forward
1. Redirect 
--->response객체를 사용 (내장 객체)
 */

// response.sendRedirect("third.jsp");

/* 
2. Forward 
--->requestDispatcher객체를 사용 (사용자가 등록해줘야 하는 객체)
 */

RequestDispatcher rd = request.getRequestDispatcher("third.jsp"); 
rd.forward(request, response);
%>
</body>
</html>