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
<tr><th>������</th><td>${IMG.title }</td></tr>
<tr><th>�ۼ���</th><td>${IMG.id }</td></tr>
<tr><th>�ۼ���</th><td>${IMG.reg_date }</td></tr>
<tr><th>�� ȣ</th><td><input type="password" name="pwd"/>
	</td></tr>
<tr><th>�̹���</th><td><img alt="" width="250" height="250" 
	src="upload/${IMG.image_name }"></td></tr>
<tr><th>�۳���</th><td>${IMG.content }</td></tr>
<tr><td colspan="2" align="center">
	<input type="submit" value="����"/>
	<input type="reset" value="���"/></td></tr>
</table>
</form>
</div>
<script type="text/javascript">
function check(fm){
	if(fm.pwd.value == ''){
		alert("��ȣ�� �Է��ϼ���."); return false;
	}
	if( ! confirm("������ �����Ͻðڽ��ϱ�?")) return false;
}
</script>
</body>
</html>









