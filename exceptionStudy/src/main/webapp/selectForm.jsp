<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectForm</title>
</head>
<body>
<header>
	<h2 align="center">게시글 검색</h2>
</header>
<section>
<div align="center">
	<form action="getBBS.do" method="post">
	<table border="1">
		<tr><th>글번호</th><td><input type="text" name="ID" size="3"/></td></tr>
		<tr><th>제 목</th><td><input type="text" name="TITLE" size="20"/></td></tr>
		<tr><th>작성자</th><td><input type="text" name="WRITER" size="20"/></td></tr>
		<tr><th>작성일</th><td><input type="date" name="DATE"/></td></tr>
		<tr><td colspan="2" align="center">
			<input type="submit" value="검 색"/>
			<input type="reset" value="취 소"/></td></tr>
	</table>
	</form>
</div>
</section>
<footer>
	<h3 align="center">Copyright 2022.</h3>
</footer>
</body>
</html>