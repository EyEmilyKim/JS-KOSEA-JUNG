package sep22;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetBbsServlet
 */
@WebServlet("/getBBS.do")
public class GetBbsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBbsServlet() {
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
		String id = request.getParameter("ID");
		String title = request.getParameter("TITLE");
		String writer = request.getParameter("WRITER");
		String date = request.getParameter("DATE");

		String select = "select * from test_tbl where 1=1 ";
		
		if(! id.equals(""))
			select = select + "and seqno="+id+" ";
		if(! title.equals(""))
			select = select + "and title='"+title+"' ";
		if(! writer.equals(""))
			select = select + "and id='"+writer+"' ";
		
		System.out.println(select);
	}
	

}
