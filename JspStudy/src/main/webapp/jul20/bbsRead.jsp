<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bbsRead.jsp</title>
</head>
<body>
<%!
int count = 1;
%>
<%
String msg = "데이터베이스에서 고객이 올린 여러 게시글을 불러와서 세번째 페이지로 넘겨준다.";
count = count + 1;
System.out.println(msg+"_count:"+count);
//Redirect
// response.sendRedirect("bbsResult.jsp?COUNT="+count);
//Forward
RequestDispatcher rd = request.getRequestDispatcher("bbsResult.jsp?COUNT="+count);
rd.forward(request, response);
%>
</body>
</html>