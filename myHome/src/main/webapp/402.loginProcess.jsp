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
	//관리자 계정 : manager
	if(id.equals("manager")){
		if(id.equals(pwd)){//관리자로 로그인 성공
			session.setAttribute("MANAGER", id);
			result = "OK";
		}
	}else if(id.equals(pwd)){//일반 사용자로 로그인 성공
		result = "OK";	
		//세션객체에 계정을 저장한다.
		session.setAttribute("LOGINID", id);
	}else{//로그인 실패
		result = "NOK";
	}
	//로그인 결과(loginResult.jsp)로 전환
	//1.Redirect 2.Forward 3.both OK ->답:1(로그인 한번 할 때 DB처리하고 끝나야됨)
	response.sendRedirect("template.jsp?BODY=403.loginResult.jsp?R="+result);
%>
</body>
</html>