<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.td_btn { text-align:center; }
</style>
</head>
<body>
<div align="center">
<header>
<h2>쇼핑몰 회원관리 ver1.0</h2>
</header>
<menu>
<%@ include file="menu_header.jsp" %>
</menu>
<section>

<h2 align="center">홈쇼핑 회원 정보 수정</h2>
<br/>
<% 
	Member mem = (Member) request.getAttribute("MEM");
%>
<div>
<form action="memberUpdate.do?ID=<%=mem.getId()%>" method="post" onsubmit="return check(this)">
<br/>
<table border="1">
<tr><th>회원번호</th>
	<td><input type="text" name="ID" value="<%= mem.getId() %>" readonly="readonly"/></td></tr>
<tr><th>회원성명</th><td><input type="text" name="NAME" value="<%= mem.getName() %>"/></td></tr>
<tr><th>회원전화</th><td><input type="text" name="TEL" value="<%= mem.getTel() %>"/></td></tr>
<tr><th>회원주소</th><td><input type="text" name="ADDR" value="<%= mem.getAddr() %>"/></td></tr>
<tr><th>가입일자</th><td><input type="text" name="DATE" value="<%= mem.getDate() %>"/></td></tr>
<tr><th>고객등급 [A:VIP, B:일반, C:직원]</th>
	<td><input type="text" name="GRADE" value="<%= mem.getGrade() %>"/></td></tr>
<tr><th>도시코드</th><td><input type="text" name="CITY" value="<%= mem.getCity() %>"/></td></tr>
<tr><td colspan="2" class="td_btn">
<input type="submit" value="수정" name="btn"/>
<input type="button" value="뒤로" onClick="toHome()"/></td></tr>
</table>
<br/>
</form>
</div>

<br/>
</section>
<footer>
<h4>HRDKorea Copyright 2022. 과정평가형 시스템 작성</h4>
</footer>
</div>
</body>
<script type="text/javascript">
function toHome(){
	location.href = "memberSelect.do";
}
function check(frm){
	if(frm.NAME.value == ''){ alert("이름을 입력하세요."); return false; }
	if(frm.TEL.value == ''){ alert("전화번호를 입력하세요."); return false; }
	if(frm.ADDR.value == ''){ alert("주소를 입력하세요."); return false; }
	if(frm.DATE.value == ''){ alert("가입일을 선택하세요."); return false; }
	if(frm.GRADE.value == ''){ alert("고객등급을 입력하세요."); return false; }
	if(frm.CITY.value == ''){ alert("도시코드를 입력하세요."); return false; }
	if( ! confirm("수정하시겠습니까?")) return false;
}
</script>

</html>