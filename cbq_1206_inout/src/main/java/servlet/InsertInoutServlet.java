package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.DBExpert;
import model.Inout;

/**
 * Servlet implementation class InsertInoutServlet
 */
@WebServlet("/insertInout.do")
public class InsertInoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertInoutServlet() {
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
		String t_no = request.getParameter("TNO");
		String p_code = request.getParameter("PCODE");
		String t_type = request.getParameter("TTYPE");
		String t_cnt = request.getParameter("TCNT");
		String t_date = request.getParameter("TDATE");
		String c_code = request.getParameter("CCODE");
		Inout io = new Inout();
		io.setT_no(t_no);
		io.setP_code(p_code);
		io.setT_type(t_type);
		io.setT_cnt(Integer.parseInt(t_cnt));
		io.setT_date(t_date);
		io.setC_code(c_code);
		DBExpert dao = new DBExpert();
		boolean flag = dao.insertInout(io);
		String target = "addInoutResult.jsp?R=";
		if(flag) target += "OK";
		else target += "NOK";
		response.sendRedirect(target);
	}

}
