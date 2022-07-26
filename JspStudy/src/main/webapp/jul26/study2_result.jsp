<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>study2_result</title>
</head>
<body>
<h2>오늘의 메뉴</h2>
<!-- 배열 반복/목록 출력에 사용하는 forEach. -->
<c:forEach items="${requestScope.FOODS}" var="name"> 
	<font color="blue" size="5">${name}</font><br/>
</c:forEach>
</body>
</html>