package aug08;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MatjipMakeDoServlet
 */
@WebServlet("/matjipMake.do")
public class MatjipMakeDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MatjipMakeDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MatjipSpecialist ms = new MatjipSpecialist();
		String[] areas = ms.makeAreas();
//		//맛집의 지역 이름을 배열에 넣는다
//		String[] areas = {"종로구","성동구","강동구","강서구","강남구","강북구","송파구","성북구","서초구"};
		//배열을 matjipHome.jsp로 전달한다
		//Forward only
		request.setAttribute("AREA",areas);
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?BODY=501.matjipHome.jsp");
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
