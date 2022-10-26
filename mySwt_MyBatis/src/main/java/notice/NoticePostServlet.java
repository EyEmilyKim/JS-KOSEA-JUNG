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
		request.setCharacterEncoding("euc-kr");
		String title=request.getParameter("TITLE");
		String content=request.getParameter("CONTENT");
		HttpSession session = request.getSession();
		//작성자:세션에서 MANAGER찾는다.
		String id = (String)session.getAttribute("MANAGER");
		//글번호:최대 글번호 + 1
		DAO dao = new DAO();
		int seqno = dao.getMaxNotice() + 1;
		Notice notice = new Notice();
		notice.setSeqno(seqno);//글번호 설정
		notice.setTitle(title);//글제목 설정
		notice.setWriter(id);//작성자 설정
		notice.setContent(content);//글내용 설정
		boolean result = dao.putNotice(notice);//insert실행
		String url="template.jsp?BODY=noticeResult.jsp?R=";
		if(result) {//공지글 등록 성공인 경우
			response.sendRedirect(url+"Y");
		}else {//공지글 등록 실패인 경우
			response.sendRedirect(url+"N");
		}
	}

}







