<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>beerResult.jsp</title>
</head>
<body>
<%
//전달된 내장객체 request 안의 데이터를 획득하여 변수에 담음.
String[] brands = (String[])request.getAttribute("BRANDS");
String color = (String)request.getAttribute("COLOR");
String colorT ="";
switch(color){
case "1": colorT="밝은 색"; break; 
case "2": colorT="어두운 색"; break; 
case "3": colorT="노란색"; break; 
case "4": colorT="갈색"; break; 
}
%>
<div align="center">
<table border="1">
	<caption>선택한 맥주 색깔 : <%=colorT %></caption>
	<tr><th>추천된 맥주 이름</th></tr>
<%
	for(int i=0; i<brands.length; i++){
		out.print("<tr><td>"+brands[i]+"</td></tr>");
	}
%>
</table>
</div>
</body>
</html>