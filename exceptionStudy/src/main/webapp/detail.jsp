<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail</title>
</head>
<body>
<header>
	<h2 align="center">게시판 관리 시스템</h2>
</header>
<menu>
	<%@ include file="menu_file.jsp" %>
</menu>
<section>
	<div align="center">
		<h2 align="center">게시글 상세</h2>
		<form action="bbsModify.do" method="post" onSubmit="return check()">
		<table border="1">
		<tr><th>글번호</th>
			<td><input type="text" name="NO" value="${BBS.seqno }" readOnly="readOnly"/></td></tr>
		<tr><th>글제목</th>
			<td><input type="text" name="TITLE" value="${BBS.title }"/></td></tr>
		<tr><th>작성자</th>
			<td><input type="text" name="ID" value="${BBS.id }"/></td></tr>
		<tr><th>작성일</th>
			<td><input type="text" name="DATE" value="${BBS.reg_date }"/></td></tr>
		<tr><th>내 용</th>
			<td><textarea rows="4" cols="50" name="CONTENT">${BBS.content }</textarea></td></tr>
		<tr><td colspan="2" align="center">
			<input type="submit" value="삭제" name="BTN"/>		
			<input type="submit" value="수정" name="BTN"/></td></tr>		
		</table></form>
	</div>
</section>
<script type="text/javascript">
function check(){
	if(! confirm("작업을 진행하시겠습니까?")) return false;
}
</script>
<footer>
	<h3 align="center">Copyright 2022.</h3>
</footer>
</body>
</html>