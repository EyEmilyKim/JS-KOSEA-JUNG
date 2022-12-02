package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.DBExpert;
import model.Book;
import model.Reservation;

/**
 * Servlet implementation class InsertReservServlet
 */
@WebServlet("/insertReserv.do")
public class InsertReservServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertReservServlet() {
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
		String lentno_str = request.getParameter("LENTNO");
		String custname = request.getParameter("CUSTNAME");
		String bookno = request.getParameter("BOOKNO");
		String outdate = request.getParameter("OUTDATE");
		Reservation rsv = new Reservation();
		rsv.setLentno_str(lentno_str);
		rsv.setCustname(custname);
		rsv.setBookno(bookno);
		rsv.setOutdate(outdate);
		DBExpert dao = new DBExpert();
		Boolean flag = dao.insertReserv(rsv);
		String target = "addReservResult.jsp?R=";
		if(flag) target += "OK";
		else target += "NOK";
		response.sendRedirect(target);
	}

}
