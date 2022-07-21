<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>305.coffeeLogout.jsp</title>
</head>
<body>
<%
	session.invalidate();//세션을 비활성화 한다.
	out.print("<h3>로그아웃 되셨습니다</h3>");
%>
<form action="301.coffeeLogin.jsp">
<input type="submit" value="홈으로"/>
</form>
</body>
</html>