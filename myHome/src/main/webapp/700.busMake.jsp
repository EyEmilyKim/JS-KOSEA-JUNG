<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>busMake</title>
</head>
<body>
<%
/* 로그인 검사 */
	//로그인 여부를 검사한다.
	//로그인 성공시 session객체에 LOGINID, MANAGER가 저장되므로, session객체에 LOGINID, MANAGER가 있는지 검사한다.
		String id = (String)session.getAttribute("LOGINID");
		String man = (String)session.getAttribute("MANAGER");	
		if(id == null && man == null){
			response.sendRedirect("template.jsp?BODY=401.login.jsp?M=Y");
		} else{
			String[] destinations = {"대전","강릉","광주","대구","부산"};
			int[] price = {25000,28000,30000,30000,40000};
			request.setAttribute("DESTI", destinations);
			request.setAttribute("PRICE", price);
			request.setAttribute("LENGTH", destinations.length);
			RequestDispatcher r = request.getRequestDispatcher("template.jsp?BODY=701.busHome.jsp");
			r.forward(request, response);
		}	
%>

</body>
</html>