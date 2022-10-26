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
import utility.Crud;
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
		DAO dao = new DAO();
		Crud crud = new Crud(); //myBatis용
		String selectedPwd = crud.getPwd(id);
		String result = "";//�α����� ����� ���� ����
		if(selectedPwd == null) {//�Է��� ������ DB�� ���� ���
			result="NOID";
		}else {//�Է��� ������ DB�� �����ϴ� ���
			if(pwd.equals(selectedPwd)) {//�α��� ����
				result="OK";
				HttpSession session = request.getSession();
				//�Ϲݻ����? ������?
				//������ ����:manager
				if(id.equals("manager")) {
					session.setAttribute("MANAGER", id);
				}else {
					session.setAttribute("USERID", id);
				}
				//�α����� �������� ��ٱ��� ���̺��� �˻��Ѵ�.
				ArrayList<Item> itemList = dao.getCartById(id);
				//�˻������ ������, �˻������� Cart�� �����ؼ� �ִ´�.
				if(itemList.size() > 0) {//�˻������ �ִ� ���
					Cart cartItem = new Cart(id);
					for(int i=0; i<itemList.size(); i++) {
						Item it = itemList.get(i);
						cartItem.getCodeList().add(it.getCode());
						cartItem.getNumList().add(it.getNum());
					}
					session.setAttribute("CART", cartItem);
				}
				//Cart�� ���ǿ� �����Ѵ�.
			}else {//��ȣ�� ��ġ���� �ʴ� ���
				result="NOPWD";
			}
		}
		if(cart != null) {//�˾�â�� ���� �α��� ���
			response.sendRedirect(
				"loginResult.jsp?R="+result+"&ID="+id+"&CART=Y");
		}else {
			response.sendRedirect(
			"template.jsp?BODY=loginResult.jsp?R="+result+"&ID="+id);
		}
	}

}








