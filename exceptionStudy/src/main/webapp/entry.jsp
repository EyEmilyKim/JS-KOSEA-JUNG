<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>entry</title>
</head>
<body>
<header>
	<h2 align="center">게시글 작성</h2>
</header>
<section>
<div align="center">
<form action="entry.do" method="post" onsubmit="return check(this)">
	<table border="1">
		<tr><th>글번호</th><td><input type="text" name="ID"/></td></tr>
		<tr><th>제 목</th><td><input type="text" name="TITLE"/></td></tr>
		<tr><th>작성자</th><td><input type="text" name="WRITER"/></td></tr>
		<tr><th>내 용</th><td><textarea rows="5" cols="40" name="CONTENT"></textarea></td></tr>
		<tr><td colspan="2" align="center">
			<input type="submit" value="글 올리기"/>
			<input type="reset" value="취 소"/></td></tr>
	</table>
</form>
</div>
</section>
<footer>
	<h3 align="center">Copyright 2022.</h3>
</footer>
<script type="text/javascript">
function check(fm){
	if(fm.ID.value == ''){
		alert("글번호를 입력하세요."); return false;
	}else {
		if(isNaN(fm.ID.value)){
			alert("글번호는 숫자로 입력하세요."); return false;
		}
	}//글번호 검사
	if(fm.TITLE.value == ''){
		alert("글제목을 입력하세요."); return false;
	}else {
		if(fm.TITLE.value.length > 30){
			alert("글제목은 30글자 이내로 작성하세요."); return false;
		}
	}//글 제목 검사
	if(fm.WRITER.value == ''){
		alert("작성자를 입력하세요."); return false;
	}else {
		if(fm.WRITER.value.length > 15){
			alert("작성자는 15글자 이내로 작성하세요."); return false;
		}
	}//작성자 검사
	if(fm.CONTENT.value == ''){
		alert("글 내용을 입력하세요."); return false;
	}else {
		if(fm.CONTENT.value.length > 100){
			alert("글 내용은 100글자 이내로 작성하세요."); return false;
		}
	}//글 내용 검사
	if( ! confirm("정말로 등록하시겠습니까?")) return false;
}
</script>
</body>
</html>