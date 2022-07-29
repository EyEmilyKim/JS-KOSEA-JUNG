<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>matjipHome</title>
</head>
<body>
<c:if test="${sessionScope.LOGINID == null }">
	<script type="text/javascript">
	location.href="template.jsp?BODY=401.login.jsp?M=Y";
	</script>
</c:if>
<div align="center">
<h2>맛집 홈에 오신 것을 환영합니다</h2>
<p>지역을 선택하고, 버튼을 누르면 맛집 목록을 볼 수 있습니다.</p>
<form action="502.matjipProcess.jsp">
지역 선택 : <select name="AREA">
<c:forEach items="${requestScope.AREA }" var="areas" >
	<option>${areas }</option>
</c:forEach>	
</select>
<input type="submit" value="확 인"/>
<input type="reset" value="취 소"/>
</form>
</div>
</body>
</html>