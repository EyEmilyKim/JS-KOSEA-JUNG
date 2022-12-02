<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제3과제 화면구현</title>
<style type="text/css">
	.menu_ul {list-style-type: none; display: flex; }
	li { margin: 0 5px;}
	.title { border-bottom: solid 1px; gray; }
	.ul2 {list-style-type: circle; }
	.box {border: solid blue 1px; margin: 10px; padding: 10px;}
}
</style>
</head>
<body>
<div class="container">
<div class="menu">
	<ul class="menu_ul">
		<li>수목원 소개 │</li>
		<li>방문안내 │</li>
		<li>관람안내 │</li>
		<li>개인/단체 체험 │</li>
		<li>고객센터 │</li>
		<li>공지사항 │</li>
	</ul>
</div>
<div class="img">
	<img alt="" src="main.jpg" width="100%">
</div>
<div class="title">
	<h2>+ 방문안내</h2>
</div>
<div class="text1">
	<h3>1.이용요금</h3>
	<div class="box">
		평일 : 8,000원<br/>
		주말/공휴일 : 10,000원
	</div>
</div>
<div class="text2">
	<h3>2.교통안내</h3>
	<ul class="ul2">
		<li>버스 : 터미널(서울 또는 지방 터미널 등)에서 출발하여 양평 터미널 도착</li>
		<li>지하철 : 용산역 또는 청량리역에서 출발하여 용문역 도착</li>
		<li>택시 : 양평 터미널이나 용문역에서 택시 이용</li>
	</ul>
</div>
<div class="text3">
	<h3>3.관람 유의사항</h3>
	<div class="box">
		※ 수목원은 자연과 더불어 사는 우리 인간에게 매우 소중한 존재입니다.<br/>
		식물이나 시설을 훼손하거나 타인에게 방해가 되는 행동은 삼가시기 바랍니다.<br/>
		방문해주신 모든 분께 감사드립니다.^^
	</div>
</div>
</div>
</body>
</html>