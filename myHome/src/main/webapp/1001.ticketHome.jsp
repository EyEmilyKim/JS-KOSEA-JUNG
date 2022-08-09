<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1001.ticketHome.jsp</title>
</head>
<body>
<!-- 세션 로그인 확인 -->
<c:if test="${empty sessionScope.LOGINID && empty sessionScope.MANAGER }">
	<script type="text/javascript">
		location.href="template.jsp?BODY=401.login.jsp?M=Y";
	</script>
</c:if>
<!-- 티켓예매 홈 -->
<div align="center">
<h2>티 켓 예 매</h2>
<p>연령대와 매수를 선택한 후 결제하기 버튼을 누르세요</p>
<form action="ticketProcess.do">
구 분 : <select name="AGE">
	<option value="청소년">청소년: 7000원/매</option>
	<option value="성인">성인: 10000원/매</option>
	<option value="노인">노인: 5000원/매</option>
</select>
매 수 : <select name="NUM">
	<c:forEach begin="1" end="10" var="cnt">
		<option>${cnt }</option>
	</c:forEach>
</select><br/><br/>
<input type="submit" value="결제하기">
<input type="reset" value="취소">
</form>
</div>
</body>
</html>