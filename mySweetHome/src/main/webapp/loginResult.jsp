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
<c:set var="id" value="${sessionScope.LOGINID }"/>
<c:set var="man" value="${sessionScope.MANAGER }"/>
<c:choose>
	<c:when test="${param.R =='OK'}">
		로그인 되었습니다.<br/>
			<c:choose>
				<c:when test="${! empty man }">환영합니다~ ${man }님~~~</c:when>
				<c:when test="${id != null }">환영합니다~ ${id }님~~~</c:when>
			</c:choose>	
	</c:when>
	<c:otherwise>
		로그인에 실패했습니다.<br/>
		계정과 암호를 확인하세요.
	</c:otherwise>
</c:choose>
</div>
</body>
</html>