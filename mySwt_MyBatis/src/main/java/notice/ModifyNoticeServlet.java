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
		request.setCharacterEncoding("euc-kr");
		String seqno=request.getParameter("SEQ");
		String btn=request.getParameter("BTN");
		DAO dao = new DAO();
		boolean result = false;
		if(btn.equals("�� ��")) {
			result=dao.deleteNotice(Integer.parseInt(seqno));
			response.sendRedirect(
			"template.jsp?BODY=noticeDeleteResult.jsp?R="+result);
		}else if(btn.equals("�� ��")) {
			String title=request.getParameter("TITLE");
			String content=request.getParameter("CONTENT");
			Notice notice=new Notice();
			notice.setSeqno(Integer.parseInt(seqno));
			notice.setTitle(title);
			notice.setContent(content);
			result = dao.modifyNotice(notice);
			response.sendRedirect(
			"template.jsp?BODY=noticeUpdateResult.jsp?R="+result);
		}
	}

}








