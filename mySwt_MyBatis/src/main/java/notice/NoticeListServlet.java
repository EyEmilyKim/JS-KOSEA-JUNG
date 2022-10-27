package notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FromTo;
import model.Notice;
import utility.Crud;

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
		//�������̺� �ִ� �ֱ� 5���� �������� �˻��Ѵ�.
		String page = request.getParameter("PAGE");
		Crud crud = new Crud(); //myBatis용
		int pageNo = 1;
		if(page != null) pageNo = Integer.parseInt(page);
		int start = (pageNo - 1) * 5;
		int end = ((pageNo - 1)* 5) + 6;
		FromTo ft = new FromTo();
		ft.setStart(start);
		ft.setEnd(end);
		ArrayList<Notice> list = crud.getAllNotice(ft);
		int totalCount = crud.getNoticeCount();
		int pageCount = totalCount / 5;
		if(totalCount % 5 != 0) pageCount++;
		int startRow = (pageNo - 1) * 5 + 1;//�� �������� ù��
		int endRow = pageNo * 5;//�� �������� ������ ��
		if(endRow > totalCount) endRow = totalCount;
		request.setAttribute("startRow", startRow);
		request.setAttribute("endRow", endRow);
		request.setAttribute("LIST", list);
		request.setAttribute("PAGES", pageCount);
		request.setAttribute("TOTAL", totalCount);
		RequestDispatcher rd = request.getRequestDispatcher(
				"template.jsp?BODY=noticeList.jsp");
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
