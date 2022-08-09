package aug09;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MatjipProcessDoServlet
 */
@WebServlet("/matjipProcess.do")
public class MatjipProcessDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MatjipProcessDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String area = request.getParameter("AREA");
		String[] areas = {"종로구","성동구","강동구","강서구","강남구","강북구","송파구","성북구","서초구"};
		int index = -1;
		for(int i=0; i<areas.length; i++) {
			if(area.equals(areas[i])) {
				index = i;
				break;
			}
		}
		String[][] matjips = {
				{"종로김밥","종로면옥","종로일식","종로루"},
				{"성동전집","성동주막","성동일가","성동횟집","성동짬뽕"},
				{"강동면옥","강동비빔밥","강동고깃집","강동회관","한강동막"},
				{"강서해장국","강서탕면","스시강서"},
				{"강남대장","강남덖볶이","강남파스타","강남돈까스"},
				{"강북루","강북한식","강북분식"},
				{"송파리즘","송파면옥","송파한식","송파함바그"},
				{"성북나라","성복일가","성북양식","복집성북"},
				{"서초한식","서초일식","서초보나라","꼬꼬서초","맥시서초",}
		};
//		for(int i=0; i<matjips[index].length; i++) {
//			System.out.println(matjips[index][i]);
//		}
		int length = matjips[index].length;//선택한 지역의 맛집 수
		String[] result = new String[length];
		for(int i=0; i<length; i++) {//선택한 지역의 맛집들을 result 배열에 넣는다.
			result[i]=matjips[index][i];
		}
		//맛집의 결과를 보여주는 JSP(matjipResult.jsp)로 전환 => Forward only
		//JSP로 전달할 데이터를 request객체에 담는다
		request.setAttribute("AREA", areas[index]);
		request.setAttribute("MATJIP", result);
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?BODY=503.matjipResult.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
