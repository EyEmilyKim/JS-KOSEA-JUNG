<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" 
	prefix="fmt" %>	   
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2>��ǰ �� ����</h2>
<form action="itemModify.do" method="post"
	onSubmit="return check(this)">
<table width="100%">
	<tr><th>��ǰ ��ȣ</th><td><input type="text"
		name="CODE" value="${ITEM.code }"
		readOnly="readOnly"/></td></tr>
	<tr><th>��ǰ �̸�</th><td><input type="text"
		name="NAME" value="${ITEM.name }"/></td></tr>
	<tr><th>��ǰ ����</th><td>
		<input type="text" name="PRICE" 
				value="${ITEM.price }"></td></tr>
	<tr><th>�����</th><td>${ITEM.reg_date }</td></tr>
	<tr><th>�� ��</th><td><textarea rows="5" 
		cols="40" name="INFO">${ITEM.info }</textarea></td></tr>
	<c:if test="${sessionScope.MANAGER != null }">		
	<tr><td colspan="2" align="center">
		<input type="submit" value="����" name="BTN"/>
		<input type="submit" value="����" name="BTN"/></td></tr>
	</c:if>
</table>
</form>
</div>
<script type="text/javascript">
function check(frm){
	if(frm.NAME.value == ''){
		alert("��ǰ�̸��� �Է��ϼ���."); return false;
	}
	if(frm.PRICE.value == ''){
		alert("������ �Է��ϼ���."); return false;
	}else{
		if(isNaN(frm.PRICE.value)){
			alert("������ ���ڷ� �Է��ϼ���."); return false;
		}
	}
	if(frm.INFO.value == ''){
		alert("��ǰ ������ �Է��ϼ���."); return false;
	}
	if( ! confirm("�۾��� �����Ͻðڽ��ϱ�?")) return false;
}
</script>
</body>
</html>









