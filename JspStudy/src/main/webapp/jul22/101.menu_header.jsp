<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div align="center">
<table>
<tr>
	<td><a href="102.home.jsp">■ HOME</a></td>
	<td><a href="401.coffeeHome.jsp">■ 커피주문</a></td>
	<td><a href="301.busReservation.jsp">■ 버스예매</a></td>
<%
	String data = (String)session.getAttribute("MEMBER");
	if(data==null){
%>
	<td><a href="201.login.jsp">■ 로그인</a></td>
<% 		
	}else{
%>		
	
	<td><a href="205.logout.jsp">■ 로그아웃</a></td>
	<tr><td></td><td></td><td></td>
	<td><font color="blue">환영합니다~	<%=data %>님~<br/></font></td></tr>
<%
	}
%>	
</tr>
</table>
</div>
