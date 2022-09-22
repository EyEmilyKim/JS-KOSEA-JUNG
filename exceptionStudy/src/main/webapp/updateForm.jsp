<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateForm</title>
</head>
<body>
<header>
	<h2 align="center">게시글 변경</h2>
</header>
<section>
<div align="center">
<form action="updateBBS.do" method="post" onSubmit="return check(this)">
<p>변경할 게시글의 글번호와 글제목, 글내용을 입력하고 버튼을 누르세요.
<br/>
<table border="1">
  <tr><th>글번호</th><td><input type="text" name="ID"/></td></tr>
  <tr><th>글제목</th><td><input type="text" name="TITLE"/></td></tr>
  <tr><th>글내용</th>
  	  <td><textarea rows="4" cols="50" name="CONTENT"></textarea></td></tr>
  <tr><td colspan="2" align="center"><input type="submit" value="확 인"/>
  		<input type="reset" value="취 소"/></td></tr>	  
</table>

</p>
</form>
</div>
</section>
<footer>
	<h3 align="center">Copyright 2022.</h3>
</footer>
<script type="text/javascript">
function check(f){
	if(f.ID.value==''){
		alert("변경하려는 글 번호를 입력하세요."); return false;
	}else {
		if(isNaN(f.ID.value)){
			alert("글 번호는 숫자로 입력하세요."); return false;
		}
	}
	if(f.TITLE.value==''){
		alert("변경하려는 글 제목을 입력하세요."); return false;	
	}else {
		if(f.TITLE.value.length > 30){
			alert("글 제목은 30자 내외로 입력하세요."); return false;
		}
	}
	if(f.CONTENT.value==''){
		alert("변경하려는 글 내용을 입력하세요."); return false;	
	}else {
		if(f.CONTENT.value.length > 100){
			alert("글 내용은 100자 내외로 입력하세요."); return false;
		}
	}
	if(! confirm("정말로 변경하시겠습니까?")) return false;
}
</script>
</body>
</html>