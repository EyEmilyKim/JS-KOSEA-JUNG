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

/**
 * Servlet implementation class DupCheckMovieServlet
 */
@WebServlet("/dupCheckMovie.do")
public class DupCheckMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DupCheckMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newId = request.getParameter("ID");
		System.out.println("newId : "+newId);
		DBExpert dao = new DBExpert();
		ArrayList<String> list = dao.listMovieId();
		String flag = "OK";
		for(String pastId : list) {
			System.out.println("pastId : "+pastId);
			if(newId.equals(pastId)) { 
				flag = "NOK"; 
			}
		}
		System.out.println("flag : "+flag);
		String target = "dupCheckMovieResult.jsp?R="+flag;
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
