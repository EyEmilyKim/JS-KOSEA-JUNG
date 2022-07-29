<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>matjipMake</title>
</head>
<body>
<%
	//맛집의 지역 이름을 배열에 넣는다
	String[] areas = {"종로구","성동구","강동구","강서구","강남구","강북구","송파구","성북구","서초구"};
	//배열을 matjipHome.jsp로 전달한다
	//Forward only
	request.setAttribute("AREA",areas);
	RequestDispatcher rd = request.getRequestDispatcher("template.jsp?BODY=501.matjipHome.jsp");
	rd.forward(request, response);
%>
</body>
</html>