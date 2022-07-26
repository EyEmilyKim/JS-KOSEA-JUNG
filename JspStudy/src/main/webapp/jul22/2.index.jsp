<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2.Index</title>
</head>
<body>
<header>
<h2 align="center">종합 관리 시스템</h2>
</header>
<section>
<table align="center" style="witdh:100%; 
	border:2px solid blue; vertical-align:top;">
<tr>
	<td style="width:190px; height:300px; border:2px solid red; vertical-align:top; padding:15px;">
	<fieldset><!-- 메뉴 영역 -->
	<c:choose>
		<c:when test="${empty sessionScope.MEMBER}">
			<jsp:include page="201.login.jsp"/>
		</c:when>
		<c:otherwise>
			<jsp:include page="205.logout.jsp"/>
		</c:otherwise>
	</c:choose>
	</fieldset>
	<a href="2.index.jsp">■ HOME</a><br/>
	<a href="2.index.jsp?BODY=401.coffeeHome.jsp">■ 커피주문</a><br/>
	<a href="2.index.jsp?BODY=301.busReservation.jsp">■ 버스예매</a><br/>
	</td>
	<td style="width:650px; border:2px solid green; padding:15px;"><!-- 전환될 페이지 영역 -->
	<c:choose>
		<c:when test="${empty param.BODY}">
			모든게 그대를 우울하게 만드는 날이면<br/>
			이 노래를 불러보게<br/>
			아직은 가슴에 불꽃이 남은 그대여<br/>
			지지말고 싸워주게 Hey Hey Hey Hey Hey<br/>
			라라라라- 후회는 저 하늘에 날리고<br/>
			라라라라라라라라- 친구여 새롭게 태어나게<br/>
			비굴한 인생은 그대에게는 어울리지 않는다네<br/>
			당당히 고개를 들게 친구여 지금이 시작이라네<br/>
			라라라라- 마음에 가득히 꽃피우고<br/>
			라라라라라라라라- 친구여 마음껏 웃어보게<br/>
			하!하하!하하!하!하하!하하<br/>
			하!하하!하하!하!하하!하하<br/>
			빛나는 그대 두 눈동자속에 푸른 바다가 있네<br/>
			파도의 노래를 듣게 친구여 마음이 부르는 그 노래<br/>
		</c:when>
		<c:otherwise>
			<jsp:include page="${param.BODY}"/>
		</c:otherwise>
	</c:choose>
	</td>
</tr>
</table>
</section>
<footer>
	all right reserved. 2022
</footer>
</body>
</html>