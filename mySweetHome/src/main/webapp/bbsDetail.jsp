<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bbsDetail</title>
</head>
<body>
<div align="center">
<c:if test="${empty BBS }">
	<h3>존재하지 않는 게시글입니다.</h3>
</c:if>
<c:if test="${ ! empty BBS }">
	<h3>게시글 상세보기</h3>
	<table width="100%">
		<tr><th>글번호</th><td>${BBS.seqno }</td></tr>
		<tr><th>작성자</th><td>${BBS.writer }</td></tr>
		<tr><th>제 목</th><td>${BBS.title }</td></tr>
		<tr><th>작성일</th><td>${BBS.reg_date }</td></tr>
		<tr><th>내 용</th>
		<td><textarea rows="5" cols="40">${BBS.content }</textarea></td></tr>
	</table>
</c:if>
</div>
</body>
</html>