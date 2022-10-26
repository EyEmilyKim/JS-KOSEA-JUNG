<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2>공지사항 쓰기</h2>
<form action="noticePost.do" method="post" 
			onSubmit="return check(this)">
	<table>
		<tr><th>제 목</th><td><input type="text" name="TITLE"
			size="20" placeHolder="제목을 입력하세요."/></td></tr>
		<tr><th>내 용</th><td><textarea rows="6" cols="40"
			name="CONTENT"></textarea></td></tr>
		<tr><td colspan="2" align="center"><input type="submit"
			value="공지글 올리기"/> 
			<input type="reset" value="취 소"/></td></tr>
	</table>
</form>
</div>
<script type="text/javascript">
function check(fm){
	if(fm.TITLE.value == ''){
		alert("제목을 입력하세요."); return false;
	}else{
		if(fm.TITLE.value.length > 30){
			alert("30자 이내로 작성하세요"); return false;
		}
	}
	if(fm.CONTENT.value == ''){
		alert("내용을 입력하세요."); return false;
	}else{
		if(fm.CONTENT.value.length > 100){
			alert("100자 이내로 작성하세요.");return false;
		}
	}
	if( ! confirm("정말로 올리시겠습니까?"))
			return false;
}
</script>
</body>
</html>