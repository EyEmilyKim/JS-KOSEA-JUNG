<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>study3</title>
</head>
<body>
<h2>구구단</h2>
<c:forEach begin="1" end="9" var="dan">
**** ${dan}단 ****<br/>
	<c:forEach begin="1" end="9" var="su">
		${dan} * ${su} = ${dan*su}<br/>
	</c:forEach>
</c:forEach>
</body>
</html>