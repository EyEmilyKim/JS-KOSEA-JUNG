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
<tr><th>������</th><td><input type="text" name="title"
	size="20" value="${IMG.title }"/></td></tr>
<tr><th>�ۼ���</th><td><input type="text" size="20"
	value="${IMG.id }" readOnly="readOnly"/></td></tr>
<tr><th>�ۼ���</th><td><input type="text" size="20"
	value="${IMG.reg_date }" readOnly="readOnly"/></td></tr>
<tr><th>�� ȣ</th><td><input type="password" name="pwd"
	size="20"/></td></tr>
<tr><th>�̹���</th><td><input type="file" name="image_name"/>
	<br/><img alt="" src="upload/${IMG.image_name }"
		width="250" height="250"></td></tr>
<tr><th>�۳���</th><td><textarea rows="8" cols="40"
	name="content">${IMG.content }</textarea></td></tr>
<tr><td colspan="2" align="center">
	<input type="submit" value="����"/>
	<input type="reset" value="���"/></td></tr>
</table>
</form>
<script type="text/javascript">
function check(fm){
	if(fm.title.value==''){
		alert("������ �Է��ϼ���."); return false;
	}
	if(fm.pwd.value==''){
		alert("��ȣ�� �Է��ϼ���."); return false;
	}
	if(fm.content.value==''){
		alert("�۳����� �Է��ϼ���."); return false;
	}
	if( ! confirm("������ �����Ͻðڽ��ϱ�?")) return false;
}
</script>
</body>
</html>










