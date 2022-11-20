package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.DBExpert;
import model.Book;
import model.Writer;

/**
 * Servlet implementation class BookInsertServlet
 */
@WebServlet("/bookInsert.do")
public class BookInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookInsertServlet() {
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
		String id = request.getParameter("ID");
		String name = request.getParameter("NAME");
		String writer = request.getParameter("WRITER");
		String publisher = request.getParameter("PUB");
		String price = request.getParameter("PRICE");
		String p_date = request.getParameter("P_DATE");
		Book bk = new Book();
		bk.setId(id);
		bk.setName(name);
		bk.setPublisher(publisher);
		bk.setPrice(Integer.parseInt(price));
		bk.setP_date(p_date);
		bk.setWriter(writer);
		DBExpert crud = new crud.DBExpert();
		boolean flag = crud.insertBook(bk);
		String rslt = "";
		if(flag == true) rslt = "OK"; 
		else rslt = "NOK";
		response.sendRedirect("bookAddResult.jsp?R="+rslt);
	}

}
