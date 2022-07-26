<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>study4</title>
</head>
<body>
<h2>JSTL의 비교문</h2>
<c:set var="num1" value="100"/>
<c:set var="num2" value="200"/>
num1 : ${num1 } / num2 : ${num2 }<br/><br/>
<!-- 첫번째 비교문 : if -->
<c:if test="${num1 > num2 }">
첫번째 수(${num1})가 큽니다.<br/>
</c:if>
<c:if test="${num2 > num1 }">
두번째 수(${num2})가 큽니다.<br/>
<!-- 두번째 비교문 :choose --><br/>
<c:choose>
	<c:when test="${num1 > num2 }"> 첫번째 수가 큽니다.</c:when>
	<c:when test="${num1 < num2 }"> 두번째 수가 큽니다.</c:when>
	<c:otherwise>두 수의 값이 같습니다</c:otherwise>
</c:choose>
</c:if>
</body>
</html>