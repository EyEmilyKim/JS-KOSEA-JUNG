<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>205.logout</title>
</head>
<body>
<%
session.invalidate();
out.print("로그아웃 되었습니다~<br/>");
out.print("또 방문해주세요~<br/>");
%>
</body>
</html>