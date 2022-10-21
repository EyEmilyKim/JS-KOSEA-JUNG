<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>imageDetail.jsp</title>
</head>
<body>
<div align="center">
<c:if test="${DETAIL == null }">
 	<h3>존재하지 않는 글입니다.</h3>
</c:if>
<c:if test="${DETAIL != null }">
 	<table width="100%">
 	<tr><th width="300px">제 목</th><td>${DETAIL.title }</td></tr>
 	<tr><th width="300px">작성자</th><td>${DETAIL.id }</td></tr>
 	<tr><td colspan="2" align="center"><img alt="" height="350" src="upload/${DETAIL.image_name}"></td></tr>
 	<tr><th width="200px">작성일</th><td>${DETAIL.reg_date }</td></tr>
 	<tr><th width="300px">내 용</th><td><textarea rows="4" cols="50">${DETAIL.content}</textarea></td></tr>
 	<tr><td colspan="2" align="center">
 		<a href="javascript:goReply()">[답글]</a>
 		<a href="javascript:goModify()">[수정]</a>
 		<a href="javascript:goDelete()">[삭제]</a>
 		<a href="imageList.do">[목록]</a></td></tr>
 	</table>
</c:if>
</div>
<form name="move" method="post">
	<input type="hidden" name="id" value="${DETAIL.seqno }"/>
	<input type="hidden" name="parentid" value="${DETAIL.seqno }"/>
	<input type="hidden" name="groupid" value="${DETAIL.group_id }"/>
</form>
</body>
<script type="text/javascript">
function goReply(){
	document.move.action="imageReply.do";
	document.move.submit();
}
function goDelete(){
	document.move.action="imageDelete.do";
	document.move.submit();
}
function goModify(){
	document.move.action="imageUpdate.do";
	document.move.submit();
}
</script>
</html>