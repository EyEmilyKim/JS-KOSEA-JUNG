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
//Java에서의 변수
	byte a = 10;
	double b = 1.1; 
	float b_1 = 1.1F;
	boolean c = true;
	char d = 'A' ;
	String e = "ABC";
%>

a=<%=a %> , b=<%= b %> , c=<%= c %> , d=<%= d %> , e=<%= e %>
<script type="text/javascript">
//Javascript의 변수
	var a = 10;
	var b = 1.1;
	var c = true;
	var d = 'A';
	var e =  "ABC"
</script>
</body>
</html>