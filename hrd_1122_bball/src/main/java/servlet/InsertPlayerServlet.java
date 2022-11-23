package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.DBExpert;
import model.Player;

/**
 * Servlet implementation class InsertPlayerServlet
 */
@WebServlet("/insertPlayer.do")
public class InsertPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertPlayerServlet() {
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
		String seqno = request.getParameter("SEQNO");
		String name = request.getParameter("NAME"); 
		String addr = request.getParameter("ADDR");
		String birth = request.getParameter("BIRTH");
		String t_id = request.getParameter("T_ID");
		String b_num = request.getParameter("B_NUM");
		String ann_sal = request.getParameter("ANN_SAL");
		Player pl = new Player();
		pl.setSeqno(Integer.parseInt(seqno));
		pl.setName(name);
		pl.setAddr(addr);
		pl.setBirth(birth);
		pl.setT_id(Integer.parseInt(t_id));
		pl.setB_num(Integer.parseInt(b_num));
		pl.setAnn_sal(Integer.parseInt(ann_sal));
		DBExpert dao = new DBExpert();
		boolean flag = dao.insertPlayer(pl);
		String target = "addPlayerResult.jsp?R=";
		if(flag) target +="OK";
		else target +="NOK";
		response.sendRedirect(target);	
	}

}
