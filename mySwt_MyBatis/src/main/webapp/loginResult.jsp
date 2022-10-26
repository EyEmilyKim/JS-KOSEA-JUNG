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
<div align="center">
<c:choose>
	<c:when test="${param.R == 'NOID' }">
		<h3 align="center">계정이 존재하지 않습니다.</h3>
	</c:when>
	<c:when test="${param.R == 'NOPWD' }">
		<h3 align="center">암호가 일치하지 않습니다.</h3>
	</c:when>
	<c:otherwise>
		<h3 align="center">로그인 되었습니다.</h3>
		<h3 align="center">환영합니다~ ${param.ID }님~</h3>
		<c:if test="${ ! empty param.CART  }">
			<script type="text/javascript">
				self.close();
				opener.window.location.reload();
			</script>
		</c:if>
	</c:otherwise>
</c:choose>
</div>
</body>
</html>





