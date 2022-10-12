package item;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import utility.DAO;

/**
 * Servlet implementation class ItemListServlet
 */
@WebServlet("/itemList.do")
public class ItemListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("PAGE");
		DAO dao = new DAO();
		int pageNum = 1;
		if(page != null) pageNum = Integer.parseInt(page);
		int start = (pageNum -1)* 5;
		int end = ((pageNum -1)* 5)+ 6;
		//예) 1페이지: 0, 6 
		//예) 2페이지: 5, 11
		ArrayList<Item> list = dao.getAllItems(start, end);
		int total = dao.getTotalItemCount(); //전체 상품의 갯수
		int pageCount = total / 5;
		if(total % 5 != 0) pageCount++;
		request.setAttribute("ITEMS", list);
		request.setAttribute("PAGES", pageCount);
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?BODY=itemList.jsp");
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
