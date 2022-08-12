package aug08;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class Calculator {

//aug09> TicketProcessDoServlet 내부로 이동.	
//	//티켓값 계산하는 메서드(>aug09)
//	int ticketCalc(String age, int num) {
//		int price = 0;
//		switch(age) {
//			case "청소년": price=7000; break;
//			case "성인": price=10000; break;
//			case "노인": price=5000; break;
//			}
//			int total = price * num; 
//			return total;
//		}	
		
	
	
	Calculator(){}//생성자
	//커피값 계산하는 메서드(리턴), 계산결과는 정수(int)
	int calculate(String coffee, int numInt) {
		int price = 0;
		switch(coffee) {
		case "A": price = 1500; break; //아메리카노(1.5$)
		case "B": price = 2500; break; //카푸치노(2.5$)
		case "C": price = 3000; break; //카페모카(3.0$)
		case "D": price = 3500; break; //카페라떼(3.5$)
		}	
		return price * numInt;
	}
	
}

@WebServlet("/coffeeOrder.do")
public class CoffeeOrderDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CoffeeOrderDoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String coffee = request.getParameter("NAME");
		String number = request.getParameter("NUM");
		int numInt = Integer.parseInt(number);
		Calculator c = new Calculator();
		int total = c.calculate(coffee, numInt);
		//total에 있는 총액을 결과JSP(coffeeResult.jsp)로 전환 
		//=> Redirect, Forward 둘다 OK.
		response.sendRedirect("template.jsp?BODY=603.coffeeResult.jsp?TOTAL="+total);
	}
//	int findTotal(String coffee, int numInt){
//		int price = 0; //음료수 가격을 위한 변수
//		switch(coffee){
//		//음료수 메뉴판 $가 아니라 ￦로 변경!
//		case "A": price = 1500; break; //아메리카노(1.5$)
//		case "B": price = 2500; break; //카푸치노(2.5$)
//		case "C": price = 3000; break; //카페모카(3.0$)
//		case "D": price = 3500; break; //카페라떼(3.5$)
//		}	
//		return price * numInt;
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
