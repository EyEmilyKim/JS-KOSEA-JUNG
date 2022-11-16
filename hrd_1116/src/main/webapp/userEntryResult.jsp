<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String result = request.getParameter("R");
	if(result.equals("true")){
%> 
<script type="text/javascript">
	alert("회원등록이 완료 되었습니다!");
	location.href="index.jsp";
</script>
<%	
	}else {
%>		
<script type="text/javascript">
	alert("회원등록이 완료 되지 않았습니다.\n관리자에게 문의하세요.");
	location.href="index.jsp";
</script>
<%	
	}
%>

</body>
</html>