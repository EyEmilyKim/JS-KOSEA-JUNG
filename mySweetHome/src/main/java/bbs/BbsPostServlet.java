package bbs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Bbs;
import utility.DAO;

/**
 * Servlet implementation class BbsPostServlet
 */
@WebServlet("/bbsPost.do")
public class BbsPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BbsPostServlet() {
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
		//게시글 등록에 필요한 데이터 : 글번호, 작성자, 작성일
		HttpSession session = request.getSession();
		String writer = (String)session.getAttribute("USERID");
		DAO dao = new DAO();
		int seqno = dao.getMaxSeqno()+1;
		Bbs bbs = new Bbs();
		bbs.setSeqno(seqno); //글번호
		bbs.setTitle(title); //글제목
		bbs.setWriter(writer); //작성자
		bbs.setContent(content); //글내용
		boolean result = dao.putBbs(bbs); //insert 실행
		String url = "template.jsp?BODY=bbsResult.jsp?R=";
		if(result) {//게시글 등록 성공
			response.sendRedirect(url+"Y");
		}else {//게시글 등록 실패
			response.sendRedirect(url+"N");
		}
		
	}

}
