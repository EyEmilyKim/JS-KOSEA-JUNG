package item;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import utility.Crud;

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
		request.setCharacterEncoding("euc-kr");
		String code=request.getParameter("CODE");
		String name=request.getParameter("NAME");
		String price=request.getParameter("PRICE");
		String info=request.getParameter("INFO");
		Item item = new Item();
		item.setCode(code); item.setName(name);
		item.setPrice(Integer.parseInt(price));
		item.setInfo(info);
		Crud crud = new Crud();
		Integer r = crud.putItem(item);//��ǰ���� ����
		String url="template.jsp?BODY=putItemResult.jsp?R=";
		if(r > 0) {//������ ������ ���
			response.sendRedirect(url+"Y");
		}else {//������ ������ ���
			response.sendRedirect(url+"N");
		}
	}

}









