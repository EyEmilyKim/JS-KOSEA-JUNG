package cart;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.Item;
import utility.DAO;

/**
 * Servlet implementation class CartListServlet
 */
@WebServlet("/cartList.do")
public class CartListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart)session.getAttribute("CART");
		if(cart == null) {//장바구니가 없는 경우
			request.setAttribute("CARTLIST", null);
		}else {//장바구니가 있는 경우
			int total = 0;//총계 계산을 위한 변수 선언
			ArrayList<String> codeList=cart.getCodeList();
			ArrayList<Integer> numList=cart.getNumList();
			ArrayList<Item> itemList=new ArrayList<Item>();
			DAO dao = new DAO();
			for(int i=0; i < codeList.size(); i++) {
				String code = codeList.get(i);
				Item item=dao.getItemDetail(code);
				Integer num = numList.get(i);
				item.setNum(num);
				int sum = num * item.getPrice();
				total = total + sum;
				item.setSum(sum);
				itemList.add(item);
			}
			request.setAttribute("CARTLIST", itemList);
			request.setAttribute("TOTAL", total);
		}
		RequestDispatcher rd = 
			request.getRequestDispatcher(
				"template.jsp?BODY=cartList.jsp");
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
