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
	<c:when test="${param.R == 'true' }">
		<script type="text/javascript">
			alert("공지글이 삭제되었습니다.");
		</script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
	alert("공지글이 삭제되지 않았습니다. 관리자에게 문의하세요.");
		</script>
	</c:otherwise>
</c:choose>
<script type="text/javascript">
	location.href="noticeList.do";//공지글 목록으로 전환
</script>
</body>
</html>









