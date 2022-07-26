<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>study1</title>
</head>
<body>
<%
	int i = 100; //자바에서 변수 선언
	int j =200;
	out.print("자바 i : "+i+"<br/>"); //자바에서 브라우저 출력
	out.print("자바 i+j= "+(i+j)+"<br/>"); //자바에서 브라우저 출력
%>
<c:set var="i" value="100"/>
<c:set var="j" value="200"/>
JSTL 변수 : ${i }<br/>
JSTL i+j = ${i+j }<br/>
<c:remove var="i"/>
<c:remove var="j"/>
JSTL 변수 : ${i }<br/>
JSTL i+j = ${i+j }<br/>
<c:forEach begin="1" end="10">
	<div>Hello world</div>
</c:forEach>
<c:forEach begin="1" end="10" step="2">
	<div>내일 뭐 먹지~?</div>
</c:forEach>
<c:forEach begin="1" end="10" var="cnt">
	<font color="red" size="5">${cnt }</font>
</c:forEach>
</body>
</html>