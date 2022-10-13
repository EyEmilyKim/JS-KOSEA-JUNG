<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cartList.jsp</title>
	<style type="text/css">
		.why {color: skyblue; }
	</style>
</head>
<body>
<div align="center">
	<h2>장바구니 목록</h2>
	<c:if test="${CARTLIST == null }">
		<h3>장바구니가 비어있습니다.</h3>
	</c:if>
	<c:if test="${CARTLIST != null }">
		<table>
			<tr><th>상품번호</th><th>상품이름</th><th>가 격</th>
				<th>수 량</th><th>합 계</th><th>수정/삭제</th></tr>
			<c:forEach items="${CARTLIST }" var="item">
			<tr><td>${item.code }</td><td>${item.name }</td><td>${item.price }</td>
				<td>수 량</td><td> 합 계</td>
				<td><input type="submit" value="수정"/>
					<input type="submit" value="삭제"/></td></tr>
			</c:forEach>	
		</table>
	</c:if>
</div>
</body>
</html>