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
<c:if test="${IMGLIST == null }">
	<h3>등록된 게시글이 존재하지 않습니다.</h3>
</c:if>
<c:if test="${IMGLIST != null }">
<table width="100%">
	<tr><td align="right">${START } ~ ${END } / ${TOTAL }</td></tr>
</table>
<table>
	<tr><th>이미지</th><th>제 목</th><th>작성자</th>
		<th>작성일</th></tr>
	<c:forEach items="${IMGLIST }" var="bbs">
	<tr><td><img alt="" src="upload/${bbs.image_name }"
		width="50" height="50"></td>
		<td><a href="javascript:goDetail(${bbs.seqno })">${bbs.title }</a></td>
		<td>${bbs.id }</td>
		<td>${bbs.reg_date }</td></tr>
	</c:forEach>
</table>
<c:set var="startPage"
value="${currentPage-(currentPage%10==0 ? 10:(currentPage%10))+1}"/>
<c:set var="endPage" value="${startPage + 9 }"/>
<c:if test="${endPage > PAGES }">
	<c:set var="endPage" value="${PAGES }"/>
</c:if>
<c:if test="${startPage > 10 }">
	<a href="javascript:goPage(${startPage - 1 })">[이전]</a>
</c:if>
<c:forEach begin="${startPage }" end="${endPage}" var="page">
	<c:if test="${currentPage == page}">
		<font size="6">
	</c:if>
	<a href="imageList.do?PAGE=${page }">${page }</a>
	<c:if test="${currentPage == page}">
		</font>
	</c:if>
</c:forEach>
<c:if test="${endPage < PAGES}">
	<a href="javascript:goPage(${endPage + 1})">[다음]</a>
</c:if>

</c:if>
</div>
<form name="move" method="post">
	<input type="hidden" name="pid"/>
	<input type="hidden" name="PAGE"/>
</form>
<script type="text/javascript">
function goPage(no){
	document.move.action="imageList.do";
	document.move.PAGE.value=no;
	document.move.submit();
}
function goDetail(id){
	document.move.action="imageRead.do";
	document.move.pid.value = id;
	document.move.submit();
}
</script>
</body>
</html>









