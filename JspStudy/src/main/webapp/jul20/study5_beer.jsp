<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>study5_beer</title>
</head>
<body>
<div align="center">
<h2>맥주 추천 APP ver1.0</h2>
<p>원하시는 색을 선택하고 버튼을 누르면 추천하는 맥주를 확인할 수 있습니다.</p>
<form action="beerExpert2.jsp">
선호하는 색 : <select name="COLOR">
	<option value="1">밝은 색</option>
	<option value="2">어두운 색</option>
	<option value="3">노란색</option>
	<option value="4">갈색</option></select><br/>
<input type="submit" value="확 인"/>
<input type="reset" value="취 소"/>
</form>
</div>
</body>
</html>