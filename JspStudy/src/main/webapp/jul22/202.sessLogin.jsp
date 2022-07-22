<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>202.sessLogin</title>
</head>
<body>
<%
String id = request.getParameter("ID");
String pwd = request.getParameter("PWD");
String result = null;
//여기서는 id 와 pwd 가 같을 때 로그인 성공으로 가정
if(id.equals(pwd)){
	session.setAttribute("MEMBER", id);//세션에 계정을 저장
// 	session.setMaxInactiveInterval(30);//자동 로그아웃(30초 동안 상태유지)
	result = "OK";
}else {
	result = "NOK";
}
// response.sendRedirect("203.loginResult.jsp?R="+result);
response.sendRedirect("2.index.jsp?BODY=203.loginResult.jsp?R="+result);
%>
</body>
</html>