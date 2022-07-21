<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>102.agreement.jsp</title>
</head>
<body>
<%
//파라미터 한글처리 
request.setCharacterEncoding("UTF-8");
//파라미터를 수신한다(ID, PWD, NAME)
String id = request.getParameter("ID");
String pwd = request.getParameter("PWD");
String name = request.getParameter("NAME");
//수신한 데이터를 세션에 저장한다. WHY? 상태유지를 위해서.
session.setAttribute("ID", id);
session.setAttribute("PWD", pwd);
session.setAttribute("NAME", name);
%>
<h2>약 관</h2>
---------------------------------------------------------------<br/>
1. 회원 정보는 웹사이트의 운영을 위해서만 사용합니다.<br/>
2. 웹 사이트의 정상 운영을 방해하는 회원은 탈퇴 처리합니다.<br/>
3. 숭그리당당 숭당당 수그수그당당 숭당당<br/>
4. 김 수한무 두루미와 거북이<br/>
---------------------------------------------------------------<br/>
<form action="103.subscribe.jsp" method="post">
위 약관에 동의하십니까?
<input type="radio" name="AGREE" value="YES"> 동의함 
<input type="radio" name="AGREE" value="NO"> 동의하지 않음
<input type="submit" value="확 인"/>
</form>
</body>
</html>