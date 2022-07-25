<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>﻿301.study3</title>
</head>
<body>
<h2>JAVA의 배열을 EL로 접근</h2>
<%
String[] winner = new String[3];//당첨자 명단용 배열선언
winner[0]="서울 김철수";
winner[1]="수원 강수민";
winner[2]="인천 박동국";

String[] items = new String[3];//상품 이름용 배열 선언
items[0] = "대형 벽걸이 TV";
items[1] = "대형 냉장고";
items[2] = "대형 세탁기";
session.setAttribute("WIN", items);
//당첨자 명단을 보여주는 JSP(winner.jsp)로 페이지 전환
//Redirect? Forward? 둘 다?
//정답은 Forward! 배열은 주소창 파라미터로 보낼 수 없다.
request.setAttribute("WIN", winner);
RequestDispatcher rd = request.getRequestDispatcher("302.winner.jsp");
rd.forward(request, response);
%>
</body>
</html>