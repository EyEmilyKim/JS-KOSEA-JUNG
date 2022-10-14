package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utility.DBExpert;

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
		System.out.println(id+"/"+pwd);
		DBExpert dbe = new DBExpert();
		String result = dbe.getPassword(id);
		String msg = "";
		if(result == null) {//계정이 존재하지 않는 경우
			msg = "NOID";
		}else {//계정이 존재하는 경우
			if(result.equals(pwd)) {//입력한 암호와 일치하는 경우
				msg = "YES";
				HttpSession session = request.getSession();
				if(id.equals("manager")) {//관리자인 경우
					session.setAttribute("MANAGER", id);
				}else {//일반사용자인 경우
					session.setAttribute("LOGIN_ID", id); //세션에 데이터 저장
				}
			}else {//입력한 암호와 일치하지 않는 경우
				msg = "NOPWD";
			}
		}
		response.sendRedirect("loginResult.jsp?R="+msg);
	}
}