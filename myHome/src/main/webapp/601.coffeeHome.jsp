<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>coffeeHome</title>
</head>
<body>

<c:if test="${empty sessionScope.LOGINID && empty sessionScope.MANAGER }">
	<script type="text/javascript">
	location.href="template.jsp?BODY=401.login.jsp?M=Y";
	</script>
</c:if>

<div align="center">
<h2>커피 주문 App</h2>
<p>원하시는 커피를 선택하고 주문 버튼을 누르세요. </p>
<form action="coffeeOrder.do">
아메리카노 <input type="radio" name="NAME" value="A"/>, 
카푸치노 <input type="radio" name="NAME" value="B"/>, 
카페모카 <input type="radio" name="NAME" value="C"/>, 
카페라떼 <input type="radio" name="NAME" value="D"/><br/><br/>
수량 선택 <select name="NUM">

<c:forEach begin="1" end="10" var="cnt">
	<option>${cnt }</option>
</c:forEach>
<%-- <%
	for(int i=0; i<11; i++){
		out.print("<option>"+i+"</option>");
	}
%> --%> 
</select><br/><br/>
<input type="submit" value="주문하기"/>
<input type="reset" value="초기화"/>
</form>
</div>
</body>
</html>