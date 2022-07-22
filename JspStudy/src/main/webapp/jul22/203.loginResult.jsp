<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>203.loginResult</title>
</head>
<body>
<!-- <h3 align="center">로그인 결과</h3> -->
<%-- <%@ include file="101.menu_header.jsp" %> --%>
<%
String result = request.getParameter("R");
if(result.equals("OK")){
// 	out.print("로그인 되었습니다~!!");
	String id = (String)session.getAttribute("MEMBER");
%>
	<form action="206.logoutIndex.jsp">
	환영합니다~ <%=id %>님~
	<input type="submit" value="로그아웃"/>
	</form>
<%
}else {
	out.print("로그인에 실패했습니다...");
}
%>
</body>
</html>