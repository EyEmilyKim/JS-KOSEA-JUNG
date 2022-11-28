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
	alert("등록 가능한 예매 정보입니다. 예매 등록을 진행해주세요.");
	opener.document.getElementById("dupBk").value = "OK";
	opener.document.getElementById("w_no").readonly="readonly";
	opener.document.getElementById("m_id").readonly="readonly"; 
	opener.document.getElementById("submitBtn").style.display = "block";
	opener.document.getElementById("resetBtn").style.display = "block";
	self.close();
</script>
<% 		
	}else{
%> 
<script type="text/javascript">
	alert("이미 등록된 예매 정보입니다. 다시 입력해주세요.");
	opener.document.getElementById("dupBk").value = "NOK";
	opener.document.getElementById("submitBtn").style.display = "none";
	self.close();
</script>
<% 			
	}
%>
</body>
</html>