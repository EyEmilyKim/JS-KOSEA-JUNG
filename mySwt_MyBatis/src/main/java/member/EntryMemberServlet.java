package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import utility.DAO;

/**
 * Servlet implementation class EntryMemberServlet
 */
@WebServlet("/entryMember.do")
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String name=request.getParameter("NAME");
		String id=request.getParameter("ID");
		String addr=request.getParameter("ADDR");
		String tel=request.getParameter("TEL");
		String pwd=request.getParameter("PWD");
		String gender=request.getParameter("GENDER");
		String email = request.getParameter("EMAIL");
		String job=request.getParameter("JOB");
		Member member=new Member();//DTO»ý¼º
		member.setId(id); member.setName(name);
		member.setPwd(pwd); member.setAddr(addr);
		member.setTel(tel); member.setGender(gender);
		member.setEmail(email); member.setJob(job);
		DAO dao = new DAO();
		boolean result = dao.putMember(member);
		String url=
			"template.jsp?BODY=userEntryResult.jsp?R=";
		if(result) response.sendRedirect(url+"Y");
		else response.sendRedirect(url+"N");
	}

}








