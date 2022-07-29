<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>matjipProcess</title>
</head>
<body>
<%
	//파라미터(AREA)에 들어있는 지역 이름을 찾는다.
	String area = request.getParameter("AREA");
	//name에 들어있는 지역 이름으로 맛집을 찾는다.
	String[] areas = {"종로구","성동구","강동구","강서구","강남구","강북구","송파구","성북구","서초구"};
	int index = 0; //지역 이름의 위치가 저장될 변수
	for(int i=0; i<areas.length; i++){//areas배열을 반복한다
		if(area.equals(areas[i])){
			index = i;
			break;
		}
	}
	String[][] matjips = {
			{"종로김밥","종로면옥","종로일식","종로루"},
			{"성동전집","성동주막","성동일가","성동횟집","성동짬뽕"},
			{"강동면옥","강동비빔밥","강동고깃집","강동회관","한강동막"},
			{"강서해장국","강서탕면","스시강서"},
			{"강남대장","강남덖볶이","강남파스타","강남돈까스"},
			{"강북루","강북한식","강북분식"},
			{"송파리즘","송파면옥","송파한식","송파함바그"},
			{"성북나라","성복일가","성북양식","복집성북"},
			{"서초한식","서초일식","서초보나라","꼬꼬서초","맥시서초",}
	};
%>
</body>
</html>