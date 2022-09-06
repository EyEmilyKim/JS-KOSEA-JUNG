package notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NoticePostServlet
 */
@WebServlet("/noticePost.do")
public class NoticePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticePostServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 가장 처음에 처리해야 할 작업: 한글 처리 */
		request.setCharacterEncoding("UTF-8");
		/* 공지사항 등록에 필요한 data 취득 */
		//파라미터 2개 수신
		String title = request.getParameter("TITLE");//글제목
		String content = request.getParameter("CONTENT");//글내용
		//글번호: 자동 증가(예정.아직 미구현)
		//작성자: 세션에서 추출
		HttpSession session = request.getSession(); 
		String id = (String)session.getAttribute("MANAGER");
		//작성일: 오라클 insert 시점의 sysdate
		/* DTO 객체 생성 */
		Notice notice = new Notice();
		notice.seq = 1;
		notice.title = title;
		notice.writer = id;
		notice.content = content;
		/* DTO notice를 쿼리 메서드로 전달 */
		DBExpert dbe = new DBExpert();
		dbe.putNotice(notice);
	}

}
