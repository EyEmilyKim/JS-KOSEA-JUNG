<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>penaltyHome</title>
</head>
<body>
<div align="center">
<h2>승부차기 게임</h2>
<p>킥의 방향을 선택하고 버튼을 누르면 결과가 출력됩니다.</p>
<form action="penaltyProcess.jsp">
<table border="1">
	<tr><td></td>
		<td>상<input type="radio" name="DIR" value="1"/></td><td></td></tr>
	<tr><td>좌<input type="radio" name="DIR" value="2"/></td>
		<td>중<input type="radio" name="DIR" value="3"/></td>
		<td>우<input type="radio" name="DIR" value="4"/></td></tr>
	<tr><td></td>
		<td>하<input type="radio" name="DIR" value="5"/></td><td></td></tr>
</table><br/><br/>
<input type="submit" value="슛 하기"/>
<input type="reset" value="초기화"/>
</form>
</div>
</body>
</html>