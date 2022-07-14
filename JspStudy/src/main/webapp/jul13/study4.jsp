<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>study4.jsp</title>
</head>
<body>
<%!
String makeResult(int a){
	String result = "";
	switch(a){
	case 1: result = "가위"; break;
	case 2: result = "바위"; break;
	case 3: result = "보"; break;
	}
	return result;
}
%>
<%
String gamer = request.getParameter("GAMER");//파라미터 값 얻는다
int com = (int)(Math.random()*3+1);//실수를 정수로 바꾼다
int gamerInt = Integer.parseInt(gamer);//문자열을 정수로 바꾼다
String gamerResult = makeResult(gamerInt);
String comResult = makeResult(com);
//아래와 같이 gamerResult, comResult 일일이 구하던 것을 위의 메서드로 바꿨음 
// switch(gamerInt){
// 	case 1: gamerResult = "가위"; break;
// 	case 2: gamerResult = "바위"; break;
// 	case 3: gamerResult = "보"; break;
// }
// switch(com){
// 	case 1: comResult = "가위"; break;
// 	case 2: comResult = "바위"; break;
// 	case 3: comResult = "보"; break;
// }
String html = "<font color='red' size='5'>";
if(com==gamerInt){
	html = html + "무승부";
}else if((gamerInt==1 && com==3)||(gamerInt==2 && com==1)||(gamerInt==3 && com==2)){
	html = html + "게이머 승";
}else {
	html = html + "컴퓨터 승";
}
html = html + "</font>";
%>
컴퓨터 : <%=comResult %> vs 게이머 : <%=gamerResult %><br/>
게임의 결과 : <%= html %>
</body>
</html>