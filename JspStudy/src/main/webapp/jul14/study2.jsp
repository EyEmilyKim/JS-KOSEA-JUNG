<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>study2.jsp</title>
</head>
<body>
<%!
	int method1(){ return 100; }
	double method2(){ return 3.14; }
	boolean method3(){ return true; }
	char method4(){ return 'X'; }
	String method5(){ return "KOREA"; }
	void method6(){	}
%>
<%
	int a = method1();
	double b = method2();
	boolean c = method3();
	char d = method4();
	String e = method5();
	method6();
	out.print("<font color='red' size='5'>KOREA</font><br/>");
	out.print("<font color='red' size='5'>"+a+"</font><br/>");
%>
a = <%=a %> , b = <%=b %> , c = <%=c %> , 
d = <%=d %> , e = <%=e %>  
</body>
</html>