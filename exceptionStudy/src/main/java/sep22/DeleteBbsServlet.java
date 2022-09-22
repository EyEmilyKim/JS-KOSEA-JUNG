package sep22;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sep21.DBExpert;

/**
 * Servlet implementation class DeleteBbsServlet
 */
@WebServlet("/deleteBBS.do")
public class DeleteBbsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBbsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("ID");
		//id에 있는 글번호를 조건으로 DB 삭제 작업을 한다.
		DBExpert dbe = new DBExpert();
		boolean result = dbe.deleteBBS(Integer.parseInt(id));
		if(result) {//삭제 성공한 경우
			response.sendRedirect("deleteResult.jsp?R=Y");
		}else {//삭제 실패한 경우
			response.sendRedirect("deleteResult.jsp?R=N");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
