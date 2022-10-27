package bbs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BBS;
import utility.Crud;
import utility.DAO;

/**
 * Servlet implementation class BBSDetailServlet
 */
@WebServlet("/bbsDetail.do")
public class BBSDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BBSDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seqno=request.getParameter("NO");
		//seqno에 들어있는 글번호로 게시글을 조회한다.
		Crud crud = new Crud(); //myBatis용
		BBS bbs = crud.getBBSDetail(Integer.parseInt(seqno));
		request.setAttribute("BBS", bbs);
		RequestDispatcher rd = request.getRequestDispatcher(
			"template.jsp?BODY=bbsDetail.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
