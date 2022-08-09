<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1003.ticketResult.jsp</title>
<style type="text/css">
tr { text-align:center; }
.red { color:red; }
</style>
</head>
<body>
<div align="center">
<h2>결 제 화 면</h2>
<p>결제 내용은 아래와 같습니다</p>
<table>
<tr><td>구분</td>
	<td>${requestScope.AGE }</td></tr>
<tr><td>매수</td>
	<td>${requestScope.NUM } 매</td></tr>
<tr><td class="red">총 결제액</td>
	<td class="red"><fmt:formatNumber>${requestScope.TOTAL }</fmt:formatNumber> 원</td></tr>
</table>
<p>이용해 주셔서 감사합니다.</p>
</div>
</body>
</html>