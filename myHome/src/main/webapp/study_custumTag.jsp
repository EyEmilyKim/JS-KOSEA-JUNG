<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://bartag.taglib5.com" prefix="bar" %>    
<%@ taglib uri="http://random.taglib4.com" prefix="rand" %>    
   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>study_custumTag</title>
</head>
<body>
<div style="padding:20px;">
<h2>커스텀 태그 barChart 활용</h2>
<bar:Hbar values="7,4,12" fgcolor="blue" width="220" labels="Orange,Apple,Pear" bgcolor="skyblue"/>
<br/>
<bar:Vbar values="7,4,12" fgcolor="green" width="220" labels="Orange,Apple,Pear" bgcolor="orange"/>
<br/>
<h2>커스텀 태그 random 활용</h2>
<p>1~10사이 랜덤 숫자 : <u><rand:randomValue from="1" to="10"/></u></p>
<br/>
</div>
</body>
</html>