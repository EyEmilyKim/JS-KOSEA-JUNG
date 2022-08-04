<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>study_jstl2</title>
</head>
<body>
<c:set var="today" value="<%= new Date() %>"/>
<h2>대한민국의 포맷</h2>
<fmt:setLocale value="ko_KR"/>
금액 : <fmt:formatNumber value="3980000" type="currency"/><br/>
날짜 : <fmt:formatDate value="${today }" type="both" dateStyle="full" timeStyle="full" /><br/>

<h2>일본의 포맷</h2>
<fmt:setLocale value="ja_JP"/>
금액 : <fmt:formatNumber value="3980000" type="currency"/><br/>
날짜 : <fmt:formatDate value="${today }" type="both" dateStyle="full" timeStyle="full" /><br/>

<h2>미국의 포맷</h2>
<fmt:setLocale value="en_US"/>
금액 : <fmt:formatNumber value="3980000" type="currency"/><br/>
날짜 : <fmt:formatDate value="${today }" type="both" dateStyle="full" timeStyle="full" /><br/> 
<br/>

<h2>시간대 변경</h2>
<%
	//TimeZone : 지역이름과 도시이름이 들어있는 배열 객체
	String[] zone = TimeZone.getAvailableIDs();
	//TimeZone 객체 목록으로 조회
	for(int i=0; i<zone.length; i++){
		out.print(zone[i]+"<br/>");
	}
%>
<br/>
서울 : <fmt:formatDate value="${today }" type="both"/><br/>
<fmt:timeZone value="Asia/Hong_Kong">
홍콩 : <fmt:formatDate value="${today }" type="both"/><br/>
</fmt:timeZone>
<fmt:timeZone value="Europe/London">
런던 : <fmt:formatDate value="${today }" type="both"/><br/>
</fmt:timeZone>
<fmt:timeZone value="America/New_York">
뉴욕 : <fmt:formatDate value="${today }" type="both"/><br/>
</fmt:timeZone>
<fmt:timeZone value="Australia/Sydney">
시드니 : <fmt:formatDate value="${today }" type="both"/><br/>
</fmt:timeZone>
<fmt:timeZone value="Africa/Johannesburg">
요하네스버그 : <fmt:formatDate value="${today }" type="both"/><br/>
</fmt:timeZone>

<br/>
<fmt:setTimeZone value="Europe/Moscow"/>
모스크바 : <fmt:formatDate value="${today }" type="both"/><br/>
 
</body>
</html>