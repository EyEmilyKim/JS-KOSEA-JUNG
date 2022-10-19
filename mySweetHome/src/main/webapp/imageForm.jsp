<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>imageForm.jsp</title>
</head>
<body>
<div align="center">
	<h2>이미지 게시글 작성</h2>
	<form action="imageWrite.do" method="post" encType="multipart/form-data"
	onSubmit="return check(this)">
	
	<table>
		<tr><th>제 목</th><td><input type="text" name="TITLE"/></td></tr>
		<tr><th>암 호</th><td><input type="password" name="PWD"/></td></tr>
		<tr><th>이미지</th><td><input type="file" name="IMAGENAME"/></td></tr>
		<tr><th>글내용</th><td><textarea rows="8" cols="40" name="CONTENT"></textarea></td></tr>
		<tr><td colspan="2" align="center">
			<input type="submit" value="글올리기"/>
			<input type="reset" value="취 소"/></td></tr>
	</table>
	
	</form>
</div>
</body>
<script type="text/javascript">
function check(fm){
	if(fm.TITLE.value == ''){
		alert("제목을 입력하세요."); return false;
	}else{
		if(fm.TITLE.value.length > 30){
			alert("제목은 30자 이내로 작성하세요."); return false;				
		}
	}
	if(fm.PWD.value == ''){
		alert("암호를 입력하세요."); return false;
	}
	if(fm.IMAGENAME.value == ''){
		alert("이미지 파일을 선택하세요."); return false;
	}
	if(fm.CONTENT.value == ''){
		alert("글 내용을 입력하세요."); return false;
	}else{
		if(fm.CONTENT.value.length > 100){
			alert("글 내용은 100자 이내로 작성하세요."); return false;				
		}
	}
	if( ! confirm("입력한 내용이 맞습니까?")) return false;
}
</script>
</html>