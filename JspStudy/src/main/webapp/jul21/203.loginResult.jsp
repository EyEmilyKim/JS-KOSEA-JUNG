<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>203.loginResult</title>
</head>
<body>
<%
String result = request.getParameter("R");
if(result.equals("OK")){
	out.print("로그인 되었습니다~!!");
}else {
	out.print("로그인에 실패했습니다...");
}
%>
</body>
</html>