<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>logoutProcess</title>
</head>
<body>
<%
	//세션을 비활성화 한다
	session.invalidate();
	//로그아웃 메시지 화면으로 전환
	response.sendRedirect("template.jsp?BODY=406.logoutResult.jsp");
%>
</body>
</html>