<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>idCheck.jsp</title>
</head>
<body>
<div align="center">
<h2>계정 중복 확인</h2>
<form action="idCheck.do" name="idCheck">
<input type="hidden" name="OkId" value="${ID }"/>
계 정 : <input type="text" name="USER_ID" value="${ID }"/>
<input type="submit" value="중복검사"/>
</form>
<c:if test="${ ! empty DUP }">
	${DUP }는 이미 사용중입니다.
	<script type="text/javascript">
		opener.document.form.ID.value = "";
	</script>
</c:if>
<c:if test="${ empty DUP }">
	${ID }는 사용 가능합니다.
	<input type="button" value="사용하기" onClick="idOk()"/>
</c:if>
</div>
</body>
<script type="text/javascript">
function idOk(){
	opener.document.form.ID.value = document.idCheck.OkId.value;
	opener.document.form.idChecked.value = "DONE";
	opener.document.getElementById("ID").readOnly = true;
	self.close();
}	
</script>
</html>