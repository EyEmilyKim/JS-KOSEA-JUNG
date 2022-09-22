package sep22;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sep21.BBS;
import sep21.DBExpert;

/**
 * Servlet implementation class UpdateBbsServlet
 */
@WebServlet("/updateBBS.do")
public class UpdateBbsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBbsServlet() {
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
		String title = request.getParameter("TITLE");
		String content = request.getParameter("CONTENT");
		//위의 파라미터 정보를 DTO에 저장한다.
		BBS bbs = new BBS();
		bbs.setSeqno(Integer.parseInt(id)); 
		bbs.setTitle(title);
		bbs.setContent(content);
		//DB 쿼리 실행
		DBExpert dbe = new DBExpert();
		boolean result = dbe.updateBBS(bbs);
		//결과 페이지로 전환
		if (result) {
			response.sendRedirect("updateResult.jsp?R=Y");
		}else {
			response.sendRedirect("updateResult.jsp?R=N");
		}
	}

}
