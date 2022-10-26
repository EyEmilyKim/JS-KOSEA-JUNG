<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2>�̹��� �Խñ� �ۼ�</h2>
<form action="imageWrite.do" method="post"
	encType="multipart/form-data"
	onSubmit="return check(this)">
<input type="hidden" name="orderno" 
				value="${IMG.order_no + 1 }"/>
<c:if test="${ ! empty IMG.group_id }">
	<input type="hidden" name="groupid" 
				value="${IMG.group_id }"/>
</c:if>
<c:if test="${ ! empty IMG.parent_id }">
	<input type="hidden" name="parentid"
				value="${IMG.parent_id }"/>
</c:if>	
<table>
	<tr><th>�� ��</th><td><input type="text" name="TITLE"
			value="${title }"/>
		</td></tr>
	<tr><th>�� ȣ</th><td><input type="password"	name="PWD"/>
		</td></tr>
	<tr><th>�̹���</th><td><input type="file"
		name="IMAGENAME"/></td></tr>
	<tr><th>�۳���</th><td><textarea rows="8" cols="40"
		name="CONTENT"></textarea></td></tr>
	<tr><td colspan="2" align="center">
		<input type="submit" value="�ۿø���"/>
		<input type="reset" value="�� ��"/></td></tr>
</table>
</form>
</div>
<script type="text/javascript">
function check(fm){
	if(fm.TITLE.value == ''){
		alert("������ �Է��ϼ���."); return false;
	}else {
		if(fm.TITLE.value.length > 30){
			alert("������ 30�� �̳��� �ۼ��ϼ���.");
			return false;
		}
	}
	if(fm.PWD.value == ''){
		alert("��ȣ�� �Է��ϼ���."); return false;
	}
	if(fm.IMAGENAME.value == ''){
		alert("�̹��� ������ �����ϼ���."); return false;
	}
	if(fm.CONTENT.value == ''){
		alert("�� ������ �ۼ��ϼ���."); return false;
	}else {
		if(fm.CONTENT.value.length > 100){
			alert("�� ������ 100�� �̳��� �ۼ��ϼ���.");
			return false;
		}
	}
	if( ! confirm("�Է��� ������ �½��ϱ�?")) return false;
}
</script>
</body>
</html>









