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
<c:if test="${ empty NOTICE }">
	<h3>�������� �ʴ� �������Դϴ�.</h3>
</c:if>
<c:if test="${ ! empty NOTICE }">
	<h3>������ �󼼺���</h3>
	<form action="modifyNotice.do" method="post"
			onSubmit="return check(this)">
	<table width="100%">
	<tr><th>�۹�ȣ</th><td><input type="text" name="SEQ"
	value="${NOTICE.seqno}" readOnly="readonly"/></td></tr>
	<tr><th>�� ��</th><td><input type="text" name="TITLE"
		value="${NOTICE.title }"/></td></tr>
	<tr><th>�ۼ���</th><td><input type="text" name="WRITER"
	value="${NOTICE.writer}" readOnly="readonly"/></td></tr>
	<tr><th>�ۼ���</th><td><input type="text" name="DATE"
	value="${NOTICE.reg_date}" readOnly="readonly"/></td></tr>
	<tr><th>�� ��</th><td><textarea rows="5" cols="40"
	name="CONTENT">${NOTICE.content }</textarea></td></tr>
	<c:if test="${ ! empty sessionScope.MANAGER }">
	<tr><td colspan="2" align="center">
		<input type="submit" value="�� ��" name="BTN"/>
		<input type="submit" value="�� ��" name="BTN"/>
		<input type="reset" value="�� ��"/></td></tr>
	</c:if>
	</table>
	</form>
</c:if>
</div>
<script type="text/javascript">
function check(frm){
	if(frm.TITLE.value == ''){
		alert("������ �Է��ϼ���."); return false;
	}
	if(frm.CONTENT.value == ''){
		alert("������ �Է��ϼ���."); return false;
	}
	if( ! confirm("�۾��� �����Ͻðڽ��ϱ�?")) return false;
}
</script>
</body>
</html>










