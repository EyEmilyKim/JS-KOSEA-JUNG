<%@page import="javax.swing.plaf.metal.MetalBorders.Flush3DBorder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>matjipResult</title>
</head>
<body>
<div align="center">
<h2>추천 맛집 목록</h2>

<h4>선택한 지역 : ${requestScope.AREA }</h4>
<c:forEach items="${requestScope.MATJIP }" var="matjip">
	${matjip }<br/>
</c:forEach>

<%-- <%
	String area = (String)request.getAttribute("AREA");
	//request에서 MATJIP을 찾는다
	String[] matjip = (String[])request.getAttribute("MATJIP");
%>
	<h4>선택한 지역 : <%= area %></h4>
<%	
	//MATJIP의 배열요소를 출력한다
	for(int i=0; i<matjip.length; i++){
		out.print(matjip[i]+"<br/>");
	}
%> --%>
</ul>
</div>
</body>
</html>