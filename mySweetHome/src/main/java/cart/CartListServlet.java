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
 * Servlet implementation class CartListDo
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
		if(cart == null) { //장바구니가 없는 경우
			request.setAttribute("CARTLIST", null);
		}else { //장바구니가 있는 경우
			ArrayList<String> codeList = cart.getCodeList();
			ArrayList<Integer> numList = cart.getNumList();
			DAO dao = new DAO();
			ArrayList<Item> itemList = new ArrayList<Item>();
			//↓codeList에 있는 상품 갯수 만큼 
			//DB에서 상품번호로 상품정보 검색, 수량&소계 세팅, 상품리스트에 담기. 
			for(int i=0; i < codeList.size(); i++) {
				//DB에서 상품번호로 상품정보 검색
				String code = codeList.get(i);
				Item item = dao.getItemDetail(code);
				//상품의 수량에 장바구니 수량을 넣어줌
				Integer num = numList.get(i);
				item.setNum(num);
				//장바구니 수량* 상품가격 계산결과를 상품의 소계에 넣어줌
				item.setSum(num * item.getPrice());
				//아이템을 리스트에 담아줌
				itemList.add(item);
			}
			request.setAttribute("CARTLIST", itemList);
			
		}
		RequestDispatcher rd = 
				request.getRequestDispatcher("template.jsp?BODY=cartList.jsp");
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
