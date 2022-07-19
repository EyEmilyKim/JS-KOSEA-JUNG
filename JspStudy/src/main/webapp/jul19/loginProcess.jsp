<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginProcess.jsp</title>
</head>
<body>
<%
String id = request.getParameter("ID");
String pwd = request.getParameter("PWD");
//여기서는 id 와 pwd 가 일치하면 로그인 가능한 것으로 한다.
if(id.equals(pwd)){//계정과 암호가 같은 경우
	out.print("<font color='blue'>로그인 되었습니다!~~<br/>");
	out.print("환영합니다~"+id+"님~</font>");
}else{//계정과 암호가 다른 경우
	out.print("<font color='red'>로그인에 실패했습니다...<br/>");
	out.print("계정과 암호를 확인하세요</font>");
}
%>
</body>
</html>