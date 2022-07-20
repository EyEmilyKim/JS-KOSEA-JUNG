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
// 	out.print("추천된 맥주 : "+beerName);
%>
<%!
	String makeBeer(String c){
		String name = "";
		switch(c){
		case "1": name = "OB lager"; break;
		case "2": name = "STAUT"; break;
		case "3": name = "CORONA"; break;
		case "4": name = "Kirin brown"; break;
		}	
		return name;
	}
%>
<%
//1.redirect
// response.sendRedirect("beerResult.jsp?BN="+beerName);
//2.forward
RequestDispatcher rd = request.getRequestDispatcher("beerResult.jsp?BN="+beerName);
rd.forward(request, response);
%>
</body>
</html>