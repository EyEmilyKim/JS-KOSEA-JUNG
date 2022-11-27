package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.DBExpert;
import model.Booking;

/**
 * Servlet implementation class DeleteBookingSvlt
 */
@WebServlet("/deleteBooking.do")
public class DeleteBookingSvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBookingSvlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m_id = request.getParameter("MID");
		String w_no = request.getParameter("WNO");
		String r_date = request.getParameter("RDATE");
		Booking bk = new Booking();
		bk.setM_id(m_id);
		bk.setW_no(w_no);
		bk.setR_date(r_date);
		DBExpert dao = new DBExpert();
		boolean flag = dao.deleteBooking(bk);
		String target = "deleteBookingResult.jsp?R=";
		if(flag) target +="OK";
		else target +="NOK";
		response.sendRedirect(target);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
