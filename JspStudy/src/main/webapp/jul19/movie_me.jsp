<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>movie_me</title>
</head>
<body>
<div align="center">
<h2>((도전과제))영화 예매 홈</h2>
<%
String movies[] = {"앨비스","미니언즈","토르","명탐정 코난","샷건"};
String times[] = {"AM 10:00","PM 12:00","PM 14:00","PM 16:00","PM 18:00","PM 20:00"};
%>
<form action="buyTicket.jsp">
<p>관람할 영화를 선택하세요. <select name="MOVIE">
<%
	for(int i=0; i<movies.length; i++){
		out.print("<option>"+movies[i]+"</option>");
	}
%>
	</select></p>
<p>날짜를 선택하세요. <input type="date"></p>
<p>시간을 선택하세요. <select name="TIME">
<%
	for(int i=0; i<times.length; i++){
		out.print("<option>"+times[i]+"</option>");
	}
%>	
	</select></p>
<p>관람 구분을 선택하세요. 성인<input type="radio" name="AGE" value="A">  
청소년<input type="radio" name="AGE" value="T">
<p>매수를 선택하세요. <select name="NUM">
<%
for(int i=0; i<11; i++){
	out.print("<option>"+i+"</option>");
}	
%>
	</select></p>
<input type="submit" value="예약하기"/>
<input type="reset" value="취소"/>
</form>	
</div>
</body>
</html>