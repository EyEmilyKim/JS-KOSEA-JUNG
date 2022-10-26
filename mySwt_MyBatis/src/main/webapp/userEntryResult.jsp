<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${param.R == 'Y' }">
		<script type="text/javascript">
			alert("축하합니다~ 가입되었습니다~");
		</script>
	</c:when>
	<c:when test="${param.R == 'N' }">
		<script type="text/javascript">
			alert("가입되지 않았습니다. 관리자에게 문의하세요.");
		</script>
	</c:when>
</c:choose>
<script type="text/javascript">
	location.href="template.jsp";//첫화면으로 전환
</script>
</body>
</html>









