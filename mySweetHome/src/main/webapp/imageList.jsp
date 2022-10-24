<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>imageList.jsp</title>
</head>
<body>
<div align="center">
<c:if test="${IMGLIST == null }">
	<h3>등록된 게시글이 존재하지 않습니다.</h3> 
</c:if>
<c:if test="${IMGLIST != null }">
	<table width="100%" align="center">
		<tr><td align="right"># ${STRTROW } ~ ${ENDROW } / ${TOTAL }</td></tr>
	</table> 
	<table>
		<tr><th>이미지</th><th>제 목</th><th>작성자</th>
			<th>작성일</th></tr>
	<c:forEach items="${IMGLIST }" var="bbs">
		<tr><td><img alt="" src="upload/${bbs.image_name }" width="50" height="50"></td>	
			<td><a href="javascript:goDetail(${bbs.seqno })">${bbs.title }</a></td>
			<td>${bbs.id}</td><td>${bbs.reg_date}</td>
	</c:forEach>	
	</table>
	
	<c:set var="startPage" value="${currentPage-(currentPage%10==0 ? 10 : (currentPage%10))+1 }"/>
	<c:set var="endPage" value="${startPage+9 }"/>
	<c:if test="${endPage > PAGES }">
		<c:set var="endPage" value="${PAGES }"/>
	</c:if>
	<c:if test="${startPage > 10 }">
		<a href="javascript:goPage(${startPage -1 })">[이전]</a>
	</c:if>
	<c:forEach begin="${startPage }" end="${endPage }" var="page">
		<c:if test="${currentPage == page }">
			<font size="6">
		</c:if>
		<a href="imageList.do?PAGE=${page }">${page }</a>
		<c:if test="${currentPage == page }">
			</font>
		</c:if>
	</c:forEach>	
	<c:if test="${endPage < PAGES }">
		<a href="javascript:goPage(${endPage +1 })">[다음]</a>
	</c:if>
</c:if>
</div>
<form name="move" method="post">
<input type="hidden" name="pid"/>
<input type="hidden" name="PAGE"/>
</form>
</body>
<script type="text/javascript">
function goPage(page){
	document.move.action = "imageList.do?PAGE="+page;
	document.move.PAGE.value = page;
	document.move.submit();
}
function goDetail(id){
	document.move.action = "imageRead.do";
	document.move.pid.value = id;
	document.move.submit();
}
</script>
</html>