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
<c:choose>
	<c:when test="${param.R == 'true' }">
		<script type="text/javascript">
			alert("�������� �����Ǿ����ϴ�.");
		</script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
	alert("�������� �������� �ʾҽ��ϴ�. �����ڿ��� �����ϼ���.");
		</script>
	</c:otherwise>
</c:choose>
<script type="text/javascript">
	location.href="noticeList.do";//������ ������� ��ȯ
</script>
</body>
</html>








