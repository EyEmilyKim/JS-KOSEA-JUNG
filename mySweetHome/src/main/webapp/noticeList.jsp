<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeList.jsp</title>
</head>
<body>
<div align="center">
<h2>공지사항 목록</h2>
	<table width="100%">
		<tr><td align="right">${STARTR} ~ ${ENDR} / ${TOTAL }</td>
	</table>
	<table width="100%">
		<tr><th>번 호</th><th>제 목</th><th>작성자</th>
			<th>작성일</th></tr>
	<c:forEach items="${LIST }" var = "n">
		<tr><td>${n.seqno }</td>
			<td><a href="noticeDetail.do?SEQ=${n.seqno }">${n.title }</a></td>
			<td>${n.writer }</td><td>${n.reg_date }</td></tr>
	</c:forEach>	
	</table>
	<c:forEach begin="1" end="${PAGES }" var="page">
		<a href="noticeList.do?PAGE=${page }">${page }</a>
	</c:forEach>
</div>
</body>
</html>