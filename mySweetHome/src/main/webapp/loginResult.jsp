<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginResult</title>
</head>
<body>
<div align="center">
<c:choose>
	<c:when test="${param.R == 'NOID'}">
		<h3>계정이 존재하지 않습니다.</h3>
	</c:when>
	<c:when test="${param.R == 'NOPWD'}">
		<h3>암호가 일치하지 않습니다.</h3>
	</c:when>
	<c:otherwise>
		<h3>로그인 되었습니다.</h3>
		<h3>환영합니다~ ${param.ID }님~</h3>
	</c:otherwise>
</c:choose>

</div>
</body>
</html>