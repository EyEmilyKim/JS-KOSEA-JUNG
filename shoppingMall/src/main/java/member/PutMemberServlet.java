package member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import utility.DBExpert;

/**
 * Servlet implementation class PutMemberServlet
 */
@WebServlet("/putMember.do")
public class PutMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PutMemberServlet() {
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
		request.setCharacterEncoding("UTF-8");
		String no = request.getParameter("NO");
		String name = request.getParameter("NAME");
		String tel = request.getParameter("TEL");
		String addr = request.getParameter("ADDR");
		String date = request.getParameter("DATE");
		String grade = request.getParameter("GRADE");
		String city = request.getParameter("CITY");
		//DTO 생성, 위 데이터 저장
		Member mem = new Member();
		mem.setCustno(Integer.parseInt(no));
		mem.setCustname(name);
		mem.setPhone(tel);
		mem.setAddress(addr);
		mem.setJoindate(date);
		mem.setGrade(grade);
		mem.setCity(city);
		DBExpert dbe = new DBExpert();
		boolean r = dbe.putMember(mem); //insert 실행
		if(r) { //삽입이 성공한 경우
			response.sendRedirect("putMemberResult.jsp?R=Y");
		}else { //삽입이 실패한 경우
			response.sendRedirect("putMemberResult.jsp?R=N");
		}
	}

}
