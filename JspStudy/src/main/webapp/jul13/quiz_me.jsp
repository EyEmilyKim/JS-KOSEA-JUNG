<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>quiz_me</title>
</head>
<body>
<%!
String makePick(int a){
	String result = "";
	switch(a){
		case 1: result = "홀"; break;
		case 2:	result = "짝"; break;
	}
	return result; 
}
%>
<%
String gamer = request.getParameter("HOLZZAK");
int gamerInt = Integer.parseInt(gamer);
int com = (int)(Math.random()*2+1);
String gamerPick = makePick(gamerInt);
String comPick = makePick(com);

String html = "<font color='blue' size='4'>";
if(com==gamerInt){
	html = html + "You Win!";
}else {
	html = html + "You Lose...";
}
html = html + "</font>";
%>
컴퓨터 : <%=comPick %> , 게이머 : <%=gamerPick %><br/>
결과 : <%= html %>
</body>
</html>