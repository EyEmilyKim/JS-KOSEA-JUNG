<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	header, section, footer {border: 1px solid gray; text-align:center; }
	th, td {text-align:left; padding:0 5px;}
	.bttns {margin: 10px 0px;}
	.left {text-align:left; margin:10px 60px;}
	.right {text-align:right; margin:10px 60px;}
</style>
</head>
<body>
<header>
	<h2>영화 예매 정보</h2>
</header>
<section>
	
<%
	ArrayList<Watcher> listW = (ArrayList) request.getAttribute("ListW");
	ArrayList<Movie> listM = (ArrayList) request.getAttribute("ListM");
	ArrayList<Booking> listB = (ArrayList) request.getAttribute("ListB");
%>
	<div align="center">
	<form action="insertBooking.do" id="fm" method="post" >
	<table border="1" >
	<tr><th>고객번호</th>
		<td><select name="W_NO">
<%
	for(Watcher wr : listW){
%>
	<option value="<%=wr.getNo()%>"><%=wr.getNo()%> : <%=wr.getName()%></option>
<%		
	}
%>
			</select></td></tr>
	<tr><th>영화번호</th>
		<td><select name="M_ID">
<%
	for(Movie mv : listM){
%>
	<option value="<%=mv.getId()%>"><%=mv.getId()%> : <%=mv.getTitle()%></option>
<%		
	}
%>
			</select></td></tr>
	<tr><th>예매 수</th>
		<td><input type="number" name="TCKT"></td></tr>
	<tr><th>예매일</th>
		<td><input type="text" name="R_DATE" placeholder="yyyymmdd"></td></tr>
		
<%-- <%
	for(Booking bk : list){
%>
	<tr><td><%=bk.getW_no() %></td>
		<td><%=bk.getM_id() %></td>
	</tr>		
<%		
	}
%>	 --%>
	</table>
	<div class="bttns">
		<input type="button" value="예매등록" onclick="checkBooking()">
	</div>
	</form>
	</div>
</section>
<footer>
	<h4>Copyright (C) 2018 정보처리산업기사 All Right Reserved</h4>
</footer>
</body>
<script type="text/javascript">
function checkBooking() {
	alert("checkBooking() called");
	//기존 예매와 동일 고객번호 && 동일 영화번호 시 alert 기능 필요 [TBU]
	document.getElementById("fm").submit();
}
function check(){
	let str = "\n\n arg: "+arg;
	if(! confirm("등록하시겠습니까?"+str)) return false;
}
</script>
</html>