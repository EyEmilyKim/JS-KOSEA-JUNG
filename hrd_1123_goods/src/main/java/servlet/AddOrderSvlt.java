package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.DBExpert;
import model.Order;

/**
 * Servlet implementation class AddOrderSvlt
 */
@WebServlet("/addOrder.do")
public class AddOrderSvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOrderSvlt() {
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
		String gid = request.getParameter("GID");
		String cno = request.getParameter("CNO");
		String o_date = request.getParameter("O_DATE");
		Order odr = new Order();
		odr.setId(gid);
		odr.setG_no(Integer.parseInt(cno));
		odr.setO_date(o_date);
		DBExpert dao = new DBExpert();
		boolean flag = dao.insertOrder(odr);
		String target = "addOrderResult.jsp?R=";
		if(flag) target += "OK";
		else target += "NOK";
		response.sendRedirect(target);
	}

}
