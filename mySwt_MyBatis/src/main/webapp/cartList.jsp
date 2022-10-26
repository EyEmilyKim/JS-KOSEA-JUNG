<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" 
	prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
#num { width : 50px; }
</style>
</head>
<body>
<div align="center">
	<h2>��ٱ��� ���</h2>
<c:if test="${CARTLIST == null }">
	<h3>��ٱ��ϰ� ������ϴ�.</h3>
</c:if>
<c:if test="${CARTLIST != null }">
	<table>
	<tr><th>��ǰ��ȣ</th><th>��ǰ�̸�</th><th>�� ��</th>
		<th>��ǰ����</th>
		<th>�� ��</th><th>����/����</th></tr>
	<c:forEach items="${CARTLIST }" var="item">
	<form action="cartModify.do" method="post">
	<input type="hidden" name="CODE" value="${item.code }"/>
	<tr><td>${item.code }</td><td>${item.name }</td>
		<td><fmt:formatNumber groupingUsed="true">${item.price }</fmt:formatNumber></td>
		<td><input type="number" name="NUM" min="0" 
			value="${item.num }" id="num"/></td>
		<td><fmt:formatNumber groupingUsed="true">${item.sum }</fmt:formatNumber></td><td>
			<input type="submit" value="����" name="BTN"/>
			<input type="submit" value="����" name="BTN"/></td></tr>		
	</form>
	</c:forEach>
	</table><br/>
	<form action="">
	�� �� : <fmt:formatNumber groupingUsed="true">
			${TOTAL }</fmt:formatNumber>�� <input type="submit" value="�����ϱ�"/>
	</form>
</c:if>
</div>
</body>
</html>









