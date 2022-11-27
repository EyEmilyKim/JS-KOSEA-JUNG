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
	String flag = request.getParameter("R");
	if(flag.equals("OK")){
%> 
<script type="text/javascript">
	alert("사용이 가능한 영화번호입니다");
	opener.document.getElementById("dupId").value = "OK";
</script>
<% 		
	}else{
%> 
<script type="text/javascript">
	alert("이미 사용된 영화번호입니다. 다시 입력해주세요.");
	opener.document.getElementById("dupId").value = "NOK";
</script>
<% 			
	}
%>
</body>
<script type="text/javascript">
	self.close();
</script>
</html>