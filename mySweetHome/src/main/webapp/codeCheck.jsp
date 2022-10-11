<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>codeCheck.jsp</title>
</head>
<body>
<div align="center">
<h2> 상품번호 중복 확인</h2>
<form action="codeCheck.do" name="subFrm">
	상품 번호: <input type="text" name="CODE" value="${CODE }"/>
	<input type="submit" value="중복 검사"/>
</form>
<c:if test="${DUP != null }">
	${CODE }는 이미 사용중입니다.
	<script type="text/javascript">
	opener.document.itemFrm.CODE.value="";
	</script>
</c:if>
<c:if test="${DUP == null }">
	${CODE }는 사용 가능합니다.
	<input type="button" value="사용" onClick="codeOk()"/>
</c:if>
</div>
</body>
<script type="text/javascript">
function codeOk(){
	opener.document.itemFrm.CODE.value = document.subFrm.CODE.value;
	opener.document.itemFrm.codeChecked.value="OK";
	opener.document.getElementById("code").readOnly=true;
	self.close();
}
</script>
</html>