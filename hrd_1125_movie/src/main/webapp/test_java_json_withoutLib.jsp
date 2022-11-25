<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>test_java_json_withoutLib</p>
<pre>
[JAVA] 외부 라이브러리를 쓰지 않고 Json 파싱하기(ScriptEngine)
https://dreamingdreamer.tistory.com/126

연습용 Json객체를 받아올 수 있는 웹 사이트
https://swapi.dev/
스타워즈에 등장하는 인물정보를 받아올 수 있는 API
</pre>

<%
URL url = new URL("https://swapi.dev/api/people/1/");
HttpURLConnection conn = (HttpURLConnection) url.openConnection();
conn.setRequestMethod("GET");
conn.setRequestProperty("User-Agent", "Mozilla/5.0");
conn.setRequestProperty("Accept", "application/json");
conn.setDoInput(true);

// 상태코드 
// int responseCode = conn.getResponseCode();

BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}

in.close();
%>

</body>
</html>