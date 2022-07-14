<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>study4</title>
</head>
<body>
<div align="center">
<h2>표준 체중 측정기 ver1.0</h2>
<p>본인의 신장과 체중을 입력하고 버튼을 누르면 표준 체중 여부가 출력됩니다.</p>
<form action="measure.jsp">
신장 <input type="text" name="HEIGHT" size="5"/>(cm),
체중 <input type="text" name="WEIGHT" size="5"/>(kg)<br/>
성별: 남 <input type="radio" name="GENDER" value="1"/>, 
 여 <input type="radio" name="GENDER" value="2"/><br/>
<input type="submit" value="계 산"/> 
<input type="reset" value="초기화"/> 
</form>
</div> 
</body>
</html>