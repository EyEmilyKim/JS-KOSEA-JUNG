<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table>    
<tr>
<td width="160"><a href="entryMemberForm.do">♠ 회원등록</a></td>
<td width="270"><a href="getAllMember.do">♠ 회원목록조회/수정</a></td>
<td width="200"><a href="getTotalOutput.do">♠ 회원매출조회</a></td>
<td width="200"><a href="index.jsp">♠ 홈으로</a></td>

<td width="160">
	<c:if test="${sessionScope.LOGIN_ID == null }">
		<a href="login.jsp">■ 로그인</a></br>
	</c:if>
	<c:if test="${sessionScope.LOGIN_ID != null }">
		<font color ="red">환영합니다~ ${sessionScope.LOGIN_ID }님</font></br>
		<a href="logout.jsp">■ 로그아웃</a>
	</c:if>	
	</td>
</tr>
</table>