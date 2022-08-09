package aug08;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CoffeeOrderDoServlet
 */
@WebServlet("/coffeeOrder.do")
public class CoffeeOrderDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoffeeOrderDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String coffee = request.getParameter("NAME");
		String number = request.getParameter("NUM");
		int numInt = Integer.parseInt(number);
		
		int total = findTotal(coffee, numInt);
		//total에 있는 총액을 결과JSP(coffeeResult.jsp)로 전환 
		//=> Redirect, Forward 둘다 OK.
		response.sendRedirect("template.jsp?BODY=603.coffeeResult.jsp?TOTAL="+total);
	}
	int findTotal(String coffee, int numInt){
		int price = 0; //음료수 가격을 위한 변수
		switch(coffee){
		//음료수 메뉴판 $가 아니라 ￦로 변경!
		case "A": price = 1500; break; //아메리카노(1.5$)
		case "B": price = 2500; break; //카푸치노(2.5$)
		case "C": price = 3000; break; //카페모카(3.0$)
		case "D": price = 3500; break; //카페라떼(3.5$)
		}	
		return price * numInt;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
