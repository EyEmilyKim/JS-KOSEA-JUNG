<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
table {
	width:90%; height:80%; border:1px solid blue;
	border-collapse: collapse;
	margin-left: 20px; margin-right:20px;
	background-color: skyblue;
}
#menu {
	margin-top:10px; margin-bottom:10px;
	margin-left:10px; margin-right:10px;
	border:1px dashed green;
	background-color: orange;
}
.main{
	width:40%; height:300px; border:1px solid red;
}
#content{
	background-color:wheat;
}
#login {
	margin-left:10px; margin-top:10px;
	width:90%; border:1px dashed red;
	background-color:pink;
}
</style>
</head>
<body onload="startClock()">
<script type="text/javascript">
function workingClock(){
	var days=["일","월","화","수","목","금","토"];
	var today = new Date();
	var year = today.getFullYear();
	var month = today.getMonth() + 1;
	if(month < 10) month = "0"+month;
	var date = today.getDate();
	if(date < 10) date = "0"+date;
	var index = today.getDay();
	var day = days[index];
	var hour = today.getHours();
	var min = today.getMinutes();
	if(min < 10) min = "0"+ min;
	var sec = today.getSeconds();
	if(sec < 10) sec = "0"+sec;
	var time=year+"-"+month+"-"+date+" "+day+" "+
			hour+":"+min+":"+sec;
	document.getElementById("clock").innerHTML=time;
}
function startClock(){
	setInterval(workingClock,1000);
}
</script>
<header>
 <h2 align="center"><img alt="" src="logo.gif"
 	id="main_image"></h2>
</header>
<section>
	<table id="body">
		<tr>
			<td class="main">
				<div id="login">
					<c:choose>
						<c:when test="${sessionScope.USERID == null &&
							sessionScope.MANAGER == null }">
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
					<a href="bbsList.do">■ 게시글 목록</a><br/>
					<c:if test="${sessionScope.MANAGER != null }">
						<a href="template.jsp?BODY=noticeInput.jsp">■ 공지사항 작성</a><br/>
					</c:if>
					<a href="noticeList.do">■ 공지사항 목록</a><br/>
					<c:if test="${sessionScope.MANAGER != null }">
						<a href="template.jsp?BODY=itemInput.jsp">■ 상품 등록</a><br/>
					</c:if>
					<a href="itemList.do">■ 상품 목록</a><br/>
					<c:if test="${sessionScope.USERID != null }">
						<a href="cartList.do">■ 장바구니 보기</a><br/>
						<a href="template.jsp?BODY=imageForm.jsp">■ 이미지 게시글 작성</a><br/>
						<a href="imageList.do">■ 이미지 게시글 목록</a><br/>
					</c:if>
				</div>
			</td>
			<td id="content">
				<jsp:include page="${param.BODY }"/>
			</td>
		</tr>
	</table>
</section>
<footer>
	<h3 align="center">CopyRight 2022. MyHome. 
	<span id="clock"></span></h3>
</footer>
</body>
</html>








