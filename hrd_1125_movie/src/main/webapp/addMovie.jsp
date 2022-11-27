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
	<h2>영화 정보 등록</h2>
</header>
<section>
	<div align="center">
	<form action="insertMovie.do" id="fm" method="post" onSubmit="return check(this)">
<%
	ArrayList<Movie> list = (ArrayList) request.getAttribute("LIST");
	String lastId = (String) request.getAttribute("LAST");
%>
	<input type="hidden" name="DUPID" id="dupId" value="nok">
	<table border="1" >
	<tr><th>영화번호</th>
		<td><input type="text" name="M_ID" id="m_id" placeholder="마지막 영화번호 : <%=lastId%>"
					onChange="checkDupId(this.value)"></td></tr>
	<tr><th>영화제목</th>
		<td><input type="text" name="TITLE"></td></tr>
	<tr><th>상영일</th>
		<td><input type="text" name="O_DATE" placeholder="yyyymmdd"></td></tr>
	<tr><th>시작시간</th>
		<td><input type="text" name="START" placeholder="hhmm"></td></tr>
	<tr><th>종료시간</th>
		<td><input type="text" name="END" placeholder="hhmm"></td></tr>
		
	</table>
	<div class="bttns">
		<input type="submit" value="영화 등록">
	</div>
	</form>
	</div>
</section>
<footer>
	<h4>Copyright (C) 2018 정보처리산업기사 All Right Reserved</h4>
</footer>
</body>
<script type="text/javascript">
function checkDupId(arg){
// 	alert("영화번호 변경됨"+"\n\narg : "+arg);
	let url = "dupCheckMovie.do?ID="+arg;
	window.open(url, "중복확인", "width=450 height=200");
}
function check(fm) {
// 	alert("check() called");
	const dupId = fm.DUPID.value;
	const m_id = fm.M_ID.value;
	let str = "\n\n현재 영화번호: "+m_id;
// 	alert("dubId : "+dupId);
	if(dupId != "OK"){ 
		alert("사용가능한 영화번호를 입력해주세요."+str); 
		return false; }
	if(! confirm("등록하시겠습니까?"+str)) return false;
}
</script>
</html>