package item;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.DAO;

/**
 * Servlet implementation class CodeCheckServlet
 */
@WebServlet("/codeCheck.do")
public class CodeCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CodeCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("CODE");
		//code에 저장된 상품번호로 DB에서 상품번호를 검색
		DAO dao = new DAO();
		String selectedCode = dao.getCode(code);
		request.setAttribute("CODE", code);	
		request.setAttribute("DUP", selectedCode);
		//JSP에서 DUP가 null이면, 사용가능
		//JSP에서 DUP가 null이 아니면, 사용중
		RequestDispatcher rd = request.getRequestDispatcher("codeCheck.jsp");
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
