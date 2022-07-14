<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>study2.jsp</title>
</head>
<body>
<%
//파라미터 NUM1과 NUM2를 수신한다
//파라미터를 수신할 때 사용하는 JSP객체 : request
//Java에서 모든 파라미터는 문자열로 취급이 된다. 숫자를 입력해도 문자열!
String num1 = request.getParameter("NUM1");
String num2 = request.getParameter("NUM2");
//문자열을 정수로 바꿔준다
int n1 = Integer.parseInt(num1);
int n2 = Integer.parseInt(num2);
//사칙연산
int sum = n1 + n2;
int sub = n1 - n2;
int mul = n1 * n2;
int div = n1 / n2;

%>
입력한 첫번째 수 : <%= num1 %> , 입력한 두번째 수 : <%= num2 %><br/><br/>
덧셈의 결과 : <%= sum %> , 뺄셈의 결과 : <%= sub %><br/> 
곱셈의 결과 : <%= mul %> , 나눗셈의 결과 : <%= div %>  

</body>
</html>