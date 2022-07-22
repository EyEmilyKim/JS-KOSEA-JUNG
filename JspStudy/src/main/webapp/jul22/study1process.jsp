<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>study1process</title>
</head>
<body>
<%
	String num1 = request.getParameter("N1");
	String num2 = request.getParameter("N2");
	int n1 = Integer.parseInt(num1);
	int n2 = Integer.parseInt(num2);
	int sum = n1 + n2;
	int sub = n1 - n2;
	int mul = n1 * n2;
	int div = n1 / n2;
	//결과 페이지(study1result.jsp)로 전환
	//Redirect? Forward?
	//1.Redurect
	response.sendRedirect("study1result.jsp?S="+sum+"&U="+sub+"&M="+mul+"&D="+div);
	//2.Forward
// 	RequestDispatcher r = request.getRequestDispatcher("study1result.jsp?S="+sum+"&U="+sub+"&M="+mul+"&D="+div);
// 	r.forward(request, response);
%>
</body>
</html>