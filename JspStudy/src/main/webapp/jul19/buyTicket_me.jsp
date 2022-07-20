<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>buyTicket_me.jsp</title>
<style type="text/css">
td { padding: 2px 10px; }
</style>
</head>
<body>
<%
	String movie = request.getParameter("MOVIE");
	String date = request.getParameter("DATE");
	String time = request.getParameter("TIME");
	String age = request.getParameter("AGE");
	String num = request.getParameter("NUM");
	int numInt = Integer.parseInt(num); 
	int price = 0;
	int total = 0;
	String ageT ="";
	//요금체계: 시간대에 따라 다르다.
	//상영시간 오전중-8000원, 12~13시대-9000원, 14~17시대-10000원, 18시이후-11000원(성인기준)
	//청소년은 2000원 할인
	switch(time){
	case "09:00" :
	case "10:00" :
	case "11:00" : price=8000; break; 
	case "12:00" :
	case "13:00" : price=9000; break;
	case "14:00" : 
	case "15:00" : 
	case "16:00" : 
	case "17:00" : price=10000; break;
	case "18:00" : 
	case "19:00" : 
	case "20:00" : 
	case "21:00" : price=11000; break;
	}
	if(age.equals("A")){
		total = price*numInt; ageT="성인";
	}else{
		total = (price-2000)*numInt; ageT="청소년"; 	
	}
%>
<div align="center">
<h3>결제하실 요금은 <%=total %>원 입니다.</h3>
<table border="1">
<caption>예매 정보</caption>
<tr><td>영화</td><td><%=movie %></td></tr>
<tr><td>날짜</td><td><%=date %></td></tr>
<tr><td>시간</td><td><%=time %></td></tr>
<tr><td>구분</td><td><%=ageT %></td></tr>
<tr><td>인원</td><td><%=numInt %></td></tr>
</table>
</div>
----------------------------------------------<br/>
//요금체계: 시간대에 따라 다르게 적용<br/>
//상영시간 오전중-8000원, 12~13시대-9000원, 14~17시대-10000원, 18시이후-11000원(성인기준)<br/>
//청소년은 2000원 할인<br/><br/>

</body>
</html>