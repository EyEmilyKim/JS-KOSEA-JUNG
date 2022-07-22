<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>201.login</title>
</head>
<body>
<div align="center">
<%-- <%@ include file="101.menu_header.jsp" %>  --%>
<!-- <h2>로 그 인</h2> -->
<form action="202.sessLogin.jsp" method="post">
계 정 : <input type="text" name="ID"/><br/>
암 호 : <input type="text" name="PWD"/><br/><br/>
<input type="submit" value="로그인"/> 
<input type="reset" value="취소"/>
</form>
</div>
</body>
</html>