<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userEntry.jsp</title>
</head>
<body>
<div align="center">
<h2>회원정보 입력</h2>
<form action="" method="post" onSubmit="return check(this)" name="form">
<input type="hidden" name="idChecked"/>
이 름 : <input type="text" name="NAME" /><br/>
아이디 : <input type="text" name="ID" id="ID"/>
<input type="button" value="중복 검사" onClick="idCheck()"/><br/>
주 소 : <input type="text" name="ADDR"/><br/>
연락처 : <input type="text" name="TEL"/><br/>
암 호 : <input type="password" name="PWD"/><br/>
암호확인 : <input type="password" name="CONF"/><br/>
성 별 : 남<input type="radio" name="GENDER" value="M"/>,
	여<input type="radio" name="GENDER" value="F"/><br/>
이메일 : <input type="text" name="EMAIL"/><br/>
직 업 : <select name="JOB">
		<option>---선택하세요---</option>
		<option>학생</option><option>회사원</option><option>기타</option>
	</select><br/><br/>
<input type="submit" value="회원가입"/>	
<input type="reset" value="취 소"/>	
</form>
</div>
</body>
<script type="text/javascript">
function idCheck(){
	var entryId = document.form.ID.value;  
	if(entryId == ""){ alert("아이디를 입력하세요."); return; }
	//폼 이름 frm 으로 했더니 로그인 창의 frm 과 이름이 중복돼서 먹통됐었음.
	var url = "idCheck.do?USER_ID=" + entryId;
	window.open(url, "_blank_", "width=450 height=250" );	
}
function check(fm){
	if(fm.NAME.value == ""){ alert("이름을 입력하세요."); return false; }	
	if(fm.ID.value == ""){ alert("아이디를 입력하세요."); return false; }
	if(fm.idChecked.value == ""){ alert("아이디 중복검사를 해주세요."); return false; }
	if(fm.TEL.value == ""){ alert("연락처를 입력하세요."); return false; }
	if(fm.PWD.value == ""){ alert("암호를 입력하세요."); return false; }
	if(fm.PWD.value != fm.CONF.value){ alert("암호가 일치하지 않습니다."); return false; }
	if( ! fm.GENDER[0].checked && ! fm.GENDER[1].checked ){
		alert("성별을 선택하세요."); return false;
	}
	if(fm.JOB.selectedIndex < 1){ alert("직업을 선택하세요."); return false; }
	if( ! confirm("가입하시겠습니까?") ) return false;
}
</script>
</html>