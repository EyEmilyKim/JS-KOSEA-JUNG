<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>303.coffeeHome</title>
</head>
<body>
<div align="center">
<%
	String id = (String)session.getAttribute("LOGIN");
	if(id != null){
%>
<h2>커피 주문 App</h2>
<p>원하시는 커피를 선택하고 주문 버튼을 누르세요. </p>
<form action="304.coffeeOrder.jsp">
아메리카노 <input type="radio" name="NAME" value="A"/>, 
카푸치노 <input type="radio" name="NAME" value="B"/>, 
카페모카 <input type="radio" name="NAME" value="C"/>, 
카페라떼 <input type="radio" name="NAME" value="D"/><br/><br/>
수량 선택 <select name="NUM">
<%
	for(int i=0; i<11; i++){
		out.print("<option>"+i+"</option>");
	}
%> 
</select><br/><br/>
<input type="submit" value="주문하기"/>
<input type="reset" value="초기화"/>
</form>
</div>
<%
	}else{
%>
<script type="text/javascript">
	alert("로그인한 상태가 아닙니다.\n서비스를 이용하려면 로그인을 해야합니다.");
	location.href="301.coffeeLogin.jsp";
</script>
<%		
	}
%>		
</body>
</html>