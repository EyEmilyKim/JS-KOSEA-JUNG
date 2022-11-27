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
	th, td {text-align:center; padding:0 5px;}
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
	ArrayList<Booking> list = (ArrayList) request.getAttribute("LIST");
%>
	<div align="center">
	<div class="left">총 <%= list.size() %>건의 예매정보가 있습니다.</div>
	<table border="1" >
	<tr><th>예매자</th><th>연락처</th><th>영화제목</th><th>시작시간</th>
		<th>종료시간</th><th>예약 매수</th><th>예매일</th><th>관리</th></tr>
<%
	for(Booking bk : list){
		String m_id = bk.getM_id();
		String w_no = bk.getW_no();
		String r_date = bk.getR_date();
%>
	<tr><td><%=bk.getW_name() %></td>
		<td><%=bk.getW_phone() %></td>
		<td><%=bk.getM_title() %></td>
		<td><%=bk.getStartHr() %></td>
		<td><%=bk.getEndHr() %></td>
		<td><%=bk.getTickets() %></td>
		<td><%=r_date %></td>
		<td><a href="deleteBooking.do?MID=<%=m_id%>&WNO=<%=w_no%>&RDATE=<%=r_date%>" onclick="return confDel()">삭제</a></td>
	</tr>
<%		
	}
%>	
	</table>
	<div class="bttns">
		<input type="button" value="영화등록" onclick="addMovie()">
		<input type="button" value="고객등록(구현생략)" onclick="addWatcher()">
		<input type="button" value="예매하기" onclick="makeBooking()">
	</div>
	</div>
</section>
<footer>
	<h4>Copyright (C) 2018 정보처리산업기사 All Right Reserved</h4>
</footer>
</body>
<script type="text/javascript">
function addMovie() {
	location.href = "addMovie.do";
}
function addWatcher() {
	location.href = "addWatcher.do";
}
function makeBooking() {
	location.href = "makeBooking.do";
}
function confDel(){
	let str = "\n\n arg: ";
	if(! confirm("삭제하시겠습니까?"+str)) return false;
}
</script>
</html>