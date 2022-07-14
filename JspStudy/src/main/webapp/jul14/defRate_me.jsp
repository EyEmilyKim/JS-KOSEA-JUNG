<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>def_me</title>
</head>
<body>
<%
String name = request.getParameter("NAME");
String inning = request.getParameter("INNING");
String failSt = request.getParameter("FAIL");
int inn = Integer.parseInt(inning);
int fail = Integer.parseInt(failSt);
double ERA = calculate(inn, fail);
String html = name + " 선수의 방어율(평균자책점)은 <font color='blue'>"+ERA+"</font>입니다.";
out.print(html);
%>
<%!
//방어율(평균자책점) 공식 :
//방어율 = (총 자책점*9)/총 던진 이닝수
double calculate(int i, int f){
	double result = 0;
	result = (f*9)/i;
	return result;
}
%>
</body>
</html>