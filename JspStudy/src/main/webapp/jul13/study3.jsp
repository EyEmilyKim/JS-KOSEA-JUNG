<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>study3.jsp</title>
</head>
<body>
<%
//컴퓨터 난수와 게이머 난수를 만든다(범위: 1~6)
//실수를 정수로 바꾼다 : 형변환!
int com = (int)(Math.random()*6+1);
int gamer = (int)(Math.random()*6+1);
//승패
String winner = "";
if(com==gamer){
	winner = "무승부";
}else if(com>gamer){
	winner = "컴퓨터 승";
}else{
	winner = "게이머 승";
}
%>
//출력
com : <%= com %> , gamer : <%= gamer %><br/>
게임의 결과 : <%= winner %>
</body>
</html>