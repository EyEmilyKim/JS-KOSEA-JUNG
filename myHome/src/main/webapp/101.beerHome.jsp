<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>beerHome</title>
</head>
<body>
<!-- 세션 로그인 확인 -->
<c:if test="${empty sessionScope.LOGINID }">
	<script type="text/javascript">
		location.href="template.jsp?BODY=401.login.jsp?M=Y";
	</script>
</c:if>
<!-- 맥주추천 홈 -->
<div align="center">
<h2>맥주 추천 홈</h2>
<form action="102.beerSelect.jsp">
<p>원하시는 색을 선택하세요. </p>
<select name="COLOR">
	<option value="L">밝은색</option>
	<option value="D">어두운색</option>
	<option value="Y">노란색</option>
	<option value="B">갈색</option>
</select><br/><br/>
<input type="submit" value="맥주 찾기"/>
<input type="reset" value="취 소"/>
</form>
</div>
</body>
</html>