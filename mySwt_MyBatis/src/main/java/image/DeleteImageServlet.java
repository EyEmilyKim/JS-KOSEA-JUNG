package image;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ImageBBS;
import utility.ImageCrud;
import utility.ImageDAO;

/**
 * Servlet implementation class DeleteImageServlet
 */
@WebServlet("/deleteImage.do")
public class DeleteImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteImageServlet() {
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
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
//		ImageDAO dao = new ImageDAO();
		ImageCrud crud = new ImageCrud();
//		ImageBBS bbs = dao.getImageDetail(
//				Integer.parseInt(id));
		ImageBBS bbs = crud.getImageDetail(
				Integer.parseInt(id));
		String url="template.jsp?BODY=imageDeleteResult.jsp";
		if(bbs.getPassword().equals(pwd)) {//��ȣ�� ��ġ�ϴ� ���
//			dao.deleteImage(Integer.parseInt(id));
			crud.deleteImage(Integer.parseInt(id));
			//�̹����� �����Ǵ� ��� ���ε� ���ϵ� �����Ѵ�.����
			String file="/upload/"+bbs.getImage_name();
			ServletContext ctx=this.getServletContext();
			String realPath=ctx.getRealPath(file);
			File imageFile = new File(realPath);
			if(imageFile.exists()) {//������ �����ϴ� ���
				imageFile.delete();//���� ����
			}
			//���ϻ��� ��
		}else {//��ȣ�� ��ġ���� �ʴ� ���
			url=url+"?id="+id;
		}
		response.sendRedirect(url);
	}

}







