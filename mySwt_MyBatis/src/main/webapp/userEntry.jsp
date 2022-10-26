<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2>회원 정보 입력</h2>
<form action="entryMember.do" method="post" name="fr"
		onSubmit="return check(this)">
<input type="hidden" name="idChecked"/>
이 름 : <input type="text" name="NAME" /><br/>
계 정 : <input type="text" name="ID" id="ID"/>
<input type="button" value="중복 검사" 
		onClick="idCheck()"/><br/>
주 소 : <input type="text" name="ADDR"/><br/>
연락처 : <input type="text" name="TEL"/><br/>
암 호 : <input type="password" name="PWD"/><br/>
암호 확인 : <input type="password" name="CONF"/><br/>
성 별 : 남<input type="radio" name="GENDER" value="M"/>,
	여<input type="radio" name="GENDER" value="F"/><br/>
이메일 : <input type="text" name="EMAIL" /><br/>
직 업 : <select name="JOB">
	<option>--선택하세요--</option><option>학생</option>
	<option>회사원</option><option>기타</option>
		</select><br/><br/>
<input type="submit" value="회원 가입"/>
<input type="reset" value="취 소"/>
</form>
</div>
<script type="text/javascript">
function idCheck(){
	if(document.fr.ID.value == ""){
		alert("계정을 입력하세요."); return;
	}
	var url="idCheck.do?USER_ID="+document.fr.ID.value;
	window.open(url,"_blank_","width=450,height=250");
}
function check(frm){
	if(frm.NAME.value == ""){
		alert("이름을 입력하세요."); return false;
	}
	if(frm.ID.value == ""){
		alert("계정을 입력하세요."); return false;
	}
	if(frm.idChecked.value == ""){
		alert("계정 중복검사를 해주세요."); return false;
	}
	if(frm.TEL.value == ""){
		alert("연락처를 입력하세요."); return false;
	}
	if(frm.PWD.value == ""){
		alert("암호를 입력하세요."); return false;
	}
	if(frm.PWD.value != frm.CONF.value){
		alert("암호가 일치하지 않습니다."); return false;
	}
	if( ! frm.GENDER[0].checked && 
			! frm.GENDER[1].checked){
		alert("성별을 선택하세요."); return false;
	}
	if(frm.JOB.selectedIndex < 1){
		alert("직업을 선택하세요."); return false;
	}
	if( ! confirm("가입하시겠습니까?")) return false;
}
</script>
</body>
</html>









