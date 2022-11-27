package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.DBExpert;
import model.Movie;

/**
 * Servlet implementation class InsertMovieSvlt
 */
@WebServlet("/insertMovie.do")
public class InsertMovieSvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMovieSvlt() {
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
		String m_id = request.getParameter("M_ID");
		String title = request.getParameter("TITLE");
		String o_date = request.getParameter("O_DATE");
		String start = request.getParameter("START");
		String end = request.getParameter("END");
		Movie mv = new Movie();
		mv.setId(m_id);
		mv.setTitle(title);
		mv.setOpen_date(o_date);
		mv.setStartHr(start);
		mv.setEndHr(end);
		DBExpert dao = new DBExpert();
		boolean flag = dao.insertMovie(mv);
		String target = "addMovieResult.jsp?R=";
		if(flag) target +="OK";
		else target +="NOK";
		response.sendRedirect(target);	
	}

}
