<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>204.loginCheck</title>
</head>
<body>
<%
String id = (String)session.getAttribute("MEMBER");
if(id == null){
	out.print("로그인 되어있지 않습니다.");
}else{
	out.print(id+"님으로 로그인 한 상태입니다");
%>
	<form action="205.logout.jsp" method="post">
	<input type="submit" value="로그아웃"/>
	</form>
<%	
}
%>
</body>
</html>