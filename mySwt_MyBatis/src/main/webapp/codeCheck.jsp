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
<h2>��ǰ��ȣ �ߺ� Ȯ��</h2>
<form action="codeCheck.do" name="checkFrm">
��ǰ ��ȣ:<input type="text" name="CODE"
	value="${CODE }"/>
	<input type="submit" value="�ߺ� �˻�"/>
</form>
<c:if test="${DUP != null }">
	${CODE }�� �̹� ��� ���Դϴ�.
	<script type="text/javascript">
	opener.document.itemFrm.CODE.value="";
	</script>
</c:if>
<c:if test="${DUP == null }">
	${CODE }�� ��� �����մϴ�.
	<input type="button" value="���" onClick="codeOk()"/>
</c:if>
</div>
<script type="text/javascript">
function codeOk(){
	opener.document.itemFrm.CODE.value = 
			document.checkFrm.CODE.value;
	opener.document.itemFrm.codeChecked.value="OK";
	opener.document.getElementById("code").readOnly=true;
	self.close();
}
</script>
</body>
</html>










