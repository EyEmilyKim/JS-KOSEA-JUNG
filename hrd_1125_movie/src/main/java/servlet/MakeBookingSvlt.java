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
import model.Booking;
import model.Movie;
import model.Watcher;

/**
 * Servlet implementation class MakeBookingSvlet
 */
@WebServlet("/makeBooking.do")
public class MakeBookingSvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeBookingSvlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBExpert dao = new DBExpert();
		ArrayList<Watcher> listW = (ArrayList) dao.getWatchers();
		ArrayList<Movie> listM = (ArrayList) dao.getMovies();
		ArrayList<Booking> listB = (ArrayList) dao.getBookings();
		request.setAttribute("ListW", listW);
		request.setAttribute("ListM", listM);
		request.setAttribute("ListB", listB);
		RequestDispatcher rd = request.getRequestDispatcher("addBooking.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
