<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeDetail.jsp</title>
</head>
<body>
<div align="center">
<c:if test="${empty N }">
	<h3>존재하지 않는 공지글입니다.</h3>
</c:if>
<c:if test="${ ! empty N }">
	<h3>공지글 상세보기</h3>
	<form action="modifyNotice.do" method="post" onSubmit="return check(this)">
	<table width="100%">
		<tr><th>글번호</th>
			<td><input type="text" name="SEQ" value="${N.seqno }" readOnly="readonly"/></td></tr>
		<tr><th>제 목</th>
			<td><input type="text" name="TITLE" value="${N.title }" /></td></tr>
		<tr><th>작성자</th>
			<td><input type="text" name="WRITER" value="${N.writer }" readOnly="readonly"/></td></tr>
		<tr><th>작성일</th>
			<td><input type="text" name="DATE" value="${N.reg_date }" readOnly="readonly"/></td></tr>
		<tr><th>내 용</th>
			<td><textarea rows="5" cols="40" name="CONTENT">${N.content }</textarea></td></tr>
		<c:if test="${ ! empty sessionScope.MANAGER }">
		<tr><td colspan="2" align="center">
			<input type="submit" value="삭제" name="BTN"/> 	
			<input type="submit" value="수정" name="BTN"/> 	
			<input type="reset" value="취소" name="BTN"/>	</td></tr>
		</c:if>
	</table>
	</form>
</c:if>
</div>
</body>
<script type="text/javascript">
function check(fm){
	if(fm.TITLE.value == ''){ alert("제목을 입력하세요"); return false;}
	if(fm.CONTENT.value == ''){ alert("내용을 입력하세요"); return false;}
	if( ! confirm("작업을 진행하시겠습니까?")) return false;
}
</script>
</html>