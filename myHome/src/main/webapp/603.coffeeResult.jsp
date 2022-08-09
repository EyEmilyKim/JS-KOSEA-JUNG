<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>coffeeResult</title>
</head>
<body>
<div align="center">
<font color="red" size="5">
총 액 : <fmt:formatNumber value="${param.TOTAL }" groupingUsed="true"/> 원
</font>
</div>
</body>
</html>