package bbs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BBS;
import utility.Crud;
import utility.DAO;

/**
 * Servlet implementation class BBSPostServlet
 */
@WebServlet("/bbsPost.do")
public class BBSPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BBSPostServlet() {
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
		//�Խñ� ��Ͽ� �ʿ��� ������:�۹�ȣ,�ۼ���,�ۼ���
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("USERID");
		DAO dao = new DAO();
		Crud crud = new Crud();
		int seqno = crud.getMaxSeqno() +1;
		BBS bbs = new BBS();
		bbs.setSeqno(seqno);//�۹�ȣ
		bbs.setTitle(title);//����
		bbs.setWriter(id);//�ۼ���(����)
		bbs.setContent(content);//�۳���
		Integer result=crud.putBBS(bbs);//insert����
		String url="template.jsp?BODY=bbsResult.jsp?R=";
		if(result > 0) {//�Խñ��� ��ϵ� ���
			response.sendRedirect(url+"Y");
		}else {//�Խñ� ����� ������ ���
			response.sendRedirect(url+"N");
		}
	}

}









