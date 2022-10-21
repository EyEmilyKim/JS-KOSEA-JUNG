<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>imageUpdateResult.jsp</title>
</head>
<body>
<c:if test="${! empty param.id }">
	<script type="text/javascript">
		alert("수정되지 않았습니다. 암호를 확인하세요.");
		location.href="imageRead.do?pid="+${param.id}; //상세보기로 돌아간다.
	</script>
</c:if>
<c:if test="${! empty param.seqno }">
	<script type="text/javascript">
		alert("수정되었습니다.");
		location.href="imageList.do"; //목록으로 돌아간다.
	</script>
</c:if>
</body>
</html>