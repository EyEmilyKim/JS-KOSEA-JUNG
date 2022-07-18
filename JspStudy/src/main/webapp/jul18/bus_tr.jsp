<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bus_tr</title>
</head>
<body>
<div align="center">
<h2>고속 버스 예매 홈</h2>
<form action="buspay_tr.jsp">
고객이름 : <input type="text" name="NAME" size="10"/><br/>
목적지 : 대전<input type="radio" name="TARGET" value="1"/>
강릉<input type="radio" name="TARGET" value="2"/>
광주<input type="radio" name="TARGET" value="3"/>
대구<input type="radio" name="TARGET" value="4"/>
부산<input type="radio" name="TARGET" value="5"/><br/>
좌석 : 일반<input type="radio" name="SEAT" value="1"/>,
우등<input type="radio" name="SEAT" value="2"/><br/><br/>
인원<select name="NUM">
<%
	for(int i=1; i<11; i++){
		out.print("<option>"+i+"</option>");
	}
%>
</select><br/><br/>
<input type="submit" value="예매하기"/>
<input type="reset" value="취 소"/>
</form>
</div>
</body>
</html>