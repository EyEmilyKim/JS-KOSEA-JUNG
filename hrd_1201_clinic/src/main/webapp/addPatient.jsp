<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.* , java.util.* " %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	header, nav, section, footer {text-align:center; }
	th, td {text_align:left; padding:0 10px;}
	.btns {text_align:center; margin: 10px;}
</style>
</head>
<body>
<header>
<h4>환자 관리 시스템</h4>
</header>
<nav>
<%@ include file="menu_header.jsp" %>
</nav>
<section>
<div class="container">
<h3>환자 등록</h3>
<form action="insertPatient.do" method="post" onSubmit="return check(this)">
<table align="center" border="1">
	<tr><th>환자코드</th>
		<td><input type="text" name="P_CODE" placeholder="P000"></td></tr>
	<tr><th>환자이름</th>
		<td><input type="text" name="P_NAME"></td></tr>
	<tr><th>주소</th>
		<td><input type="text" name="ADDR"></td></tr>
	<tr><th>전화번호</th>
		<td><input type="text" name="TEL" placeholder="000-0000-0000"><br/> *신규환자 등록시 입력</td></tr>
	<tr><th>진료일</th>
		<td><input type="text" name="REG_DATE" placeholder="yyyy-mm-dd"></td></tr>
	<tr><th>진료과목/담당의사</th>
		<td><select name="COUR&DR">
			<option value="">---선택하세요---</option>
<%
	ArrayList<Course> list = (ArrayList)request.getAttribute("LIST");
	for(Course cour : list){
		String m_c = cour.getM_code();
		String m_t = cour.getM_title();
		String d_c = cour.getD_code();
		String d_n = cour.getD_name();
%>
			<option value="<%=cour.getM_code()%>/<%=cour.getD_code()%>">
			<%=cour.getM_title()%> / <%=cour.getD_name()%></option>
<%
	}
%>
			</select></td></tr>
	<tr><th>병실번호</th>
		<td><input type="text" name="ROOM" placeholder="H000"></td></tr>
</table>
<div class="btns">
	<input type="submit" value="등록"> 	
	<input type="reset" value="취소"> 	
</div>
</form>
</div>
</section>
<footer>
<h4>Copyright 2021 Kosea All Right Reserved. 2022.12.01 Developed by EyKim</h4>
</footer>
</body>
<script type="text/javascript">
function check(fm){
	if(! confirm("등록하시겠습니까?")) return false;
}
</script>
</html>