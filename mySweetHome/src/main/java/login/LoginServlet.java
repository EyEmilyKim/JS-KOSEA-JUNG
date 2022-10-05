package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		//id에 있는 계정으로 사용자 테이블(mysweet_users)에서 암호 검색
		//select pwd from mysweet_users where id = '입력한 계정'
		DAO dao = new DAO();
		String result = null;
		String selectedPwd = dao.getPwd(id);
		if(selectedPwd == null) { //입력한 계정이 DB에 존재하지 않는 경우
			result = "NOID";
		}else { //입력한 계정이 DB에 존재하는 경어.
			if(pwd.equals(selectedPwd)) { //로그인 성공
				result = "OK";
				//로그인 성공 시 로그아웃 때까지 세션정보 저장.등록 !!
				HttpSession session = request.getSession();
				//일반 사용자? 관리자ㅣ?
				if(id.equals("manager")){
					session.setAttribute("MANAGER", id);
				}else {
					session.setAttribute("USERID", id);
				}		
			}else { //암호가 일치하지 않는 경우.
				result = "NOPWD";
				
			}
		}
		response.sendRedirect("template.jsp?BODY=loginResult.jsp?R="+result+"&ID="+id);
		
	}

}
