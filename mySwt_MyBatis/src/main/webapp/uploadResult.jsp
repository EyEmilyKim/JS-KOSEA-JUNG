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
<c:if test="${param.R == 'Y' }">
	<script type="text/javascript">
		alert("이미지 게시글이 등록되었습니다.");
	</script>
</c:if>
<c:if test="${param.R == 'N' }">
	<script type="text/javascript">
		alert("이미지 게시글이 등록되지 않았습니다.");
	</script>
</c:if>
<script type="text/javascript">
	location.href = "template.jsp";
</script>
</body>
</html>









