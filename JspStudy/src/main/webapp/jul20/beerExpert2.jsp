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
	String[] beerName = makeBeer(color);
// 	out.print("추천된 맥주 : "+beerName);
%>
<%!
	String[] makeBeer(String c){
		String[] name = null;//색에 따라 배열의 길이가 다를 것이기 때문에 일단 null로 초기화. 
		switch(c){
		case "1": name = new String[3];//비로서 배열의 길이가 특정되어 배열 객체로 선언할 수 있음.
				name[0] = "OB lager"; 
				name[1] = "OB Brother"; 
				name[2] = "OB Sitster"; break; 
		case "2": name = new String[2]; 
				name[0] = "Staut"; 
				name[1] = "Kopel"; break; 
		case "3": name = new String[3]; 
				name[0] = "CORONA"; 
				name[1] = "BORONA"; 
				name[2] = "DORONA"; break; 
		case "4": name = new String[2];
				name[0] = "Kirin brown";
				name[1] = "Mirin brown"; break;
		}	
		return name;
	}
%>
<%
//1.redirect 는 사용할 수 없다
// response.sendRedirect("beerResult2.jsp?BN="+beerName); 불가능!

//2.forward 방식은 사용 가능하지만, 파라미터가 아니라 내장객체로 담아 전달해야 한다.
/* FORWARD 방식 --> request 객체 담는 법
request.setAttribute(name, o);
request.setAttribute("BRANDS", beerName);
두번째 인자 o 에 배열이 들어가 있는 변수명을 써준다.
첫번째 인자 name 에 내장객체에 담을 변수명을 써준다. */
request.setAttribute("BRANDS", beerName);
request.setAttribute("COLOR", color);
RequestDispatcher rd = request.getRequestDispatcher("beerResult2.jsp");
rd.forward(request, response);
%>
</body>
</html>