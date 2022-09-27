<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>bbsList</title>
</head>
<body>
<div align="center">
<h2>게시글 목록</h2>
<table border="1">
	<tr><th>글번호</th><th>작성자</th><th>제 목</th>
		<th>작성일</th></tr>
<c:forEach items="${requestScope.LIST }" var="bbs">
	<tr><td>${bbs.seqno }</td><td>${bbs.id }</td>
		<td><a href="bbsDetail.do?SEQ=${bbs.seqno }">${bbs.title }</a></td>
		<!-- 제목 클릭해 이동한 페이지에서 글번호를 사용해 select 실행 => servlet! -->
		<td>${bbs.reg_date }</td></tr>
</c:forEach>
</table>
</div>
</body>
</html>










