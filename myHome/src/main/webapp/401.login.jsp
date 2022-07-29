<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
<!-- 로그아웃 상태로 메뉴 접근 시 -->
<c:if test="${param.M == 'Y'}">
	<h3 align="center">이 서비스를 이용하시려면 로그인이 필요합니다.</h3>
</c:if>
<!-- 기본 로그인 페이지 -->
<form action="402.loginProcess.jsp" method="post" onSubmit="return check()" name="frm">
계 정 : <input type="text" name="ID" size="15"/><br/>
암 호 : <input type="password" name="PWD" size="15"/><br/>
<input type="submit" value="로그인"/>
<input type="reset" value="취소"/>
</form>
<script type="text/javascript">
function check(){
	if(document.frm.ID.value ==''){
		alert("계정을 입력하세요."); return false;
	}
	if(document.frm.PWD.value ==''){
		alert("암호를 입력하세요."); return false;
	}
}
</script>
</body>
</html>