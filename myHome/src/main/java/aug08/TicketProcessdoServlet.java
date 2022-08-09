package aug08;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TicketProcessdoServlet
 */
@WebServlet("/ticketProcess.do")
public class TicketProcessdoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketProcessdoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String age = request.getParameter("AGE");
		String num = request.getParameter("NUM");
		int numInt = Integer.parseInt(num);
		int total = getTotal(age, numInt); 
		String ageS = getAge(age);
		request.setAttribute("AGE", ageS);
		request.setAttribute("NUM", numInt);
		request.setAttribute("TOTAL", total);
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?BODY=1003.ticketResult.jsp");
		rd.forward(request, response);
	}
	int getTotal(String a, int n){
		int price = 0;
		switch(a){
		case "T": price=7000; break;
		case "A": price=10000; break;
		case "S": price=5000; break;
		}
		int total = price * n; 
		return total;
	}
	String getAge(String a) {
		String ageS = null;
		switch(a){
		case "T": ageS="청소년"; break;
		case "A": ageS="성인"; break;
		case "S": ageS="노인"; break;
		}
		return ageS;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
