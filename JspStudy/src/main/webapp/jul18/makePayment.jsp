<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>makePayment.jsp</title>
<style type="text/css">
th { padding:5px;  }
td { padding:10px; text-align:center; }
</style>
</head>
<body>
<%
String target = request.getParameter("TARGET");//목적지
String price = request.getParameter("PRICE");//운임
String num = request.getParameter("NUM");//인원수
String seat = request.getParameter("SEAT");//좌석종류
int priceInt = Integer.parseInt(price);//문자열->정수
int numInt = Integer.parseInt(num);//문자열->정수
double total = 0;//최종요금을 위한 변수 선언
if(seat.equals("1")){//일반석
	total = priceInt * 1 * numInt;
}else if(seat.equals("2")){//우등석
	total = priceInt * 1.1 * numInt;
}
out.print("<div align='center'><table border='1'><tr><th>목적지</th><th>인원수</th><th>좌석종류</th>");
out.print("<th>총액</th></tr>");
out.print("<tr><td>"+target+"</td><td>"+num+"</td>");
if(seat.equals("1")){ out.print("<td>일 반</td>"); }
else { out.print("<td>우 등</td>"); }
out.print("<td>"+total+"원</td></tr></table></div>");
%>
</body>
</html>