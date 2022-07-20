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
String times[] = {"09:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00","21:00",};
%>
<form action="buyTicket_me.jsp" onSubmit="return check()" name="FRM">
<p>관람할 영화를 선택하세요. <select name="MOVIE">
<%
	for(int i=0; i<movies.length; i++){
		out.print("<option>"+movies[i]+"</option>");
	}
%>
	</select></p>
<p>날짜를 선택하세요. <input type="date" name="DATE"></p>
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
<script type="text/javascript">
function check(){
	var movie = document.FRM.MOVIE.value;
	var date = document.FRM.DATE.value; 
	var time = document.FRM.TIME.value; 
	var age = document.FRM.AGE.value;
	var ageT ="";
	if(age=="A") ageT="성인"; else ageT="청소년";  
	var num = document.FRM.NUM.value; 
	var r = confirm("아래 내용이 맞습니까?\n\n영화 : "+movie+"\n날짜 : "+date+
					"\n시간 : "+time+"\n구분 : "+ageT+"\n인원 : "+num);
	return r;	
}
</script>
</body>
</html>