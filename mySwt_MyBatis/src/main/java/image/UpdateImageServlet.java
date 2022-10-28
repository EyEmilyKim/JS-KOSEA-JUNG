package image;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.ImageBBS;
import utility.ImageCrud;

/**
 * Servlet implementation class UpdateImageServlet
 */
@WebServlet("/updateImage.do")
public class UpdateImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateImageServlet() {
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
		request.setCharacterEncoding("euc-kr");
		String savePath="/upload";//���ε� ���� ���� ����
		int maxLimit= 5 * 1024 * 1024;//�ִ� ���ε� ũ��
		String encType="euc-kr";//��� �ڵ�
		String fileName="";//���ε� ������ �����̸��� ����� ����
		ServletContext ctx = this.getServletContext();
		String realPath=ctx.getRealPath(savePath);//������
		String url="";//��ȯ�� URL
//		ImageDAO dao = new ImageDAO();
		ImageCrud crud = new ImageCrud();
		try {
			MultipartRequest multipart = new MultipartRequest(
				request, realPath, maxLimit, encType,
				new DefaultFileRenamePolicy());//���ε尴ü����
			String title=multipart.getParameter("title");
			String pwd=multipart.getParameter("pwd");
			String content=multipart.getParameter("content");
			String id=multipart.getParameter("id");
//			ImageBBS bbs=dao.getImageDetail(Integer.parseInt(id));//�۹�ȣ�� �˻�
			ImageBBS bbs=crud.getImageDetail(Integer.parseInt(id));//�۹�ȣ�� �˻�
			if(bbs.getPassword().equals(pwd)) {//��ȣ�� ��ġ
				bbs.setTitle(title);//������ ����
				bbs.setContent(content);//�۳����� ����
				fileName=multipart.getFilesystemName(
						"image_name");//���ε带 �����Ѵ�.
				if(fileName !=null || ! fileName.equals("")) {//�̹�������
					bbs.setImage_name(fileName);//�̹����̸�����
				}
				//DB���� update�� �����Ѵ�.
//				dao.updateImage(bbs);
				crud.updateImage(bbs);
				url="template.jsp?BODY=imageUpdateResult.jsp";
				url=url+"?seqno="+id;
			}else {//��ȣ�� ����ġ
				url="template.jsp?BODY=imageUpdateResult.jsp";
				url=url+"?id="+id;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect(url);//ȭ�� ��ȯ
	}

}








