<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>study1</title>
</head>
<body>
<%
//문자열 비교
String str1 = "KOREA";
String str2 = "KOREA";
String str3 = new String("KOREA");
out.print(str1+", "+str2+", "+str3+"<br/>");
if(str1==str2){
	out.print("str1 과 str2 는 같다.<br/>");	
}else{
	out.print("str1 과 str2 는 같지 않다.<br/>");
}

if(str1==str3){
	out.print("str1 과 str3 는 같다.<br/>");	
}else{
	out.print("str1 과 str3 는 같지 않다.<br/><br/>");
}
//if ( == ) 를 사용하는 경우 문자열의 메모리상 위치를 비교한다.
//문자열의 값을 비교할 경우 switch 비교문을 사용할 수 있다.

//if를 사용해서 문자열의 내용이 같은지를 비교할 경우
//비교연산자(==)가 아니라 String객체 메서드 equals를 사용해야 한다!

//문자열 "내용" 비교
if(str1.equals(str2)){
	out.print("str1 과 str2 는 내용이 같다.<br/>");	
}else{
	out.print("str1 과 str2 는 내용이 같지 않다.<br/>");	
}

if(str1.equals(str3)){
	out.print("str1 과 str3 는 내용이 같다.<br/>");	
}else{
	out.print("str1 과 str3 는 내용이 같지 않다.<br/>");	
}

if(str2.equals(str1)){
	out.print("str2 과 str1 는 내용이 같다.<br/>");	
}else{
	out.print("str2 과 str1 는 내용이 같지 않다.<br/>");	
}

if(str1.equals("KOREA")){
	out.print("str1 과 KOREA 는 내용이 같다.<br/>");	
}else{
	out.print("str1 과 KOREA 는 내용이 같지 않다.<br/>");	
}

if("KOREA".equals(str1)){
	out.print("KOREA 과/와 str1 는 내용이 같다.<br/>");	
}else{
	out.print("KOREA 과/와 str1 는 내용이 같지 않다.<br/>");	
}

/* ((실험)) */
str2 = "korea";
out.print("<br/>/*    */<br/>"+str1+", "+str2+", "+str3+"<br/>");
if(str1==str2){
	out.print("str1 과 str2 는 같다.<br/>");	
}else{
	out.print("str1 과 str2 는 같지 않다.<br/>");
}
if(str1.equals(str2)){
	out.print("str1 과 str2 는 내용이 같다.<br/>");	
}else{
	out.print("str1 과 str2 는 내용이 같지 않다.<br/>");	
}
%>
</body>
</html>