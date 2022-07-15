<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>busPro</title>
</head>
<body>
<%
String to = request.getParameter("TO");
String tier = request.getParameter("TIER");
String num = request.getParameter("NUM");
int total = getTotal(to, tier, num);

String html = "<div align='center'>";
html = html + "총 요금 : <font color='blue' size='4'>"+total+" 원</font></div>";
out.print(html);
%>
<%!
int getTotal(String to, String tier, String num){
	int price = 0;
	double t = Double.parseDouble(tier); //우등은 일반 요금의 1.5배
	int q = Integer.parseInt(num);
	switch(to){
	case "DJ": price = 10000; break; //대전(요금:10000원) 
	case "GR": price = 13000; break; //강릉(요금:13000원) 
	case "GJ": price = 15000; break; //광주(요금:15000원) 
	case "DG": price = 20000; break; //대구(요금:20000원) 
	case "BS": price = 25000; break; //부산(요금:25000원) 
	}
	int total = (int)(price * t * q);
	return total;
}
%>
</body>
</html>