<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>404.penaltyProcess</title>
</head>
<body>
<%
//파라미터를 불러온다
String dir = request.getParameter("DIR");
int com = (int)(Math.random()*5+1);
int gamer = Integer.parseInt(dir);
String result = "<div align='center'><font color='blue' size='5'>";
if(com == gamer){//방향이 같으므로 no goal
	result = result + "노~~~ 골~~~~";
}else{//방향이 다르므로 goal in
	result = result + "골~~~ 인~~~~";
}
result = result + "</font></div>";
out.print(result);
%>
<div align="center">
<form action="401.penaltyLogin.jsp" onSubmit="logout()">
<input type="submit" value="로그아웃"/>
<script type="text/javascript">
function logout(){
<%
	session.invalidate();
%>	
}
</script>
</form>
</div>
</body>
</html>