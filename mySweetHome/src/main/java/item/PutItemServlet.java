package item;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import utility.DAO;

/**
 * Servlet implementation class PutItemServlet
 */
@WebServlet("/putItem.do")
public class PutItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PutItemServlet() {
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
		String code = request.getParameter("CODE");
		String name = request.getParameter("NAME");
		String price = request.getParameter("PRICE");
		String info = request.getParameter("INFO");
		Item item = new Item();
		item.setCode(code); 
		item.setName(name);
		item.setPrice(Integer.parseInt(price));
		item.setInfo(info);
		DAO dao = new DAO();
		String url = "template.jsp?BODY=pubItemResult.jsp?R=";
		boolean r = dao.putItem(item);
		if(r) {
			response.sendRedirect(url+"Y");
		}else {
			response.sendRedirect(url+"N");
		}
	}

}
