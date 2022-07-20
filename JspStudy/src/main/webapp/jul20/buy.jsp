<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//두번째 페이지에서 결제 처리
System.out.println("계좌에서 금액이 인출된다");

//세번째 페이지로 가서 결과 메세지 출력
//Redirect? Forward?
/* 1.Redirect */
response.sendRedirect("buyResult.jsp");

/* 2.Forward */
// RequestDispatcher rd = request.getRequestDispatcher("buyResult.jsp"); 
// rd.forward(request, response);
%>
</body>
</html>