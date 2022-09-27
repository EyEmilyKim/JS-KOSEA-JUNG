package sep26;

import java.util.ArrayList;

public class Study1 {
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.add("포도"); al.add("딸기"); al.add("사과");
		//포도,딸기,사과
		al.add(2,"키위");//포도,딸기,키위,사과
		al.set(0, "오렌지");//오렌지,딸기,키위,사과
		al.remove(1);//오렌지,키위,사과
		al.remove("키위");//오렌지,사과
		int num = al.size();
		System.out.println("저장된 데이터의 수:"+num); //2
		for(int i = 0; i < num; i++) {
			String data = (String)al.get(i);
			System.out.println(data);
		}
	}
}








