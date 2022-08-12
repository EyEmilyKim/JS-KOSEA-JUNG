package aug09;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class Calculator {
	
	//티켓값 계산하는 메서드(>aug09)
	int ticketCalc(String age, int num) {
		int price = 0;
		switch(age) {
			case "청소년": price=7000; break;
			case "성인": price=10000; break;
			case "노인": price=5000; break;
			}
			int total = price * num; 
			return total;
		}
}

@WebServlet("/ticketProcess.do")
public class TicketProcessDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TicketProcessDoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String age = request.getParameter("AGE");
		String num = request.getParameter("NUM");
		int numInt = Integer.parseInt(num);
//		int total = getTotal(age, numInt); 
		Calculator cal = new Calculator();
		int total = cal.ticketCalc(age, numInt);
		
		request.setAttribute("AGE", age);
		request.setAttribute("NUM", numInt);
		request.setAttribute("TOTAL", total);
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?BODY=1003.ticketResult.jsp");
		rd.forward(request, response);
	}
//	int getTotal(String a, int n){
//		int price = 0;
//		switch(a){
//		case "청소년": price=7000; break;
//		case "성인": price=10000; break;
//		case "노인": price=5000; break;
//		}
//		int total = price * n; 
//		return total;
//	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
