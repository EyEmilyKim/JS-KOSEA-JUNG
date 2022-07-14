<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>beerExpert</title>
</head>
<body>
<%
	String color = request.getParameter("COLOR");
	String beerName = makeBeer(color);
	out.print("추천된 맥주 : "+beerName);
%>
<%!
	String makeBeer(String c){
		String name = "";
		switch(c){
		case "1": name = "OB라거"; break;
		case "2": name = "스타우트"; break;
		case "3": name = "코로나"; break;
		case "4": name = "기린brown"; break;
		}	
		return name;
	}
%>
</body>
</html>