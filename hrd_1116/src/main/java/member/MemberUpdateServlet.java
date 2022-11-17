package member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.DBExpert;
import model.Member;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/memberUpdate.do")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
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
		Integer id = Integer.parseInt(request.getParameter("ID"));
		String name = request.getParameter("NAME");
		String tel = request.getParameter("TEL");
		String addr = request.getParameter("ADDR");
		String date = request.getParameter("DATE");
		String grade = request.getParameter("GRADE");
		String city = request.getParameter("CITY");
		//DTO에 파라미터 값 저장
		Member mem = new Member();
		mem.setId(id);
		mem.setName(name);
		mem.setTel(tel);
		mem.setAddr(addr);
		mem.setDate(date);
		mem.setGrade(grade);
		mem.setCity(city);
		//DB 연동
		DBExpert crud = new DBExpert();
		Boolean flag = crud.updateMember(mem);
		//jsp 전환
		String target = "userUpdateResult.jsp";
		response.sendRedirect(target+"?R="+flag);
	}

}
