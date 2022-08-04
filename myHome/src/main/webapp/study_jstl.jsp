<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>study_jstl</title>
</head>
<body>
상품가격 : <fmt:formatNumber value="1000000" groupingUsed="true"/>원<br/>
<br/>

첫번째 수 : <fmt:formatNumber value="3.141592" pattern="#.##"/><br/>
두번째 수 : <fmt:formatNumber value="10.53" pattern="#.00"/><br/>
세번째 수 : <fmt:formatNumber value="0.5" type="percent"/><br/>
네번째 수 : <fmt:formatNumber value="3300000" type="currency"/><br/>
화폐단위 추가 : <fmt:formatNumber value="3300000" type="currency" currencySymbol="￦"/><br/>
<br/>

<c:set var="today" value="<%= new Date() %>"/>
[1] <fmt:formatDate value="${today }"/><br/>
[2] <fmt:formatDate value="${today }" type="time"/><br/>
[3] <fmt:formatDate value="${today }" type="date"/><br/>
[4] <fmt:formatDate value="${today }" type="both" 
			dateStyle="short" timeStyle="short"/><br/>
[5] <fmt:formatDate value="${today }" type="both" 
			dateStyle="medium" timeStyle="medium"/><br/>
[6] <fmt:formatDate value="${today }" type="both" 
			dateStyle="long" timeStyle="long"/><br/>
[7] <fmt:formatDate value="${today }" type="both" 
			dateStyle="full" timeStyle="full"/><br/>
</body>
</html>