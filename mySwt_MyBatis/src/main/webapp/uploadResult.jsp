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
<c:if test="${param.R == 'Y' }">
	<script type="text/javascript">
		alert("�̹��� �Խñ��� ��ϵǾ����ϴ�.");
	</script>
</c:if>
<c:if test="${param.R == 'N' }">
	<script type="text/javascript">
		alert("�̹��� �Խñ��� ��ϵ��� �ʾҽ��ϴ�.");
	</script>
</c:if>
<script type="text/javascript">
	location.href = "template.jsp";
</script>
</body>
</html>









