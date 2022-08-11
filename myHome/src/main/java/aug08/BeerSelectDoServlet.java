package aug08;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class BeerSpecialist {//맥주를 찾아주는 책임을 가진 class
	//class에는 인스턴스화에 필요한 등록메서드(생성자, constructor)가 반드시 있어야 한다.
	BeerSpecialist(){}//생성자
	//고객이 선택한 색깔에 맞는 맥주 여러개를 추천해주는 메서드(return메서드)를 작성한다
	String[] beerSelect(String color) {
		String[] brands = null;//배열 선언
		switch(color) {
		case "L"://밝은색(3)
			brands = new String[3];
			brands[0]="하이네켄"; brands[1]="OB라거"; brands[2]="크라운 카스"; 
			break;
		case "D"://어두운색(2)
			brands = new String[2];
			brands[0]="코로나"; brands[1]="KGB";
			break;
		case "Y"://노란색(3)
			brands = new String[3];
			brands[0]="칭따오"; brands[1]="기린"; brands[2]="Red Hat";
			break;
		case "B"://갈색(4)
			brands = new String[4];
			brands[0]="기네스"; brands[1]="스타우트"; brands[2]="코젤"; brands[3]="Mexican";
			break;
		}
		return brands;
	}
}

@WebServlet("/beerSelect.do")
public class BeerSelectDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BeerSelectDoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//고객이 선택한 색깔이 들어있는 파라미터를 수신한다
		//파라미터를 수신할 때 사용하는 객체 - request
		String color = request.getParameter("COLOR");
		//추천하는 맥주이름의 갯수를 N개 - 배열 사용
		BeerSpecialist bs = new BeerSpecialist();
		String[] names = bs.beerSelect(color);
		/*------위의 class BeerSpecialist 로 대체됨
		 * String[] names = beerExpert(color);//추천된 맥주이름 N개;
		 */		
		//페이지를 beerResult.jsp로 바꾼다. Forward 방식 only!
		request.setAttribute("BRAND", names);
		RequestDispatcher r = request.getRequestDispatcher("template.jsp?BODY=103.beerResult.jsp");
		r.forward(request, response);
	}

//------위의 class BeerSpecialist 로 대체됨
//	String[] beerExpert(String c){
//		//c 안에 "L","D","Y","B" 중 무엇이 있는지 찾는다
//		String[] brands = null;
//		if(c.equals("L")){//밝은색(3)
//			brands = new String[3];
//			brands[0]="하이네켄"; brands[1]="OB라거"; brands[2]="크라운 카스"; 
//		}else if(c.equals("D")){//어두운색(2)
//			brands = new String[2];
//			brands[0]="코로나"; brands[1]="KGB";
//		}else if(c.equals("Y")){//노란색(3)
//			brands = new String[3];
//			brands[0]="칭따오"; brands[1]="기린"; brands[2]="Red Hat";
//		}else if(c.equals("B")){//갈색(4)
//			brands = new String[4];
//			brands[0]="기네스"; brands[1]="스타우트"; brands[2]="코젤"; brands[3]="Mexican";
//		}
//		return brands;
//	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
