<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>itemInput.jsp</title>
</head>
<body>
<div align="center">
	<h2>상품 정보 등록</h2>
	<form action="putItem.do" method="post" onSubmit="return check(this)" name="itemFrm">
	<input type="hidden" name="codeChecked"/>
	<table>
	<tr><th>상품 번호</th>
		<td><input type="text" name="CODE" id="code"/>
			<input type="button" value="중복검사" onClick="codeCheck()"/></td></tr>
	<tr><th>상품 이름</th>
		<td><input type="text" name="NAME"/></td></tr>
	<tr><th>상품 가격</th>
		<td><input type="text" name="PRICE"/></td></tr>
	<tr><th>상품 정보</th>
		<td><textarea rows="4" cols="40" name="INFO"></textarea></td></tr>
	<tr><td colspan="2" align="center">
		<input type="submit" value="등록"/>
		<input type="reset" value="취소"/></td></tr>
	</table>	
	</form>
</div>
</body>
<script type="text/javascript">
function codeCheck(){
	if(document.itemFrm.CODE.value==''){
		alert("상품번호를 입력하세요."); return; //함수 종료
	}
	var url ="codeCheck.do?CODE=" + document.itemFrm.CODE.value;
	window.open(url,"상품중복검사","width=450, height=200, top=150, left=300");
}
function check(fm){
	if(fm.CODE.value == ''){ alert("상품 번호를 입력하세요."); return false;	}
	if(fm.codeChecked.value == ''){ alert("상품번호 중복검사를 해주세요."); return false;	}
	if(fm.NAME.value == ''){ alert("상품 이름을 입력하세요."); return false;	}
	if(fm.PRICE.value == ''){ alert("가격을 입력하세요."); return false;	}
	else{ if(isNaN(fm.PRICE.value)){ alert("가격은 숫자로 입력하세요."); return false;	} }
	if(fm.INFO.value == ''){ alert("상품 설명을 입력하세요."); return false;	}
	if(! confirm("입력한 내용이 맞습니까?")) return false;	
}
</script>
</html>