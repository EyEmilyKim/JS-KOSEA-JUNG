package servlet;

import java.io.IOException;

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
		String id = (String) request.getAttribute("ID");
		String name = (String) request.getAttribute("NAME");
		String writer = (String) request.getAttribute("WRITER");
		String publisher= (String) request.getAttribute("PUB");
		Integer price = (Integer) request.getAttribute("PRICE");
		String p_date = (String) request.getAttribute("P_DATE");
		Book bk = new Book();
		bk.setId(id);
		bk.setName(name);
		bk.setPublisher(publisher);
		bk.setPrice(price);
		bk.setP_date(p_date);
		bk.setWriter(writer);
		DBExpert crud = new crud.DBExpert();
		boolean flag1 = crud.insertBook(bk);
		boolean flag2 = crud.insertBW(id, writer);
		
	}

}
