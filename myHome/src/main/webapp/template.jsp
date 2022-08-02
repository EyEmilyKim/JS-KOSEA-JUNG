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
			<%-- <%
				String man = (String)session.getAttribute("MANAGER");
				String login_id = (String)session.getAttribute("LOGINID");
				if( (man != null)||(login_id != null) ){//man 이나 login_id 중 하나라도 있는 경우(로그인 성공)
				%>	 --%>
			<c:set var="man" value="${sessionScope.MANAGER }"/>	
			<c:set var="id" value="${sessionScope.LOGINID }"/>	
			<c:choose>
				<c:when test="${! empty man || ! empty id }">
					<jsp:include page="404.logout.jsp"/>
				</c:when>
				<c:otherwise>
					<jsp:include page="401.login.jsp"/>
				</c:otherwise>
			</c:choose> 
<%-- 					<jsp:include page="404.logout.jsp"/>
			<%	}else { %>
					<jsp:include page="401.login.jsp"/>
			<%	}  %> --%>
			
				</div>
				<div id="menu">
					<a href="template.jsp?BODY=201.intro.jsp">■ 소개</a><br/>
					<a href="template.jsp?BODY=301.gababoHome.jsp">■ 가위바위보 게임</a><br/>
					<a href="template.jsp?BODY=101.beerHome.jsp">■ 맥주추천</a><br/>
					<a href="template.jsp?BODY=500.matjipMake.jsp">■ 맛집추천</a><br/>
					<a href="template.jsp?BODY=601.coffeeHome.jsp">■ 커피주문</a><br/>
					<a href="700.busMake.jsp">■ 버스예매</a><br/>
					<a href="template.jsp?BODY=">■ 공지사항 보기</a><br/>
				<c:if test="${!empty man }">
					<a href="template.jsp?BODY=">■ 공지사항 쓰기</a><br/>
				</c:if>
<%-- 			<% 
					if(man!=null){
				%>
					<a href="template.jsp?BODY=">■ 공지사항 쓰기</a><br/>
				<%		
					}
				%> --%>
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