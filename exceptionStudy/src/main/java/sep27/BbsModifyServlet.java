package sep27;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sep21.DBExpert;

/**
 * Servlet implementation class BbsModifyServlet
 */
@WebServlet("/bbsModify.do")
public class BbsModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BbsModifyServlet() {
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
		String btn = request.getParameter("BTN");
		String seqno = request.getParameter("NO"); //글번호
		DBExpert dbe = new DBExpert();
		if(btn.equals("삭제")) {
			boolean flag = dbe.deleteBBS(Integer.parseInt(seqno));
			if(flag) {//작업 성공인 경우
				response.sendRedirect("deleteResult.jsp?R=Y");
			}else {//작업 실패인 경우
				response.sendRedirect("deleteResult.jsp?R=N");
			}
		}else if(btn.equals("수정")) {
			
		}
	}

}
