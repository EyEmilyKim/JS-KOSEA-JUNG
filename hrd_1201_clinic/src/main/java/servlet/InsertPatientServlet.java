package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.DBExpert;
import model.Patient;

/**
 * Servlet implementation class InsertPatientServlet
 */
@WebServlet("/insertPatient.do")
public class InsertPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertPatientServlet() {
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
		String p_code = request.getParameter("P_CODE");
		String p_name = request.getParameter("P_NAME");
		String addr = request.getParameter("ADDR");
		String tel = request.getParameter("TEL");
		String reg_date = request.getParameter("REG_DATE");
		String cour_dr = request.getParameter("COUR&DR");
		String m_code = cour_dr.split("/")[0];
		String d_code = cour_dr.split("/")[1];
		System.out.println("\ncour_dr : "+cour_dr);
		System.out.println("m_code : "+m_code);
		System.out.println("d_code : "+d_code);
		String room = request.getParameter("ROOM");
		Patient pt = new Patient();
		pt.setP_code(p_code);
		pt.setP_name(p_name);
		pt.setAddr(addr);
		pt.setTel(tel);
		pt.setReg_date(reg_date);
		pt.setM_code(m_code);
		pt.setD_code(d_code);
		pt.setRoom(room);
		DBExpert dao = new DBExpert();
		ArrayList<String> listP = dao.getPcodes();
		boolean isNew = true;
		System.out.println("isNew : "+isNew);
		for(String p_exist : listP ) {
			if(p_code.equals(p_exist)) {
				isNew = false; 
				System.out.println("isNew : "+isNew);
			} 
		}
		boolean flag = false;
		if(isNew) {
			flag = dao.insertRecordNew(pt);
		}else {
			flag = dao.insertRecord(pt);
		}
		String target = "addPatientResult.jsp?R=";
		if(flag) target += "OK";
		else target += "NOK";
		response.sendRedirect(target);
		
	}

}
