package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.DBExpert;

/**
 * Servlet implementation class EntryMemberServlet
 */
@WebServlet("/entryMemberForm.do")
public class EntryMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EntryMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DB에 다음의 쿼리 실행
		//select max(custno) from member_tbl_02
		DBExpert dbe = new DBExpert();
		Integer max = dbe.getMaxCustno() +1;
		//화면을 entryMember.jsp로 바꾸면서 max의 값을 전달한다. 
		//전환 방법: Forward only! 새로고침때마다 getMaxCustno()실행해야하므로
		request.setAttribute("MAX", max);
		RequestDispatcher rd = request.getRequestDispatcher("entryMember.jsp");
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
