package aug05;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.tag.common.fmt.RequestEncodingSupport;

/**
 * Servlet implementation class ServletDoServlet
 */
@WebServlet("/servlet.do")
public class ServletDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletDoServlet() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet이 수신함");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost가 수신함");
		//JSP(study_servletRslt.jsp)로 페이지를 바꾼다
		//1.Redirect
//		response.sendRedirect("study_servletRslt.jsp");
		//2.Forward
		RequestDispatcher r = request.getRequestDispatcher("study_servletRslt.jsp");
		r.forward(request, response);		
	}

}
