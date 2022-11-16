<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<h2>홈쇼핑 회원 등록</h2>
<div>
<form action="memberRegister.do" method="post" onsubmit="return check(this)">
<br/>
<table>
<tr><th>회원번호(자동발생)</th>
	<td><input type="text" name="ID" value="${maxId}" readonly="readonly"/></td></tr>
<tr><th>회원성명</th><td><input type="text" name="NAME"/></td></tr>
<tr><th>회원전화</th><td><input type="text" name="TEL"/></td></tr>
<tr><th>회원주소</th><td><input type="text" name="ADDR"/></td></tr>
<tr><th>가입일자</th><td><input type="text" name="DATE"/></td></tr>
<tr><th>고객등급 [A:VIP, B:일반, C:일반]</th>
	<td><input type="text" name="GRADE"/></td></tr>
<tr><th>도시코드</th><td><input type="text" name="CITY"/></td></tr>
<tr><td colspan="2" class="td_btn">
<input type="submit" value="등록" name="btn"/>
<input type="submit" value="조회" name="btn"/></td></tr>
</table>
<br/>
</form>
</div>

</section>
<footer>
<h3>HRDKorea Copyright 2022. 과정평가형 시스템 작성</h3>
</footer>
</div>
<script type="text/javascript">
function check(frm){
	if(frm.NAME.value == ''){ alert("이름을 입력하세요."); return false; }
	if(frm.TEL.value == ''){ alert("전화번호를 입력하세요."); return false; }
	if(frm.ADDR.value == ''){ alert("주소를 입력하세요."); return false; }
	if(frm.DATE.value == ''){ alert("가입일을 선택하세요."); return false; }
	if(frm.GRADE.value == ''){ alert("고객등급을 입력하세요."); return false; }
	if(frm.CITY.value == ''){ alert("도시코드를 입력하세요."); return false; }
	if( ! confirm("가입하시겠습니까?")) return false;
}
</script>
</body>
</html>