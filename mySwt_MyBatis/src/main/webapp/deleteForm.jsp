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
<form action="deleteImage.do" method="post"
	onSubmit="return check(this)">
<input type="hidden" name="id" value="${IMG.seqno }"/>
<table width="100%">
<tr><th>글제목</th><td>${IMG.title }</td></tr>
<tr><th>작성자</th><td>${IMG.id }</td></tr>
<tr><th>작성일</th><td>${IMG.reg_date }</td></tr>
<tr><th>암 호</th><td><input type="password" name="pwd"/>
	</td></tr>
<tr><th>이미지</th><td><img alt="" width="250" height="250" 
	src="upload/${IMG.image_name }"></td></tr>
<tr><th>글내용</th><td>${IMG.content }</td></tr>
<tr><td colspan="2" align="center">
	<input type="submit" value="삭제"/>
	<input type="reset" value="취소"/></td></tr>
</table>
</form>
</div>
<script type="text/javascript">
function check(fm){
	if(fm.pwd.value == ''){
		alert("암호를 입력하세요."); return false;
	}
	if( ! confirm("정말로 삭제하시겠습니까?")) return false;
}
</script>
</body>
</html>









