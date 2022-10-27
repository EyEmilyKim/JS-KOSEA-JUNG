package bbs;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BBS;
import model.FromTo;
import utility.Crud;
import utility.DAO;

/**
 * Servlet implementation class BBSListServlet
 */
@WebServlet("/bbsList.do")
public class BBSListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BBSListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNo = 1;//������ ��ȣ
		String page = request.getParameter("PAGE");
		if(page != null) {
			//PAGE�Ķ���Ͱ� �����ϴ� ���, ��,
			//������ ��ȣ�� ���� ���
			pageNo = Integer.parseInt(page);
		}
		int start = (pageNo - 1) * 5;
		int end = ((pageNo - 1) * 5) + 6;
		//��������ȣ:1  start=0, end=6
		//��������ȣ:2  start=5, end=11
		//��������ȣ:3  start=10, end=16
		Crud crud = new Crud();
		FromTo ft = new FromTo();
		ft.setStart(start);
		ft.setEnd(end);
		ArrayList<BBS> list = crud.getPageBBS(ft);
		int totalCount = crud.getBBSCount();//전체 글의 갯수
		int pageCount = totalCount / 5;
		if(totalCount % 5 != 0) pageCount++;
		//게시글 목록을 출력하는 JSP(bbsList.jsp)로 전환
		//Forward
		request.setAttribute("LIST", list);
		request.setAttribute("PAGES", pageCount);
		RequestDispatcher rd = request.getRequestDispatcher(
			"template.jsp?BODY=bbsList.jsp");
		rd.forward(request, response);
	}
	//�ڵ�ȣ��Ǵ� �޼��� : �� �� �޼���(class-back method)
	//������ ������ �ִ� ��� �޼���� �� �� �޼���

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
