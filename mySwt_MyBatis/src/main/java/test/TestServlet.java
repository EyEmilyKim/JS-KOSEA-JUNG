package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String time = "0900";
		String s = String.format(
				"%c%c:%c%c", time.charAt(0),time.charAt(1),
				time.charAt(2),time.charAt(3));
		System.out.println(s);//09:00출력
		String id = "2210071004562";//주민번호
		String ids = String.format(
			"%c%c%c%c%c%c-%c%c%c%c%c%c%c", 
			id.charAt(0),id.charAt(1),id.charAt(2),
			id.charAt(3),id.charAt(4),id.charAt(5),
			id.charAt(6),id.charAt(7),id.charAt(8),
			id.charAt(9),id.charAt(10),id.charAt(11),
			id.charAt(12));
		System.out.println(ids);//221007-1004562출력
		String front = id.substring(0,6);
		String back = id.substring(6);
		String idss = front+"-"+back;
		System.out.println(idss);//221007-1004562출력
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
