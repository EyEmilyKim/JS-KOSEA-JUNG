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
<c:if test="${DETAIL == null }">
	<h3>�������� �ʴ� ���Դϴ�.</h3>
</c:if>
<c:if test="${DETAIL != null }">
<table width="100%">
<tr><th width="300px">�� ��</th><td>${DETAIL.title }</td></tr>
<tr><th width="200px">�ۼ���</th><td>${DETAIL.id }</td></tr>
<tr><td colspan="2" align="center"><img alt="" width="250" height="250" 
	src="upload/${DETAIL.image_name}"></td></tr>
<tr><th width="200px">�ۼ���</th><td>${DETAIL.reg_date }</td></tr>
<tr><th width="300px">�� ��</th><td><textarea rows="4" 
	cols="50">${DETAIL.content }</textarea></td></tr>
<tr><td colspan="2" align="center">
	<a href="javascript:goReply()">[���]</a>
	<a href="javascript:goModify()">[����]</a>
	<a href="javascript:goDelete()">[����]</a>
	<a href="imageList.do">[���]</a></td></tr>
</table>
</c:if>
</div>
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
<form name="move" method="post" >
	<input type="hidden" name="id" value="${DETAIL.seqno }"/>
	<input type="hidden" name="parentid"
						value="${DETAIL.seqno }"/>
	<input type="hidden" name="groupid"
						value="${DETAIL.group_id }"/>
</form>
</body>
</html>










