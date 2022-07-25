<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>102.operator.jsp</title>
</head>
<body>
X = ${param.N1 }, Y=${param.N2 }<br/>
X + Y = ${param.N1 + param.N2 }<br/>
X - Y = ${param.N1 - param.N2 }<br/>
X * Y = ${param.N1 * param.N2 }<br/>
X / Y = ${param.N1 / param.N2 }<br/>
X % Y = ${param.N1 % param.N2 }<br/>
X가 더 큽니까? ${param.N1 - param.N2 > 0 }<br/>
Y가 더 큽니까? ${param.N2 - param.N1 > 0 }<br/>
X, Y  모두 양수입니까? ${(param.N1 > 0) && (param.N2 > 0) }<br/>
X와 Y가 같습니까? ${param.N1 == param.N2 ? "예":"아니오" }<br/>
</body>
</html>