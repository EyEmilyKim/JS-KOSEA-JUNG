<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>study4_bus</title>
<style type="text/css">
th { padding:5px;  }
td { padding:10px; text-align:center; }
</style>
</head>
<body>
<div align="center">
<h2>고속 버스 예매 홈 ver2.0</h2>
<h3>목 적 지</h3>
<%
String[] target = {"대전","강릉","광주","대구","부산"};
int[] price = {25000,28000,30000,30000,40000};
%>
<table border="1">
	<tr><th>행 선 지</th><th>요 금</th>
		<th>인 원 수</th><th>좌석 종류</th><th>선 택</th></tr>
<%
	for(int i=0; i<target.length; i++){
		
%>
	<form action="makePayment.jsp">
	<input type="hidden" name="TARGET" value="<%= target[i] %>"/>
	<input type="hidden" name="PRICE" value="<%= price[i] %>"/>
	<tr><td><%= target[i] %></td><td><%= price[i] %></td>
		<td><select name="NUM">
<%
	for(int j=1; j<11; j++){
		out.print("<option>"+j+"</option>");
	}
%>
		</select></td>
		<td>일반<input type="radio" name="SEAT" value="1"/> 
			우등<input type="radio" name="SEAT" value="2"/></td>
		<td><input type="submit" value="선 택"/></td></tr>
	</form>
<%	
	}
%>
</table><br/><br/>
<!-- 이하 모양새만 갖춰놓은 page 번호 -->
<%
	for(int pg=1; pg<=5; pg++){
%>
	<font size='3'><a href=""><%=pg %></a></font>
<%	
	}
%>
</div>
</body>
</html>