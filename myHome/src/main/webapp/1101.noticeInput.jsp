<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1101.noticeInput</title>
</head>
<body>
<div align="center">
	<!-- form 메서드는 post 가 적합. 내용이 길기 때문에 주소창 parameter를 통하지 않는 것이 좋다. -->
	<form action="noticePost.do" method="post" onSubmit="return check(this)">
		<table>
		<tr><th>제 목</th><td><input type="text" name="TITLE"></td></tr>
		<tr><th>내 용</th><td><textarea rows="6" cols="40" name="CONTENT">
			</textarea></td></tr>
		<tr><td colspan="2" align="center">
			<input type="submit" value="글 올리기"/>
			<input type="reset" value="취 소"/></td></tr>
		</table>
	</form>
</div>
<script type="text/javascript">
function check(f){
	if(f.TITLE.value == ''){
		alert("제목을 입력하세요."); return false;
	}else {
		if(f.TITLE.value.length > 30){
			alert("제목은 30글자보다 이내여야 합니다.");
			return false;
		}
	}
	if(f.CONTENT.value == ''){
		alert("내용을 입력하세요."); return false;
	}else {
		if(f.CONTENT.value.length > 100){
			alert("내용은 100글자 이내여야 합니다.");
			return false;
		}
	}
	if( ! confirm("이대로 공지를 작성하시겠습니까?")){
		return false;
	}
// 	프로그램을 통한 DML은 자동 commit 되므로	반드시 confirm과정을 거치자!
}
</script>
</body>
</html>