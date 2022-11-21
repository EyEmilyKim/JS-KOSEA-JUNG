package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.DBExpert;
import model.Course;

/**
 * Servlet implementation class CourseInsertServlet
 */
@WebServlet("/courseInsert.do")
public class CourseInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseInsertServlet() {
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
		String id = request.getParameter("ID").trim();
		String name = request.getParameter("NAME");
		String credit = request.getParameter("CREDIT");
		String lecturer_idx = request.getParameter("TR_IDX");
//		System.out.println("servlet getParameter(\"TR_IDX\") : "+lecturer_idx);
		String week = request.getParameter("WEEK");
		String start = request.getParameter("START");
		String end = request.getParameter("END");
		Course crs = new Course();
		crs.setId(id);
		crs.setName(name);
		crs.setCredit(Integer.parseInt(credit));
		crs.setLecturer_idx(lecturer_idx);
		crs.setWeek_n(Integer.parseInt(week));
		crs.setStart_hour(start);
		crs.setEnd_hour(end);
		DBExpert dao = new DBExpert();
		boolean flag = dao.insertCourse(crs);
		String target = "courseAddResult.jsp?R=";
		if(flag) target += "OK";
		else target += "NOK";
		response.sendRedirect(target);
	}

}
