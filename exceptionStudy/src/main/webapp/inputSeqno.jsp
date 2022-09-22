<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>inputSeqno</title>
</head>
<body>
<header>
	<h2 align="center">게시글 삭제</h2>
</header>
<section>
<div align="center">
<p>삭제하려는 게시글을 글 번호를 입력하고 버튼을 누르세요.<br/>
	<form action="deleteBBS.do" method="get" onsubmit="return check(this)">
	글 번호: <input type="text" name="ID" size="3">
	<br/><br/>
		<input type="submit" value="삭 제"/>	
		<input type="reset" value="취 소"/>	
	</form>
</p>
</div>
</section>
<footer>
	<h3 align="center">Copyright 2022.</h3>
</footer>
<script type="text/javascript">
function check(f){
	if(f.ID.value==''){
		alert("삭제하려는 글 번호를 입력하세요."); return false;
	}else {
		if(isNaN(f.ID.value)){
			alert("글 번호는 숫자로 입력하세요."); return false;
		}
	}
	if(! confirm("정말로 삭제하시겠습니까?")) return false;
}
</script>
</body>
</html>