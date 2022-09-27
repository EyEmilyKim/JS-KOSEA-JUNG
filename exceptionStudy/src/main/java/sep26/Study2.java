package sep26;

import java.util.ArrayList;

public class Study2 {
	public static void main(String[] args) {
		//데이터베이스의 조회결과가 전부 정수 (예: 시험점수)
		ArrayList al = new ArrayList();
		al.add(100); al.add(90); al.add(75);
		al.add(95); al.add(80); al.add(100);
		al.add(80.75); al.add("구십오점"); //정수아닌 데이터도 들어가버림. 데이터 오염
		//Collection Framework에 저장되는 데이터의 형태를 제한할 수 있다.
		//--->제네릭(Generic)
		//정수(Integer)만 저장되는 ArrayList 생성
		ArrayList<Integer> all = 
				new ArrayList<Integer>();
		all.add(100); all.add(90); all.add(75);
		all.add(95); all.add(80); all.add(100);
//		all.add(80.75); all.add("구십오점");
		//Integer가 아닌 데이터를 넣으려 하면 컴파일에러가 뜸.
	}
}







