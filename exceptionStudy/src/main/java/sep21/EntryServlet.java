package sep21;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EntryServlet
 */
@WebServlet("/entry.do")
public class EntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EntryServlet() {
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
		//가장 처음에 할 것은 한글처리 !
		//form 내용 수신
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("ID");
		String title = request.getParameter("TITLE");
		String writer = request.getParameter("WRITER");
		String content = request.getParameter("CONTENT");
		//id,title,writer,content 변수를 이용해서 삽입 수행
		DBExpert dbe = new DBExpert();
		boolean result = dbe.entryBBS(Integer.parseInt(id), writer, title, content);
		if(result) { //삽입이 성공한 경우
			//entryResult.jsp로 전환(Forward(NO), Redirect(YES))
			//Forward를 사용하면 새로고침할 때 이전 주소창이 계속 로딩되므로 중복insert 발생할 수 있음!
			response.sendRedirect("entryResult.jsp?R=Y");
		}else { //삽입이 실패한 경우
			//entryResult.jsp로 전환
			response.sendRedirect("entryResult.jsp?R=N");
		}
		
	}

}
