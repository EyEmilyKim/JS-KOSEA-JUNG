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
 * Servlet implementation class ItemModifyServlet
 */
@WebServlet("/itemModify.do")
public class ItemModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String code=request.getParameter("CODE");
		String btn=request.getParameter("BTN");
		DAO dao = new DAO();
		if(btn.equals("삭제")) {
			boolean r = dao.deleteItem(code);
			if(r) {
				response.sendRedirect(
					"itemDeleteResult.jsp?R=Y");
			}else {
				response.sendRedirect(
					"itemDeleteResult.jsp?R=N");
			}
		}else if(btn.equals("수정")) {
			String name=request.getParameter("NAME");
			String price=request.getParameter("PRICE");
			String info=request.getParameter("INFO");
			Item item = new Item();
			item.setCode(code); item.setName(name);
			item.setInfo(info); 
			item.setPrice(Integer.parseInt(price));
			boolean r = dao.updateItem(item);//update 실행
			if(r) {//작업이 성공한 경우
				response.sendRedirect(
					"updateItemResult.jsp?R=Y");
			}else {//작업이 실패한 경우
				response.sendRedirect(
					"updateItemResult.jsp?R=N");
			}
		}
	}

}







