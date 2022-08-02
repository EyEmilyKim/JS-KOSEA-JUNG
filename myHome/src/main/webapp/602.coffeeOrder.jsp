<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>coffeeOrder</title>
</head>
<body>
<%
//파라미터를 수신한다
String coffee = request.getParameter("NAME");
String number = request.getParameter("NUM");
double total = findTotal(coffee, number);
//total에 있는 총액을 결과jsp(coffeeResult.jsp)로 전환 =>
response.sendRedirect("template.jsp?BODY=603.coffeeResult.jsp?total="+total);

%>
<%!
double findTotal(String coffee, String num){
	double price = 0; //음료수 가격을 위한 변수
	switch(coffee){
	case "A": price = 1.5; break; //아메리카노(1.5$)
	case "B": price = 2.5; break; //카푸치노(2.5$)
	case "C": price = 3.0; break; //카페모카(3.0$)
	case "D": price = 3.5; break; //카페라떼(3.5$)
	}	
	return price * Integer.parseInt(num);
}
%>
</body>
</html>