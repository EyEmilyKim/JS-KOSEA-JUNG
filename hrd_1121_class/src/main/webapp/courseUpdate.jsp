<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	header, section, footer {border: 1px solid gray; text-align:center; }
	th {text-align:center; padding:3px 10px;}
	td {text-align:left; padding:3px 10px;}
	.left {text-align:left; margin:10px 60px;}
	.right {text-align:right; margin:10px 60px;}
	.btns {text-align:center; margin:20px;}
	
</style>
</head>
<body>
<header>
	<h2>수강신청 도우미 사이트</h2>
</header>
<section>
	<div align="center">
	<div class="center"><h3>교과목 수정</h3></div>
<%
	Course crs = (Course) request.getAttribute("COURSE");
%>	
	<form action="courseUpdate.do" method="post" onsubmit="return check(this);">
	<table border="1" width="600px">
	<tr><th>과목코드</th>
		<td><input type="text" name="ID" value="<%=crs.getId()%>" size="60"></td>
	<tr><th>과목명</th>
		<td><input type="text" name="NAME" value="<%=crs.getName()%>" size="60"></td>
	<tr><th>담당강사</th>
		<td><select name="TR_IDX">
			<option value="NoId">--담당강사 선택--</option>
<%
	ArrayList<Lecturer> list = (ArrayList) request.getAttribute("LIST");
	String ctr_idx = crs.getLecturer_idx();
	for(Lecturer ltr : list){
		if(ltr.getIdx()==Integer.parseInt(ctr_idx)){
%>	
			<option value="<%=ltr.getIdx()%>" selected="selected"><%=ltr.getName()%></option>
<% 
		}else {
%>
			<option value="<%=ltr.getIdx()%>"><%=ltr.getName()%></option>
<%
		}
	}	
%>

			</select></td>
	<tr><th>학점</th>
		<td><input type="text" name="CREDIT" value="<%=crs.getCredit()%>" size="60"></td>
	<tr><th>요일</th>
		<td>
<%
	Integer week_n = crs.getWeek_n();
	String[] weeks = {"월","화","수","목","금","토"};
	for(int i=1; i<7; i++){
		if(i == week_n){
%>	
			<input type="radio" name="WEEK" value="<%=i%>" checked="checked"><%=weeks[i-1]%>   
<%		
		}else{
%>
			<input type="radio" name="WEEK" value="<%=i%>"><%=weeks[i-1]%> 
<%		
		}
	}
%>
		</td>
	<tr><th>시작시간</th>
		<td><input type="text" name="START" value="<%=crs.getStart_hour()%>" size="60" placeholder="0000(hhmm)"></td>
	<tr><th>종료시간</th>
		<td><input type="text" name="END" value="<%=crs.getEnd_hour()%>" size="60" placeholder="0000(hhmm)"></td>
	
	</table>
	<div class="btns">
		<input type="button" value="목록" onClick="toList()">
		<input type="button" value="취소" onClick="reset(<%=crs.getId()%>)">
		<input type="submit" value="완료">
	</div>
	</form>
	</div>
</section>
<footer>
	<h4>Copyright (C) 2018 정보처리산업기사 All Right Reserved</h4>
</footer>
</body>
<script type="text/javascript">
function check(fm){
	let name = fm.NAME.value;
	let str = "\n\n과목명 : "+name;
	if(! confirm("저장하시겠습니까?"+str)) return false;
}
function toList(){
	location.href = "courseList.do";
}
function reset(id){
	location.href = "courseModify.do?ID="+id;
}
</script>
</html>