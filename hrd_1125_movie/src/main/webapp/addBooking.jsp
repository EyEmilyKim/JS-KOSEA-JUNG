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
	.bttns {display:auto; margin: 10px 0px;}
	.left {text-align:left; margin:10px 60px;}
	.right {text-align:right; margin:10px 60px;}
	#submitBtn, #resetBtn {display:none; }
</style>
</head>
<body>
<header>
	<h2>예매 정보 등록</h2>
</header>
<section>
	
<%
	ArrayList<Watcher> listW = (ArrayList) request.getAttribute("ListW");
	ArrayList<Movie> listM = (ArrayList) request.getAttribute("ListM");
%>
	<div align="center">
	<form action="insertBooking.do" id="fm" method="post" onSubmit="return check(this)">
	<input type="text" value="nok" name="DUPBK" id="dupBk">
	<table border="1" >
	<tr><th>고객번호</th>
		<td><select name="W_NO" id="w_no">
<%
	for(Watcher wr : listW){
%>
	<option value="<%=wr.getNo()%>"><%=wr.getNo()%> : <%=wr.getName()%></option>
<%		
	}
%>
			</select></td></tr>
	<tr><th>영화번호</th>
		<td><select name="M_ID" id="m_id">
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
	</table>
	<div class="bttns">
		<input type="button" value="예매 중복확인" onClick="check()">
		<input type="button" value="예매 등록" onClick="check()" id="submitBtn">
		<input type="reset" value="취 소" id="resetBtn">
	</div>
	</form>
	</div>
</section>
<footer>
	<h4>Copyright (C) 2018 정보처리산업기사 All Right Reserved</h4>
</footer>
</body>
<script type="text/javascript">
function check() {
	alert("check() called");
	//중복체크 : 기존 예매와 동일 고객번호 && 동일 영화번호 시 alert 기능 필요
	const w_no = document.getElementById("w_no").value;
	const m_id = document.getElementById("m_id").value;
	alert("w_no : "+w_no+" , m_id : "+m_id);
	checkDupBk(w_no,m_id);
	//중복체크 끝.
	confSub();
}
function checkDupBk(w_no,m_id){
	alert("checkDupBk(w_no,m_id) called");
	const url = "dupCheckBooking.do?WNO="+w_no+"&MID="+m_id;
	window.open(url, "중복확인", "width=450 height=200")
}
function confSub(){
	alert("confSub() called");
	const dupBk = document.getElementById("dupBk").value;
	alert("\n\ndupBk : "+dupBk);
	if(dupBk == "OK"){
		alert("dupBk : "+dupBk);
// 		if(confirm("등록하시겠습니까?")){
// 			document.getElementById("fm").submit();
// 		} 
	}	
}
</script>
</html>