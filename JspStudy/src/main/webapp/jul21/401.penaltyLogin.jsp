<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>401.penaltyLogin</title>
</head>
<body>
<div align="center">
<h2>((도전과제))승부차기 게임 로그인</h2>
<p>게임을 하려면 로그인 하세요</p>
<form action="402.penaltyLoginPro.jsp" method="post" name="frm" onSubmit="return check()">
계 정 : <input type="text" name="ID" size="10"/><br/> 
암 호 : <input type="password" name="PWD" size="10"/><br/><br/> 
<script type="text/javascript">
function check(){
	let id = document.frm.ID.value;
	let pwd = document.frm.PWD.value;
	let result = null;
	if((id=='')||(pwd='')){
		alert("ID/PW 입력을 확인해주세요");
		result = false;
	}else{
		result = true;
	}
	return result;
}
</script>
<input type="submit" value="로그인"/>
</form>
</div>
</body>
</html>