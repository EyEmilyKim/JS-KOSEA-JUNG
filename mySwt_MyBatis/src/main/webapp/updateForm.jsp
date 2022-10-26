<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="updateImage.do" method="post"
	enctype="multipart/form-data"
	onSubmit="return check(this)">
<input type="hidden" name="id" value="${IMG.seqno }"/>
<table width="100%">
<tr><th>글제목</th><td><input type="text" name="title"
	size="20" value="${IMG.title }"/></td></tr>
<tr><th>작성자</th><td><input type="text" size="20"
	value="${IMG.id }" readOnly="readOnly"/></td></tr>
<tr><th>작성일</th><td><input type="text" size="20"
	value="${IMG.reg_date }" readOnly="readOnly"/></td></tr>
<tr><th>암 호</th><td><input type="password" name="pwd"
	size="20"/></td></tr>
<tr><th>이미지</th><td><input type="file" name="image_name"/>
	<br/><img alt="" src="upload/${IMG.image_name }"
		width="250" height="250"></td></tr>
<tr><th>글내용</th><td><textarea rows="8" cols="40"
	name="content">${IMG.content }</textarea></td></tr>
<tr><td colspan="2" align="center">
	<input type="submit" value="수정"/>
	<input type="reset" value="취소"/></td></tr>
</table>
</form>
<script type="text/javascript">
function check(fm){
	if(fm.title.value==''){
		alert("제목을 입력하세요."); return false;
	}
	if(fm.pwd.value==''){
		alert("암호를 입력하세요."); return false;
	}
	if(fm.content.value==''){
		alert("글내용을 입력하세요."); return false;
	}
	if( ! confirm("정말로 수정하시겠습니까?")) return false;
}
</script>
</body>
</html>










