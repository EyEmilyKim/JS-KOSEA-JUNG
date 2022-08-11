package aug08;

public class MatjipSpecialist {//책임: 맛집 정보 관련
	//생성자
	MatjipSpecialist(){}
	
	//여러 메서드에서 공통으로 쓰이는 변수를 인스턴스 변수로 만들어둔다.
	//메서드의 지역변수는 메서드가 실행될 때 생성, 종료되면 제거된다.
	//인스턴스 변수는 인스턴스가 생성될 때 만들어졌다가 인스턴스가 메모리에서 삭제될 때 제거된다. 
	String[] areas = {"종로구","성동구","강동구","강서구","강남구","강북구","송파구","성북구","서초구"};
	
	//맛집의 지역이름(여러개)을 배열로 만드는 프로그램
	String[] makeAreas() {
		return areas;
	}
	//선택한 지역의 맛집을 찾는 메서드
	String[] makeMatjip(String area) {
		int index = 0;
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
		int column = matjips[index].length;
		String[] matjip = new String[column];
		for(int i=0; i<column; i++) {
			matjip[i] = matjips[index][i];
		}
		return matjip;
	}
	
}
