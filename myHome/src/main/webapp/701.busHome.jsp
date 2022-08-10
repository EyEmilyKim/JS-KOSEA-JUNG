<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>busHome</title>
</head>
<body>
<div align="center">
<h2>고속 버스 예매 홈</h2>
<h3>목 적 지</h3>
<!-- 로그인 검사 (700.busMake.jsp에 JAVA로 로그인 검사 추가 -> template.jsp 에서의 path 주의! )
<c:if test="${empty sessionScope.LOGINID && empty sessionScope.MANAGER }">
	<script type="text/javascript">
	location.href="template.jsp?BODY=401.login.jsp?M=Y";
	</script>
</c:if> -->

<!-- forEach begin/end 방식 -->
<table border="1">
	<tr><th>행 선 지</th><th>요 금</th>
		<th>인 원 수</th><th>좌석 종류</th><th>선 택</th></tr>
<c:forEach begin="0" end="${requestScope.LENGTH - 1}" var="i">
	<form action="busProcess.do" >
	<input type="hidden" name="DESTINATION" value="${requestScope.DESTI[i] }"/>
	<input type="hidden" name="PRICE" value="${requestScope.PRICE[i] }"/>
	<tr><td>${requestScope.DESTI[i] }</td>
		<td>${requestScope.PRICE[i] }</td>
		<td><select name="NUM">
	<c:forEach begin="1" end="10" var="cnt">
		<option>${cnt}</option>
	</c:forEach>
		</select></td>
		<td>일반<input type="radio" name="SEAT" value="1"/> 
			우등<input type="radio" name="SEAT" value="2"/></td>
		<td><input type="submit" value="선 택"/></td></tr>
	</form>
</c:forEach>
</table><br/><br/>

<%-- forEach items 방식		
<c:forEach items="${requestScope.DESTINATIONS}" var="destinations" varStatus="c">
	<form action="702.busProcess.jsp" >
	<input type="hidden" name="DESTINATION" value="${destinations }"/>
	<input type="hidden" name="PRICE" value="${requestScope.PRICE[c.index] }"/>
	<tr><td>${destinations }</td>
		<td>${requestScope.PRICE[c.index] }</td>
		<td><select name="NUM">
	<c:forEach begin="1" end="10" var="cnt">
		<option>${cnt}</option>
	</c:forEach>
		</select></td>
		<td>일반<input type="radio" name="SEAT" value="1"/> 
			우등<input type="radio" name="SEAT" value="2"/></td>
		<td><input type="submit" value="선 택"/></td></tr>
	</form>
</c:forEach>
</table><br/><br/> --%>

<%-- <%
	for(int i=0; i<target.length; i++){
		
%>
	<form action="makePayment.jsp">
	<input type="hidden" name="TARGET" value="<%= target[i] %>"/>
	<input type="hidden" name="PRICE" value="<%= price[i] %>"/>
	<tr><td><%= target[i] %></td><td><%= price[i] %></td>
		<td><select name="NUM">
<%
	for(int j=1; j<11; j++){
		out.print("<option>"+j+"</option>");
	}
%>
		</select></td>
		<td>일반<input type="radio" name="SEAT" value="1"/> 
			우등<input type="radio" name="SEAT" value="2"/></td>
		<td><input type="submit" value="선 택"/></td></tr>
	</form>
<%	
	}
%>
</table><br/><br/> --%>

</div>
</body>
</html>