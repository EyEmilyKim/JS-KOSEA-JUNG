<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>302.coffeeLoginProcess</title>
</head>
<body>
<%
String id = request.getParameter("ID");
String pw = request.getParameter("PW");
if(id.equals("")||pw.equals("")){
	out.print("ID/PW 입력을 확인해주세요");
}else if(id.equals(pw)){//로그인 성공
	session.setAttribute("LOGIN", id);//세션에 데이터를 저장
%>
<script type="text/javascript">
	alert("로그인 되었습니다.");
	location.href = "303.coffeeHome.jsp";
</script>
<%
}else{//로그인 실패
	out.print("로그인 되지 않았습니다.");	
}
%>
</body>
</html>