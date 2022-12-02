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
	String rslt = request.getParameter("R");
	if(rslt.equals("OK")){
%>
<script type="text/javascript">
	alert("도서대출정보가 등록되었습니다!");
</script>
<%		
	}else{
%>
<script type="text/javascript">
	alert("도서대출정보가 등록되지 않았습니다. 관리자에게 문의해주세요");
</script>
<%
	}
%>
</body>
<script type="text/javascript">
location.href = "listReserv.do";
</script>
</html>