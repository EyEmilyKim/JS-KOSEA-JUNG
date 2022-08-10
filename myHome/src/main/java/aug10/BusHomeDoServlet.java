package aug10;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BusHomeDoServlet
 */
@WebServlet("/busHome.do")
public class BusHomeDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusHomeDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//서블릿에서 session 객체를 등록
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("LOGINID");
		if(id == null) {//로그인 안 한 경우
			response.sendRedirect("template.jsp?BODY=401.login.jsp?M=Y");
		}else {//로그인 한 경우
			String[] destinations = {"대전","강릉","광주","대구","부산"};
			int[] price = {25000,28000,30000,30000,40000};
			request.setAttribute("DESTI", destinations);
			request.setAttribute("PRICE", price);
			request.setAttribute("LENGTH", destinations.length);
			RequestDispatcher r = request.getRequestDispatcher("template.jsp?BODY=701.busHome.jsp");
			r.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
