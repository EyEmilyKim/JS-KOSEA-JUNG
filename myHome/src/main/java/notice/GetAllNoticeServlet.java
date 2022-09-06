package notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetAllNoticeServlet
 */
@WebServlet("/getAllNotice.do")
public class GetAllNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetAllNoticeServlet() {
        super();
    }

    //JSP에서의 기본 mapping은 doGet이다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBExpert dbe = new DBExpert();
		dbe.getAllNotice();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
