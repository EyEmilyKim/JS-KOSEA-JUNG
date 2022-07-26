<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jul25.*" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>401.study4</title>
</head>
<body>
<%
	//상품5개를 위한 배열을 선언한다
	Item[] items = new Item[5];
	items[0] = new Item("A100","LED TV",1000000);
	items[1] = new Item("A200","대형 냉장고",90000);
	items[2] = new Item("A300","소형 세탁기",80000);
	items[3] = new Item("A400","대형 공기청정기",70000);
	items[4] = new Item("A500","대형 에어컨",90000);
// 	items[0] = new Item();
// 	items[0].code = "A100";//첫번째 상품의 코드
// 	items[0].name = "LED TB";
// 	items[0].price = 10000000;

// 	for(int i=0; i<items.length; i++){
// 		out.print(i+"번째 상품 번호 : "+items[i].code+" / 이름 : "
// 					+items[i].name+" / 가격 : "+items[i].price+"<br/>");
// 	}

	//itemList.jsp로 화면을 전환해서 상품의 목록을 출력한다.
	//items배열을 itemList.jsp로 전달한다.
	//Redirect? Forward? 둘 다 가능?  --> 정답: Forward만 가능!
	request.setAttribute("ITEMS", items);
	RequestDispatcher rd = request.getRequestDispatcher("402.itemList_2.jsp");
	rd.forward(request, response);
%>
</body>
</html>