<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>study4</title>
</head>
<body>
<%!
double calculate(double h, int g){
	double result = 0;
	switch(g){
	case 1:
		result = h * h * 22; break; //남자
	case 2:
		result = h * h * 21; break; //여자
	}
	return result ;
}
%>
<%
//표준체중 공식 - 
//남자: 신장(m)* 신장(m) * 22
//여자: 신장(m)* 신장(m) * 21
String height = request.getParameter("HEIGHT");
String weight = request.getParameter("WEIGHT");
String gender = request.getParameter("GENDER");
//문자열을 실수로 바꾼다
double h = Double.parseDouble(height);
h = h/100;
double w = Double.parseDouble(weight);
int g = Integer.parseInt(gender);
double result = calculate(h, g);
String html = "<font color='blue' size='5'>";
if(result == w){ 
	html = html + "당신은 표준 체중 입니다."; 
}else if(result > w){
	html = html + "당신은 저체중 입니다."; 
}else{
	html = html + "당신은 과체중 입니다."; 
}
html = html + " (표준체중 : "+result +" kg)</font>";
out.print(html);

/* 
if(result == w){
	out.print("당신은 표준체중!");
}else if(result > w){
	out.print("당신은 저체중!");
}else{
	out.print("당신은 과체중!");
} */

%>
</body>
</html>