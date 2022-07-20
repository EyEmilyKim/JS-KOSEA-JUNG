<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>buyTicket_me.jsp</title>
</head>
<body>
<%
	String movie = request.getParameter("MOVIE");
	String date = request.getParameter("DATE");
	String time = request.getParameter("TIME");
	String age = request.getParameter("AGE");
	String num = request.getParameter("NUM");
	Int price = 0;
	Int total = 0;
	//요금체계: 시간대에 따라 다르다.
	//상영시간 오전중-8000원, 14시전-9000원, 18시전-10000원, 18시이후-11000원(성인기준)
	//청소년은 2000원 할인
	switch(times){
	case "10:00" : price=8000; break; 
	case "12:00" :
	case "14:00" : price=9000; break;
	case "16:00" : 
	case "18:00" : price=10000; break;
	case "20:00" : price=11000; break;
	}
	if(age.equals("A")){
		
	}else(){}
%>
	//요금체계: 시간대에 따라 다르다.
	//상영시간 오전중-8000원, 14시전-9000원, 18시전-10000원, 18시이후-11000원(성인기준)
	//청소년은 2000원 할인

String movie = <%=movie %><br/>
String date = <%=date %><br/>
String time = <%=time %><br/>
String age = <%=age %><br/>
String num = <%=num %><br/>

</body>
</html>