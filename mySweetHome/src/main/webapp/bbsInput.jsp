<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bbsInput</title>
</head>
<body>
<div align="center">
<h2>게시판 글쓰기</h2>
<form action="bbsPost.do" method="post" onSubmit="return check(this)">
	<table>
	<tr><th>제 목</th>
		<td><input type="text" name="TITLE" size="20" placeHolder="제목을 입력하세요."></td></tr>
	<tr><th>내 용</th>
		<td><textarea name="CONTENT" rows="6" cols="40"></textarea></td></tr>
	<tr><td colspan="2" align="center">
		<input type="submit" value="등록"/>
		<input type="reset" value="취소"/></td></tr>
	</table>
</form>
</div>
</body>
<script type="text/javascript">
function check(fm){
	if(fm.TITLE.value == ''){
		alert("제목을 입력하세요."); return false;
	}else{
		if(fm.TITLE.value.legth > 30){
			alert("30자 이내로 작성하세요"); return false;
		}
	}
	if(fm.CONTENT.value == ''){
		alert("내용을 입력하세요."); return false;
	}else{
		if(fm.CONTENT.value.length > 100){
			alert("100자 이내로 작성하세요."); return false;
		}
	}
	if(! confirm("정말로 올리시겠습니까?"))
		return false;
}
</script>
</html>