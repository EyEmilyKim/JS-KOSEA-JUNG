package aug05;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/makeDate.do")
public class MakeDateDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MakeDateDoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String area = request.getParameter("AREA");
		Date today = new Date();
		//showDate.jsp로 전환 => Forward
		request.setAttribute("AREA", area);
		request.setAttribute("TODAY", today);
		RequestDispatcher r = request.getRequestDispatcher("template.jsp?BODY=803.showDate.jsp");
		r.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
