package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.DBExpert;
import model.Goods;

/**
 * Servlet implementation class InsertGoodsSvlt
 */
@WebServlet("/insertGoods.do")
public class InsertGoodsSvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertGoodsSvlt() {
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
		String id = request.getParameter("GID");
		String name = request.getParameter("NAME"); 
		String made = request.getParameter("MADE");
		String price = request.getParameter("PRICE");
		Goods gds = new Goods();
		gds.setId(id);
		gds.setName(name);
		gds.setMade(made);
		gds.setPrice(Integer.parseInt(price));
		DBExpert dao = new DBExpert();
		boolean flag = dao.insertGoods(gds);
		String target = "addGoodsResult.jsp?R=";
		if(flag) target +="OK";
		else target +="NOK";
		response.sendRedirect(target);	
	}

}
