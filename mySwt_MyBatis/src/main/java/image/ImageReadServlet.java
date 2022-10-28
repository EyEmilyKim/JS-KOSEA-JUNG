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
import utility.ImageDAO;

/**
 * Servlet implementation class ImageReadServlet
 */
@WebServlet("/imageRead.do")
public class ImageReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageReadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seqno=request.getParameter("pid");//�۹�ȣ
		ImageDAO dao = new ImageDAO();
		ImageCrud crud = new ImageCrud();
//		ImageBBS bbs = 
//			dao.getImageDetail(Integer.parseInt(seqno));
		ImageBBS bbs = crud.getImageDetail(Integer.parseInt(seqno));
		request.setAttribute("DETAIL", bbs);
		RequestDispatcher rd = 
			request.getRequestDispatcher(
				"template.jsp?BODY=imageDetail.jsp");
		rd.forward(request, response);
	}

}







