<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginProcess</title>
</head>
<body>
<%
	String id = request.getParameter("ID");
	String pwd = request.getParameter("PWD");
	String result = "";
	if(id.equals(pwd)){//로그인 성공
		result = "OK";	
	}else{//로그인 실패
		result = "NOK";
	}
	//로그인 결과(loginResult.jsp)로 전환
	//1.Redirect 2.Forward 3.both OK ->답:1(로그인 한번 할 때 DB처리하고 끝나야됨)
	response.sendRedirect("template.jsp?BODY=403.loginResult.jsp?R="+result);
%>
</body>
</html>