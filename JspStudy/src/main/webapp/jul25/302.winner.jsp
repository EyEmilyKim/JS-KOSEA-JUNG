<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>302.winner</title>
</head>
<body>
<div align="center">
<h2>당첨자 명단</h2>
<%-- 1등 : ${WIN[0] } <br/> --%>
<%-- 2등 : ${WIN[1] } <br/> --%>
<%-- 3등 : ${WIN[2] } <br/> --%>

<!-- EL 표기 정확하게는 아래처럼 해야 한다 -->
<!-- 위처럼 출처가 되는 객체 생략해도 출력이 되긴 되는데,  -->
<!-- 없으면 컴파일러가 대문자 WIN을 알아서 찾아오기 때문. -->
<!-- (우선순위: requestScope -> sessionScope) -->
<!-- (requestScope, sessionScope 둘다 없으면 버그남:미출력) -->
${requestScope.WIN[0] }<br/>
${requestScope.WIN[1] }<br/>
${requestScope.WIN[2] }<br/>

<h2>상품 명단</h2>
1등: ${sessionScope.WIN[0] }<br/> 
2등: ${sessionScope.WIN[1] }<br/>  
3등: ${sessionScope.WIN[2] }<br/>  
</div>
</body>
</html>