<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	header, nav, section, footer {text-align:center; border: 1px solid gray; padding: 10px;}
	th, td {padding:0 10px; text-align:center;}
</style>
</head>
<body>
<header>
	<h4>(과정평가형 정보처리산업기사) 지역구의원투표 프로그램 ver 2020-05</h4>
</header>
<nav>
	<%@ include file="menu_header.jsp" %>
</nav>
<section>
	<h3>투표검수조회</h3>
<%
	ArrayList<Vote> list = (ArrayList) request.getAttribute("LIST");
	String curYear = (String) request.getAttribute("CYEAR");
	Integer amount = list.size(); 
%>	
	<p>제1투표장 한정 결과 : 총 <%=amount%> 건</p>
	<div class="contents" align="center">
	<table border="1">
	<tr><th>성명</th><th>생년월일</th><th>나이</th><th>성별</th>
		<th>후보번호</th><th>투표시간</th><th>유권자확인</th></tr>
<%
	for(Vote vt : list){
		String yyyy;
		if(Integer.parseInt(vt.getYy()) <= Integer.parseInt(curYear)){
			yyyy = "20"+vt.getYy(); 		
		}else{
			yyyy = "19"+vt.getYy();
		}
		String birth_str = yyyy+"년"+vt.getMm()+"월"+vt.getDd()+"일생";
		vt.setV_birth_str(birth_str);
		if( Integer.parseInt(vt.getV_gender())%2 == 0 ){ 
			vt.setV_gender_str("남"); //성별data가 짝수면 "남"
		}else {
			vt.setV_gender_str("여");
		}
%>
	<tr><td><%=vt.getV_name()%></td>
		<td><%=vt.getV_birth_str()%></td>
		<td>만 <%=vt.getV_age()%>세</td>
		<td><%=vt.getV_gender_str()%></td>
		<td><%=vt.getM_no()%></td>
		<td><%=vt.getV_time_str()%></td>
		<td><%=vt.getV_confirm()%></td></tr>
<%		
	}
%>	
	</table>
	</div>
</section>
<footer>
	<h4>HRDKorea Copyright@2015 All rights reserved. 2022.11.29 Developed by EyKim</h4>
</footer>
</body>
</html>