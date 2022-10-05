<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>template</title>
<style type="text/css">
	table {
		width:90%; height:80%; border:1px solid blue;
		border-collapse: collapse;
		margin-left: 20px; margin-right: 20px;
		background-color: #F5F5F5;
	}
	#login {
		text-align: center;
		margin: 10px; padding: 10px;
		border: 1px dashed green;
		background-color: yellow;
	}
	#menu {
		margin-top:10px; margin-bottom: 10px; margin-left:10px; margin-right:10px;
		padding: 20px;
		border:1px dashed green;
		background-color: gold;
	}
	.main{
		width:40%; height: 300px; border:1px solid red;
	}
	#content { background-color:wheat; }
</style>
</head>
<body onload="startClock()">
<script type="text/javascript">
function workingClock(){
	let days = ["일","월","화","수","목","금","토"];
	let today = new Date();
	let year = today.getFullYear();
	let month = today.getMonth() + 1;
	if(month < 10) month = "0"+month;
	let date = today.getDate();
	if(date < 10) date = "0"+date;
	let index = today.getDay();
	let day = days[index];
	let hour = today.getHours();
	let min = today.getMinutes();
	if(min < 10) min = "0"+min;
	let sec = today.getSeconds();
	if(sec < 10) sec = "0"+sec;
	let time = year+"-"+month+"-"+date+" "+day+" "+hour+":"+min+":"+sec;
	document.getElementById("clock").innerHTML = time;
}
function startClock(){
	workingClock();
	setInterval(workingClock,1000);//(함수이름,시간간격). 시간간격 1000=1초
}
</script>
<header>
	<h2 align="center"><img alt="" src="logo.gif" id="main_image"></h2>
</header>
<section>
	<table id="body">
		<tr>
			<td class="main">
				<div id="login">
					<c:choose>
					<c:when test="${sessionScope.USERID == null && sessionScope.MANAGER == null}">
						<jsp:include page="login.jsp"/>
					</c:when>
					<c:otherwise>
						<jsp:include page="logout.jsp"/>
					</c:otherwise>
					</c:choose>
				</div>
				<div id="menu">
					<a href="template.jsp?BODY=intro.jsp">■ 소개</a><br/>
				<c:if test="${sessionScope.USERID != null }">
					<a href="template.jsp?BODY=bbsInput.jsp">■ 게시글 작성</a><br/>
				</c:if>
					<a href="">■ 게시글 목록</a><br/>
				<c:if test="${sessionScope.MANAGER != null }">
					<a href="">■ 공지사항 작성</a><br/>
				</c:if>
					<a href="getAllNotice.do">■ 공지사항 목록</a><br/>
					<a href="">■ 상품 등록</a><br/>
					<a href="">■ 상품 목록</a><br/>
					<a href="">■ 장바구니 보기</a><br/>
					<a href="">■ 이미지 게시글 작성</a><br/>
					<a href="">■ 이미지 게시글 목록</a><br/>
				</div>
			</td >
			<td id="content">
				<jsp:include page="${param.BODY }"/>
			</td>
		</tr>
	</table>
</section>
<footer>
	<h5 align="center">Copyright 2022.MyHome. 
	<span id="clock"></span></h5>
</footer>
</body>
</html>