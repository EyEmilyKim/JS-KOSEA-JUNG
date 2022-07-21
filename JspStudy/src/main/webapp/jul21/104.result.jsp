<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>104.result.jsp</title>
</head>
<body>
<h2>회원 가입 결과</h2>
<%
String result = request.getParameter("RE");
if(result.equals("SUCCESS")){
	out.print("축하합니다! 회원 가입에 성공했습니다");
}else {
	out.print("회원 가입에 실패했습니다.");
}
%>
</body>
</html>