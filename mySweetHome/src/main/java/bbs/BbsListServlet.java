package bbs;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bbs;
import utility.DAO;

/**
 * Servlet implementation class BbsListServlet
 */
@WebServlet("/bbsList.do")
public class BbsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BbsListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNo = 1; //페이지 번호
		String page = request.getParameter("PAGE");
		if(page != null) { //PAGE 파라미터가 존재하는 경우(페이지 번호를 클릭한 경우)
			pageNo = Integer.parseInt(page);
		}
		int start = (pageNo - 1) * 5;
		int end = ((pageNo - 1) * 5) + 6;
		//페이지번호:1 -> start=0, end=6
		//페이지번호:2 -> start=5, end=11
		//페이지번호:3 -> start=10, end=16
		DAO dao = new DAO();
		ArrayList<Bbs> list = dao.getPageBbs(start, end);
		int totalCount = dao.getTotalCount(); //전체 글의 갯수
		int pageCount = totalCount / 5;
		if(totalCount % 5 != 0) pageCount++;
		//게시글 목록을 출력하는 JSP(bbsList.jsp)로 전환
		//Forward? Redirect? Forward!(전달할 데이터가 ArrayList!)
		request.setAttribute("LIST", list);
		request.setAttribute("PAGES", pageCount);
		RequestDispatcher rs = request.getRequestDispatcher("template.jsp?BODY=bbsList.jsp");
		rs.forward(request, response);
		
	} //자동호출되는 메서드 : 콜백 메서드(call-back method)

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
