<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>itemDetail.jsp</title>
</head>
<body>
<div align="center">
<h2>상품 상세 정보</h2>
<form action="itemModify.do" method="post" onSubmit="return check(this)">
<table width="100%">
	<tr><th>상품 번호</th><td>
		<input type="text" name="CODE" value="${ITEM.code }" readOnly="readOnly"/></td></tr>
	<tr><th>상품 이름</th><td>
		<input type="text" name="NAME" value="${ITEM.name }"/></td></tr>
	<tr><th>상품 가격</th><td>
		<input type="text" name="PRICE" value="${ITEM.price }" >
		<%-- <fmt:formatNumber groupingUsed="true"> ${ITEM.price }</fmt:formatNumber> --%>원</td></tr>
	<tr><th>등록일</th><td>${ITEM.reg_date }</td></tr>
	<tr><th>설 명</th>
		<td><textarea rows="5" cols="40" name="INFO">${ITEM.info }</textarea></td></tr>
	<c:if test="${sessionScope.MANAGER != null }">	
	<tr><td colspan="2" align="center">
		<input type="submit" value="수정" name="BTN"/>
		<input type="submit" value="삭제" name="BTN"/></td></tr>	
	</c:if>
</table>
</form>
</div>
</body>
<script type="text/javascript">
function check(fmI){
	if(fmI.NAME.value == ''){ alert("상품 이름을 입력하세요."); return false; }
	if(fmI.PRICE.value == ''){ alert("상품 가격을 입력하세요."); return false; }
	else { if(isNaN(fmI.PRICE.value)){ alert("상품 가격을 숫자로 입력하세요."); return false; } }
	if(frm.INFO.value == ''){ alert("상품 설명을 입력하세요."); return false; }
	if( ! confirm("작업을 진행하시겠습니까?") ) return false;
}
</script>
</html>