<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>study2</title>
</head>
<body>
﻿<%
String[] foods={"김치찌개","된장찌개","불고기덮밥"};
//페이지전환(study2_result.jsp)
//Forward
request.setAttribute("FOODS", foods);
RequestDispatcher r = request.getRequestDispatcher("study2_result.jsp");
r.forward(request, response);
%>
</body>
</html>