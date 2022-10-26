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
		if(id == null) {//�α����� �� �� ���
			response.sendRedirect("login.jsp?CART=Y");
		}else {//�α����� �� ���
			String code = request.getParameter("CODE");//��ǰ��ȣ
			//���ǿ��� ��ٱ��ϰ�ü(Cart)�� ã�´�.
			Cart cart = (Cart)session.getAttribute("CART");
			if(cart == null) cart = new Cart(id);
			//Cart�� ��ǰ�� ��ȣ�� ������ �����Ѵ�.
			cart.addCart(code, 1);
			session.setAttribute("CART", cart);
			//��ٱ��� ���JSP(addCartResult.jsp)�� ��ȯ�Ѵ�.
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
