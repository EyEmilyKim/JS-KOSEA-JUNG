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
 * Servlet implementation class MemberModifyServlet
 */
@WebServlet("/memberModify.do")
public class MemberModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberModifyServlet() {
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
		//어떤 버튼을 눌렀는지 버튼의 제목 비교
		String btn = request.getParameter("BTN");
		if(btn.equals("삭제")) {//회원번호만 알면 삭제 가능
			String no = request.getParameter("NO");
			DBExpert dbe = new DBExpert();
			boolean r = dbe.deleteMember(Integer.parseInt(no));
			if(r) {//삭제 성공
				response.sendRedirect("deleteMemberResult.jsp?R=Y");
			}else {//삭제 실패
				response.sendRedirect("deleteMemberResult.jsp?R=N");
			}
		}else if(btn.equals("조회(s)")) {
			response.sendRedirect("getAllMember.do");
		}else if(btn.equals("수정")) {
			String no = request.getParameter("NO");
			String name = request.getParameter("NAME");
			String tel = request.getParameter("TEL");
			String addr = request.getParameter("ADDR");
			String date = request.getParameter("DATE");
			String grade = request.getParameter("GRADE");
			String city = request.getParameter("CITY");
			Member mem = new Member();
			mem.setCustno(Integer.parseInt(no));
			mem.setCustname(name);
			mem.setPhone(tel);
			mem.setAddress(addr);
			mem.setJoindate(date);
			mem.setGrade(grade);
			mem.setCity(city);
			DBExpert dbe = new DBExpert();
			boolean r = dbe.updateMember(mem);
			if(r) {
				response.sendRedirect("memberUpdateResult.jsp?R=Y");
			}else {
				response.sendRedirect("memberUpdateResult.jsp?R=N");
			}
		}
	}

}
