<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>study2</title>
</head>
<body>
<div align="center">
<form action="loginProcess.jsp" method="post" onSubmit="return ﻿check()" name="FRM">
<p>계정과 암호를 입력하고, 로그인 버튼을 누르세요.</p>
계 정 : <input type="text" name="ID" size="5"/><br/>
암 호 : <input type="password" name="PWD" size="5"/><br/><br/>
<input type="submit" value="로그인"/>
<input type="reset" value="취 소"/>
</form>
</div>
<script type="text/javascript">
function check(){//ID와 PWD에 데이터 누락 여부 검사
	if(document.FRM.ID.value==''){
		alert("계정을 입력하세요.");
		return false;
	}else if(document.FRM.PWD.value==''){
		alert("비밀번호를 입력하세요.");
		return false;
	}
	var r = confirm("입력한 내용이 맞습니까?");
	if(r) return true;
	else return false;
}
</script>
</body>
</html>