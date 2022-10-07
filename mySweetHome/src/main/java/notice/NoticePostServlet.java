package notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Notice;
import utility.DAO;

/**
 * Servlet implementation class NoticePostServlet
 */
@WebServlet("/noticePost.do")
public class NoticePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticePostServlet() {
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
		String title = request.getParameter("TITLE");
		String content = request.getParameter("CONTENT");
		//작성자 : 세션 정보
		HttpSession session = request.getSession();
		String writer = (String)session.getAttribute("MANAGER");
		//글번호 : 최대 글번호 +1
		DAO dao = new DAO();
		int seqno = dao.getMaxNotice()+1;
		Notice notice = new Notice(); //공지사항 객체
		notice.setSeqno(seqno);
		notice.setTitle(title);
		notice.setWriter(writer);
		notice.setContent(content);
		boolean result = dao.putNotice(notice);//insert 실행
		String url = "template.jsp?BODY=noticeResult.jsp?R=";
		if(result) { //공지사항 등록 성공
			response.sendRedirect(url+"Y");
		}else { //공지사항 등록 실패
			response.sendRedirect(url+"N");
		}
	}
}
