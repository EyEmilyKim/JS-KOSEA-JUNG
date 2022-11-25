<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>test_JS List Param</p>
<p>javascript 파라미터로 배열객체를 전달할 수 있을까?<br/> 
> 응 안돼. 알고 있었으면서~~ ^^. 흑ㅠ <br/>
> json 라이브러리 가져와서 나중에 연습해보기 ! </p>
<%
	String[] list = {"test1", "test2", "test3"};
	for(String temp : list){
		System.out.println(temp);
	}
	
	
%>
<button onclick="doTest(<%=list%>)">doTest()</button>
</body>
<script type="text/javascript">
function doTest(list) {
	alert("doTest() called");
	alert("list[1] : "+list[1] );
	alert("list[2] : "+list[2] );
	alert("list[3] : "+list[3] );
}
</script>
</html>