<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<c:if test="${ empty NOTICE }">
	<h3>존재하지 않는 공지글입니다.</h3>
</c:if>
<c:if test="${ ! empty NOTICE }">
	<h3>공지글 상세보기</h3>
	<form action="modifyNotice.do" method="post"
			onSubmit="return check(this)">
	<table width="100%">
	<tr><th>글번호</th><td><input type="text" name="SEQ"
	value="${NOTICE.seqno}" readOnly="readonly"/></td></tr>
	<tr><th>제 목</th><td><input type="text" name="TITLE"
		value="${NOTICE.title }"/></td></tr>
	<tr><th>작성자</th><td><input type="text" name="WRITER"
	value="${NOTICE.writer}" readOnly="readonly"/></td></tr>
	<tr><th>작성일</th><td><input type="text" name="DATE"
	value="${NOTICE.reg_date}" readOnly="readonly"/></td></tr>
	<tr><th>내 용</th><td><textarea rows="5" cols="40"
	name="CONTENT">${NOTICE.content }</textarea></td></tr>
	<c:if test="${ ! empty sessionScope.MANAGER }">
	<tr><td colspan="2" align="center">
		<input type="submit" value="삭 제" name="BTN"/>
		<input type="submit" value="수 정" name="BTN"/>
		<input type="reset" value="취 소"/></td></tr>
	</c:if>
	</table>
	</form>
</c:if>
</div>
<script type="text/javascript">
function check(frm){
	if(frm.TITLE.value == ''){
		alert("제목을 입력하세요."); return false;
	}
	if(frm.CONTENT.value == ''){
		alert("내용을 입력하세요."); return false;
	}
	if( ! confirm("작업을 진행하시겠습니까?")) return false;
}
</script>
</body>
</html>










