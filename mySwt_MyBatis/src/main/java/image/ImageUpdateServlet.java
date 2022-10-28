package image;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ImageBBS;
import utility.ImageCrud;

/**
 * Servlet implementation class ImageUpdateServlet
 */
@WebServlet("/imageUpdate.do")
public class ImageUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageUpdateServlet() {
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
		String id=request.getParameter("id");
//		ImageDAO dao = new ImageDAO();
		ImageCrud crud = new ImageCrud();
//		ImageBBS bbs = dao.getImageDetail(Integer.parseInt(id));
		ImageBBS bbs = crud.getImageDetail(Integer.parseInt(id));
		request.setAttribute("IMG", bbs);
		RequestDispatcher rd = 
			request.getRequestDispatcher(
				"template.jsp?BODY=updateForm.jsp");
		rd.forward(request, response);
	}

}







