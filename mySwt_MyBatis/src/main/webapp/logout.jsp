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
<form action="logout.do">
환영합니다~ 
	<c:if test="${sessionScope.USERID != null }">
		${sessionScope.USERID}님~<br/>
	</c:if>
	<c:if test="${sessionScope.MANAGER != null }">
		${sessionScope.MANAGER}님~<br/>
	</c:if>	
	<input type="submit" value="로그 아웃"/>
</form>
</body>
</html>








