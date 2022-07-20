<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bbsResult.jsp</title>
</head>
<body>
<%
String count = request.getParameter("COUNT");
out.print("게시글의 개수 : "+count+"<br/>");
out.print("게시글의 목록이 출력됩니다.");
%>
</body>
</html>