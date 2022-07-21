<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>402.penaltyLoginPro</title>
</head>
<body>
<%
String id = request.getParameter("ID");
String pwd = request.getParameter("PWD");
if(id.equals(pwd)){
	session.setAttribute("LOGIN", id);
%>
	<script type="text/javascript">
	alert("로그인 되었습니다");
	location.href = "403.penaltyHome.jsp";
	</script>
<%
}else{
%>	
	<script type="text/javascript">
	alert("로그인 되지 않았습니다");
	location.href = "401.penaltyLogin.jsp";
	</script>
<%
}
%>	
</body>
</html>