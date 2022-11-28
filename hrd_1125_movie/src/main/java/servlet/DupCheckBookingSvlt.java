package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.DBExpert;
import model.Booking;

/**
 * Servlet implementation class DupCheckMovieSvlt
 */
@WebServlet("/dupCheckBooking.do")
public class DupCheckBookingSvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DupCheckBookingSvlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String w_no = request.getParameter("WNO");
		String m_id = request.getParameter("MID");
		DBExpert dao = new DBExpert();
		ArrayList<Booking> list = (ArrayList) dao.getBookings();
		String flag = "OK";
		for(Booking bk : list) {
			if(bk.getW_no().equals(w_no)) {
				if(bk.getM_id().equals(m_id)) {
					flag = "NOK"; 
				}
			}
		}
		System.out.println("flag : "+flag);
		String target = "dupCheckBookingResult.jsp?R="+flag;
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
