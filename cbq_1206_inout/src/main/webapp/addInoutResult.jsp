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
		alert("입출고 정보가 정상적으로 등록 되었습니다!");
	</script>
<%
	}else{
%>
	<script type="text/javascript">
		alert("입출고 정보 등록에 실패했습니다! 관리자에게 문의해주세요.");
	</script>
<%
	}
%>
<script type="text/javascript">
	location.href = "index.jsp";
</script>
</body>
</html>