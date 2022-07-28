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
	<c:when test="${param.R =='OK'}">
		로그인 되었습니다.<br/>
		XXX님~ 환영합니다.	
	</c:when>
	<c:otherwise>
		로그인에 실패했습니다.<br/>
		계정과 암호를 확인하세요.
	</c:otherwise>
</c:choose>
</div>
</body>
</html>