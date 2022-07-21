<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>301.coffeeLogin</title>
</head>
<body>
<div align="center">
<h2>커피 주문 홈</h2>
서비스를 이용하시려면 로그인을 하세요.<br/>
<form action="302.coffeeLoginProcess.jsp" method="post">
ID : <input type="text" name="ID" size="10"><br/>
PW : <input type="password" name="PW" size="10"><br/><br/>
<input type="submit" value="로그인"/>
</form>
</div>
</body>
</html>