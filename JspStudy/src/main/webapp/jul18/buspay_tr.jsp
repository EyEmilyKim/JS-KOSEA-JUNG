<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>buspay_tr</title>
</head>
<body>
<%
//파라미터(TARGET, SEAT, NUM)를 수신한다
String target = request.getParameter("TARGET");
String seat = request.getParameter("SEAT");
String num = request.getParameter("NUM");
String customer = request.getParameter("NAME");
//운임(일반) = 목적지 가격 * 인원수
//운임(우등) = 일반 * 1.1
//목적지 가격 - 대전(20000), 강릉(28000), 광주(30000), 대구(30000), 부산(40000)
//좌석등급 - 우등 = 일반의 110%
int price = calculate(target,num);
double realPrice = 0;
// switch(seat){
// case "1": realPrice = price; break;//일반
// case "2": realPrice = price * 1.1; break;//우등
// }
if(seat.equals("1")){
	realPrice = price;
}else if("2".equals(seat)){
	realPrice = price * 1.1;
}
out.print("예약자 성명 : "+customer + "<br/>");
out.print("<font color='blue' size='5'>"+realPrice+"원</font>");
%>
<%!
int calculate(String target, String num){
	int total = 0;//운임이 저장될 변수 선언
	int quantity = Integer.parseInt(num);
	switch(target){
	case "1": total = 20000 * quantity; break; //대전
	case "2": total = 28000 * quantity; break; //강릉
	case "3": total = 30000 * quantity; break; //광주
	case "4": total = 30000 * quantity; break; //대구
	case "5": total = 40000 * quantity; break; //부산
	}
	return total;
}
%>
</body>
</html>