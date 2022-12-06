<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.* , java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	header, section, footer {text-align: center; } 
	nav {text-align: left; background-color:skyblue; color:white; padding:10px; }
	.main {align-content: center; padding: 10px;}
	th {text-align:center; padding: 0px 30px;}
	td {text-align:left; padding: 0px 30px 0 0;}
 	.center {text-align: center; padding: 0 5px;} 
</style>
</head>
<body>
<header>
	<h3>(과정평가형 정보처리산업기사)물류창고 입출고 프로그램</h3>
</header>
<nav>
<%@ include file="menu_header.jsp" %>
</nav>
<section>
	<div align="center">
	<h3>입출고 등록</h3>
	<div class="main">
	<form action="insertInout.do" method="post" onSubmit="return check(this)">
	<table border="1">
<%
	String lastTno = (String) request.getAttribute("LASTTNO");
	Integer newTno = Integer.parseInt(lastTno)+1;
%>	
	<tr><th>입출고번호</th>
		<td><input type="text" name="TNO" value="<%=newTno%>">
			예)20200006</td></tr>
	<tr><th>제품코드</th>
		<td><input type="text" name="PCODE" id="pcode"></td></tr>
	<tr><th>입출고구분</th>
		<td><input type="radio" value="I" name="TTYPE" checked="checked">입고 
			<input type="radio" value="O" name="TTYPE">출고 </td></tr>
	<tr><th>수량</th>
		<td><input type="text" name="TCNT"></td></tr>
	<tr><th>거래일자</th>
		<td><input type="text" name="TDATE" placeholder="yyyymmdd"></td></tr>
	<tr><th>거래처</th>
		<td><select name="CCODE">
			<option value="">거래처명</option>
<%
	ArrayList<Company> list = (ArrayList) request.getAttribute("LIST");
	for(Company cmp : list){
%>
			<option value="<%=cmp.getC_code()%>">[<%=cmp.getC_code().trim()%>]<%=cmp.getC_name()%></option>
<%
	}
%>
			</select></td></tr>
	<tr><td colspan="2" class="center">
		<input type="submit" value="입출고등록">
		<input type="reset" value="다시쓰기" onclick="focusTo()"></td></tr>
	</table>
	</form>
	</div>
	</div>
</section>
<footer>
	<h4>HRDKOREA Copyrightⓒ2020 All right reserved. Human Resources Development Service of Korea</h4>
</footer>
</body>
<script type="text/javascript">
function check(fm) {
	const tno = fm.TNO.value;
	const pcode = fm.PCODE.value;
	const ttype = fm.TTYPE.value;
	const tcnt = fm.TCNT.value;
	const tdate = fm.TDATE.value;
	const ccode = fm.CCODE.value;
	
	if(pcode == ''){
		alert("제품코드가 입력되지 않았습니다!"); 
		document.getElementById("pcode").focus(); //포커스를 제품코드 항목으로 이동
		return false;	}
	if(tcnt == ''){
		alert("수량이 입력되지 않았습니다!"); return false;	}
	if(tdate == ''){
		alert("거래일자가 입력되지 않았습니다!"); return false;	}
	if(ccode == ''){
		alert("거래처가 선택되지 않았습니다!"); 	return false;	}
	if(!confirm("등록하시겠습니까?")) return false;
}
function focusTo(){
	document.getElementById("pcode").focus(); //포커스를 제품코드 항목으로 이동
}
</script>
</html>