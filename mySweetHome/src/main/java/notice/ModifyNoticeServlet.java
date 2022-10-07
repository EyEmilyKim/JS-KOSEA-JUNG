package notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Notice;
import utility.DAO;

/**
 * Servlet implementation class ModifyNoticeServlet
 */
@WebServlet("/modifyNotice.do")
public class ModifyNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyNoticeServlet() {
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
		String seq = request.getParameter("SEQ");
		int seqno = Integer.parseInt(seq);
		String btn = request.getParameter("BTN");
		DAO dao = new DAO();
		boolean result = false;
		if(btn.equals("삭제")) {
			result = dao.deleteNotice(seqno);
			response.sendRedirect("template.jsp?BODY=noticeDeleteResult.jsp?R="+result);
		}else if(btn.equals("수정")) {
			String title = request.getParameter("TITLE");
			String content = request.getParameter("CONTENT");
			Notice n = new Notice();
			n.setSeqno(seqno);
			n.setTitle(title);
			n.setContent(content);
			result = dao.modifyNotice(n);
			response.sendRedirect("template.jsp?BODY=noticeUpdateResult.jsp?R="+result);
		}
	}

}
