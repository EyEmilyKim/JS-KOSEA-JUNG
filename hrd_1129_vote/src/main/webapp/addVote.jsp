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
	th, td {padding:0 10px;}
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
	<h3>투표하기</h3>
	<div class="contents" align="center">
	<form action="insertVote.do" method="post" onSubmit="return check(this)">
	<table border="1">
	<tr><th>주민번호</th>
		<td><input type="text" name="V_JUMIN">
			 예 : 8906153154726</td></tr>
	<tr><th>성명</th>
		<td><input type="text" name="V_NAME"></td></tr>
	<tr><th>후보번호</th>
		<td><select name="M_NO">
			<option value=''>--선택--</option>
<%
	ArrayList<Member> list = (ArrayList)request.getAttribute("LIST");
	for(Member mem : list){
%>	
			<option value="<%=mem.getM_no()%>">
				[<%=mem.getM_no()%>] <%=mem.getM_name()%></option>
<%		
	}
%>			
			</select>
	<tr><th>투표시간</th>
		<td><input type="text" name="V_TIME" placeholder="hhmm"></td></tr>
	<tr><th>투표장소</th>
		<td><input type="text" name="V_AREA" placeholder="제X투표장"></td></tr>
	<tr><th>유권자확인</th>
		<td><input type="radio" name="V_CONF" value="Y"> 확인 
			<input type="radio" name="V_CONF" value="N" checked="checked"> 미확인 </td></tr>
	<tr><td colspan="2" align="center">
		<input type="submit" value="투표하기">		
		<input type="reset" value="다시하기"></td></tr>		
	</table>
	</form>
	</div>
</section>
<footer>
	<h4>HRDKorea Copyright@2015 All rights reserved. 2022.11.29 Developed by EyKim</h4>
</footer>
</body>
<script type="text/javascript">
function check(fm) {
// 	alert("check() called");
	const v_jumin = fm.V_JUMIN.value;
	const v_name = fm.V_NAME.value;
	const m_no = fm.M_NO.value;
	const v_time = fm.V_TIME.value;
	const v_area = fm.V_AREA.value;
	const v_conf = fm.V_CONF.value;
	let str = "\n\nv_jumin : "+v_jumin+" / v_name : "+v_name+" / m_no : "+m_no+
				"\n / v_time : "+v_time+" / v_area : "+v_area+" / v_conf : "+v_conf;
	if(v_jumin == ''){
		alert("주민번호가 입력되지 않았습니다!"); return false; }
	if(v_name == ''){
		alert("성명이 입력되지 않았습니다!"); return false; }
	if(m_no == ''){
		alert("후보번호가 입력되지 않았습니다!"); return false; }
	if(v_time == ''){
		alert("투표시간이 입력되지 않았습니다!"); return false; }
	if(v_area == ''){
		alert("투표장소가 입력되지 않았습니다!"); return false; }
	if(v_conf != 'Y'){
		alert("유권자확인이 선택되지 않았습니다!"); return false; }
	if(! confirm("투표를 등록하시겠습니까?"+str)) return false;
}
</script>
</html>