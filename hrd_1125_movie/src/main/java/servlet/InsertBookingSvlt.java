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
 * Servlet implementation class InsertBookingSvlt
 */
@WebServlet("/insertBooking.do")
public class InsertBookingSvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBookingSvlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String w_no = request.getParameter("W_NO");
		String m_id = request.getParameter("M_ID"); 
		String tckt = request.getParameter("TCKT");
		String r_date = request.getParameter("R_DATE");
		System.out.println("w_no : "+w_no);
		System.out.println("m_id : "+m_id);
		Booking bk = new Booking();
		bk.setW_no(w_no);
		bk.setM_id(m_id);
		bk.setTickets(Integer.parseInt(tckt));
		bk.setR_date(r_date);
		DBExpert dao = new DBExpert();
		boolean flag = dao.insertBooking(bk);
		String target = "addBookingResult.jsp?R=";
		if(flag) target +="OK";
		else target +="NOK";
		response.sendRedirect(target);	
	}

}
