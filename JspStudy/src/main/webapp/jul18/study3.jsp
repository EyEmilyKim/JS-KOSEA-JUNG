<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>study3</title>
</head>
<body>
<%
//목적지(문자열)를 배열로 선언
String[] target = {"대전","강릉","광주","대구","부산"};
String html = "<table border='1'><tr>";
for(int i=0; i<target.length; i++){
	html = html + "<td>" +target[i] +"</td>";
}
html = html + "</tr></table>";
out.print(html);
%>
</body>
</html>