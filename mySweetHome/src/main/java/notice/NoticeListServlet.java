package notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Notice;
import utility.DAO;

/**
 * Servlet implementation class NoticeListServlet
 */
@WebServlet("/noticeList.do")
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//공지사항 테이블에 있는 최근 5개의 글 검색
		DAO dao = new DAO();
		int pageNo = 1;
		String pageParam = request.getParameter("PAGE");
		if(pageParam != null) pageNo = Integer.parseInt(pageParam);
		int start = (pageNo -1)* 5;
		int end = ((pageNo -1)* 5) + 6;
		//
		ArrayList<Notice> list = dao.getAllNotice(start, end);
		request.setAttribute("LIST", list);
		//필요한 페이지 정보 및 전체 건수
		int totalCount = dao.getNoticeCount();
		int pageCount = totalCount / 5;
		if(totalCount % 5 != 0) pageCount++;
		request.setAttribute("PAGES", pageCount);	
		request.setAttribute("TOTAL", totalCount);
		//각 페이지 표시글 번호
		int startRow = (pageNo -1)*5 + 1; //현 페이지의 첫 줄
		int endRow = pageNo * 5; //현 페이지의 마지막 줄
		if(endRow > totalCount) endRow = totalCount;
		request.setAttribute("STARTR", startRow);
		request.setAttribute("ENDR", endRow);
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?BODY=noticeList.jsp");
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
