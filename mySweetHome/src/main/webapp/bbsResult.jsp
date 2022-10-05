<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bbsResult</title>
</head>
<body>
<c:if test="${param.R == 'Y' }">
	<script type="text/javascript">
	alert("게시글이 등록되었습니다.");
	location.href="template.jsp";
	</script>
</c:if>
<c:if test="${param.R == 'N' }">
	<script type="text/javascript">
	alert("게시글이 등록되지 않았습니다. 관리자에게 문의하세요.");
	location.href="template.jsp";
	</script>
</c:if>

</body>
</html>