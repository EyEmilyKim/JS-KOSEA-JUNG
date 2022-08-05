<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>study_jstl4</title>
</head>
<body>
<c:set var="greeting" value="How Are You?"/>
<h2>JSTL의 함수 기능</h2>
원래의 문자열 : ${greeting }<br/>
모두 대문자로 : ${ fn:toUpperCase(greeting) }<br/>
모두 소문자로 : ${ fn:toLowerCase(greeting) }<br/>
Are의 위치는? : ${ fn:indexOf(greeting,"Are") }<br/>
Are를 Were로 : ${ fn:replace(greeting,"Are","Were")}<br/>
문자열의 길이 : ${ fn:length(greeting) }<br/>
</body>
</html>