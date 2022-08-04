<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>803.showDate.jsp</title>
</head>
<body>
<div align="center">
<h2>현 재 시 간</h2>
<c:set var="area" value="${requestScope.AREA }"/>
${area }<br/>
<fmt:setTimeZone value="${area }"/>
<fmt:formatDate value="${requestScope.TODAY }" type="both" dateStyle="long" timeStyle="long"/>
</div>
</body>
</html>