package cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;

/**
 * Servlet implementation class AddCartServlet
 */
@WebServlet("/addCart.do")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("USERID");
		if(id == null) { //로그인 안한 경우
			response.sendRedirect("login.jsp?CART=Y");
		}else { //로그인 한 경우
			String code = request.getParameter("CODE"); //상품번호
			//세션에서 장바구니객체(Cart)를 찾는다.
			Cart cart = (Cart)session.getAttribute("CART");
			if(cart == null) cart = new Cart(id);
			//Cart에 상품의 번호와 갯수를 저장한다.
			cart.addCart(code, 1); 
			//장바구니를 세션에 저장한다.
			session.setAttribute("CART", cart);
			//장바구니 결과jsp(addCartResult.jsp)로 전환한다.
			response.sendRedirect("addCartResult.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
