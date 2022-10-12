<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>itemDeleteResult.jsp</title>
</head>
<body>
<c:if test="${param.R == 'Y' }">
	<script type="text/javascript">
		alert("해당 상품이 삭제되었습니다.");
	</script>
</c:if>
<c:if test="${param.R == 'N' }">
	<script type="text/javascript">
		alert("해당 상품이 삭제되지 않았습니다. 관리자에게 문의하세요");
	</script>
</c:if>
</body>
<script type="text/javascript">
	location.href="itemList.do";
</script>
</html>