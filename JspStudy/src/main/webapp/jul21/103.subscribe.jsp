<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>103.subscribe.jsp</title>
</head>
<body>
<%
String agree = request.getParameter("AGREE");
String result = null;
if(agree.equals("YES")){//약관에 동의한 경우
	String id = (String)session.getAttribute("ID");
	String pwd = (String)session.getAttribute("PWD");
	String name = (String)session.getAttribute("NAME");
	System.out.println(id+", "+pwd+", "+name+"을 DB에 등록하여 회원정보 보관");
	result = "SUCCESS";//회원등록 성공을 의미
}else {//약관에 동의하지 않은 경우
	result = "FAIL";//회원등록 실패를 의미
}
//세션을 비활성화해서 세션에 저장된 데이터를 삭제한다
session.invalidate();
//회원가입 결과(성공or실패)를 보여주는 result.jsp로 화면 전환
//Redirect 방식이 정답!(Forward 방식은 회원등록 중복처리 할 수 있기 때문에)
response.sendRedirect("104.result.jsp?RE="+result);

%>
</body>
</html>