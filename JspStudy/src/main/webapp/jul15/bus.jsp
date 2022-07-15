<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bus</title>
</head>
<body>
<div align="center">
<h2>((도전과제)) 고속버스 예매 홈</h2>
<form action="busPro.jsp">
목적지 : 
대전<input type="radio" name="TO" value="DJ">, 
강릉<input type="radio" name="TO" value="GR">, 
광주<input type="radio" name="TO" value="GJ">, 
대구<input type="radio" name="TO" value="DG">, 
부산<input type="radio" name="TO" value="BS"><br/>
등급 : 
일반<input type="radio" name="TIER" value="1">, 
우등<input type="radio" name="TIER" value="1.5"><br/>
인원수 : <select name="NUM">
<%
for(int i=0; i<11; i++){
	out.print("<option>"+i+"</option>");
}
%>
</select><br/><br/>
<input type="submit" value="예약하기"/>
<input type="reset" value="초기화"/>
</form>
</div>
</body>
</html>