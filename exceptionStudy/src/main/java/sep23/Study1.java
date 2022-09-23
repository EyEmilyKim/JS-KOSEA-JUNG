package sep23;

import java.util.ArrayList;

public class Study1 {

	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.add(100);
		al.add("korea");
		al.add("japan");
		al.add(3.14);
		al.add(new Tiger());
		al.add('A');
		
		int num = al.size();
		System.out.println("저장된 갯수: "+num); //6
		int r1 = al.get(0);
		String r2 = al.get(1);
		String r3 = al.get(2);
		double r4 = al.get(3);
	}

}

class Tiger{}
