package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.DBExpert;
import model.Vote;

/**
 * Servlet implementation class InsertVoteServlet
 */
@WebServlet("/insertVote.do")
public class InsertVoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertVoteServlet() {
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
		String v_jumin = request.getParameter("V_JUMIN");
		//↓수신한 주민번호13자리 중 마지막 2자리 잘라내는 처리
		String v_jumin_11 = v_jumin.substring(0, 11);
		String v_name = request.getParameter("V_NAME");
		String m_no = request.getParameter("M_NO");
		String v_time = request.getParameter("V_TIME");
		String v_area = request.getParameter("V_AREA");
		String v_confirm = request.getParameter("V_CONF");
		Vote vt = new Vote();
		vt.setV_jumin_11(v_jumin_11);
		vt.setV_name(v_name);
		vt.setM_no(m_no);
		vt.setV_time(v_time);
		vt.setV_area(v_area);
		vt.setV_confirm(v_confirm);
		DBExpert dao = new DBExpert();
		boolean flag = dao.insertVote(vt);
		String target = "addVoteResult.jsp?R=";
		if(flag) target += "OK";
		else target += "NOK";
		response.sendRedirect(target);
	}

}
