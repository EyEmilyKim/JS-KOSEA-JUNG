<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>801.showRegion</title>
</head>
<body>
<div align="center">
<h2>지역을 선택합니다.</h2>
<c:set var="zone" value="${requestScope.ZONE }" />
<form action="makeDate.do">
원하시는 지역을 선택하고, 버튼을 누르시면 해당 지역의 날짜와 시간을 볼 수 있습니다.<br/>
지역 선택 : <select name="AREA">
	<c:forEach items="${zone }" var="name">
		<option>${name }</option>
	</c:forEach>	
</select><br/><br/>
<input type="submit" value="확인"/>
<input type="reset" value="취소"/>
</form>
</div>	
</body>
</html>