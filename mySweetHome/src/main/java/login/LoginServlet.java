package login;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String id = request.getParameter("ID");
		String pwd = request.getParameter("PWD");
		String cart = request.getParameter("CART");
		//id에 있는 계정으로 사용자 테이블(mysweet_users)에서 암호 검색
		//select pwd from mysweet_users where id = '입력한 계정'
		DAO dao = new DAO();
		String result = null;
		String selectedPwd = dao.getPwd(id);
		if(selectedPwd == null) { //입력한 계정이 DB에 존재하지 않는 경우
			result = "NOID";
		}else { //입력한 계정이 DB에 존재하는 경우
			if(pwd.equals(selectedPwd)) { //로그인 성공
				result = "OK";
				//로그인 성공 시 로그아웃 때까지 세션정보 저장.등록 !!
				HttpSession session = request.getSession();
				//일반 사용자? 관리자ㅣ?
				if(id.equals("manager")){
					session.setAttribute("MANAGER", id);
				}else {
					session.setAttribute("USERID", id);
					
				}
				//////DB연동
				//로그인한 계정으로 장바구니 테이블 검색
				ArrayList<Item> itemList = dao.getCartById(id);
				//검색결과 있으면, 검색정보를 Cart 객체에 저장
				Cart cartItem = new Cart(id);
				if(itemList.size() > 0) { //검색결과가 있는 경우
					for(int i=0; i < itemList.size(); i++) {
						Item it = itemList.get(i);
						cartItem.getCodeList().add(it.getCode());
						cartItem.getNumList().add(it.getNum());
					}
				}
				//Cart를 세션에 저장
				session.setAttribute("CART", cartItem);
			}else { //암호가 일치하지 않는 경우.
				result = "NOPWD";
				
			}
		}
		if(cart != null) {
			response.sendRedirect("loginResult.jsp?R="+result+"&ID="+id+"&CART=Y");
		}else {
			response.sendRedirect("template.jsp?BODY=loginResult.jsp?R="+result+"&ID="+id);
		}
		
	}

}
