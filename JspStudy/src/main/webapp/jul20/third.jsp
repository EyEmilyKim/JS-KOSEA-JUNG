<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>third.jsp</title>
</head>
<body>
third 페이지 입니다.<br/><br/>

---------<br/>
위 URL bar 를 보면 third.jsp 를 볼 수 있을 것이다.<br/>
이렇게 url 을 명시하며 페이지가 바뀌는 방식은 Redirect라 할 수 있다.<br/>
response.메서드 사용<br/><br/>

그에 비해 Forward 를 사용하면 브라우저 URL bar에 second.jsp를 보여줄 것이다.<br/>
forward 방식은 굉장히 많이 쓰이며, 게시판 조회 등도 대부분 forward 이다.<br/>
RequestDispatcher rd = request.getRequestDispatcher("바뀔 페이지");<br/>
rd.forward(request, response);<br/>
</body>
</html>