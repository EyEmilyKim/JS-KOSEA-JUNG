<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>logout</title>
</head>
<body>
<form action="logout.do">
환영합니다~
<c:if test="${sessionScope.USERID != null }">${sessionScope.USERID}님~</c:if>
<c:if test="${sessionScope.MANAGER != null }">${sessionScope.MANAGER}님~</c:if>
<br/>
<input type="submit" value="로그아웃"/>
</form>
</body>
</html>