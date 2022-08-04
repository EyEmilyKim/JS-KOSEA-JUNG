<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>study_jstl3</title>
</head>
<body>
<fmt:setBundle basename="intro"/>
<fmt:message var="title" key="TITLE"/>
<fmt:message var="greeting" key="GREETING"/>
<fmt:message var="body" key="BODY"/>
<fmt:message var="footer" key="FOOTER"/>

<div align="center">
<h2>${title }</h2>
<h3>${greeting }</h3>
<p>${body }</p>
<h3>${footer }</h3>
</div>
</body>
</html>