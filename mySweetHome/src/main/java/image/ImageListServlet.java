package image;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ImageBbs;
import utility.ImageBbsDAO;

/**
 * Servlet implementation class ImageListServlet
 */
@WebServlet("/imageList.do")
public class ImageListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ImageBbsDAO dao = new ImageBbsDAO();
		int perPage = 2;
		String page = request.getParameter("PAGE");
		String seqno = request.getParameter("seqno"); //글번호
		int totalCount = dao.getImageCount(); //전체 이미지글 건수
		int pageNum = 1; 
		if(page != null) pageNum = Integer.parseInt(page);
		////seqno에 들어있는 글번호로 페이지 번호를 찾는다. 시작
		if(seqno != null) {
			int rownum = dao.getRownumBySeqno(Integer.parseInt(seqno));
			int p = rownum / perPage;
			if(rownum % perPage > 0) p++;
			pageNum = p;
		}
		////seqno에 들어있는 글번호로 페이지 번호를 찾는다. 끝
		int pageCount = 0;
		int startRow = 0;
		int endRow = 0; 
		if(totalCount > 0) { //이미지글이 존재하는 경우
			pageCount = totalCount / perPage;
			if(totalCount % perPage > 0) pageCount++; //총 페이지 수
			startRow = (pageNum - 1) *perPage +1; 
			endRow = pageNum * perPage;
			//예) perPage : 5
			//예) 1페이지: startRow = 1, endRow = 5
			//예) 2페이지: startRow = 6, endRow = 10
			if(endRow > totalCount) endRow = totalCount;
		}
		ArrayList<ImageBbs> list = dao.getAllImages(startRow, endRow);
		request.setAttribute("currentPage", pageNum);
		request.setAttribute("IMGLIST", list);
		request.setAttribute("TOTAL", totalCount);
		request.setAttribute("STRTROW", startRow);
		request.setAttribute("ENDROW", endRow);
		request.setAttribute("PAGES", pageCount);
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?BODY=imageList.jsp");
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
