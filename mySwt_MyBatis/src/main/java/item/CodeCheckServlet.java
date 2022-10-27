package item;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.Crud;

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
		//code�� ����� ��ǰ��ȣ�� DB���� ��ǰ��ȣ�� �˻��Ѵ�.
		Crud crud = new Crud();
		String selectedCode = crud.getCode(code);
		request.setAttribute("CODE", code);
		request.setAttribute("DUP", selectedCode);
		RequestDispatcher rd = 
			request.getRequestDispatcher("codeCheck.jsp");
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
