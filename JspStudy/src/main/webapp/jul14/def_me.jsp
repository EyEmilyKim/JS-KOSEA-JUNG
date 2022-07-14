<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>def_me</title>
</head>
<body>
<div align="center">
<h2>((도전과제)) 투수 방어율 계산기</h2>
<p>선수 이름과 이닝수, 자책점을 입력하고 버튼을 누르면 해당 선수의 방어율(평균자책점)이 출력됩니다.</p>
<form action="defRate_me.jsp">
선수 이름: <input type="text" name="NAME" size="5"/>, 
총 이닝수: <input type="text" name="INNING" size="5"/>, 
총 자책점: <input type="text" name="FAIL" size="5"/><br/><br/>
<input type="submit" value="계산하기"/>
<input type="reset" value="초기화"/>
</form>
</div>
</body>
</html>