package aug17;

//class Hydra{
//	int mana = 100;
//	Hydra(){};
//	void attackHydra(Hydra h) {//상대방 히드라의 마나를 1줄임
//		h.mana = h.mana - 1;
//	}
//	void attackMarine(Marine m) {//상대방 마린의 마나를 1줄임
//		m.mana = m.mana - 1;
//	}
//	void attackZealot(Zealot z) {//상대방 질럿의 마나를 1줄임
//		z.mana = z.mana - 1;
//	}
//}
//class Marine{
//	int mana = 100;
//	Marine(){};
//	void attackHydra(Hydra h) {//상대방 히드라의 마나를 1줄임
//		h.mana = h.mana - 1;
//	}
//	void attackMarine(Marine m) {//상대방 마린의 마나를 1줄임
//		m.mana = m.mana - 1;
//	}
//	void attackZealot(Zealot z) {//상대방 질럿의 마나를 1줄임
//		z.mana = z.mana - 1;
//	}
//}
//class Zealot{
//	int mana = 100;
//	Zealot(){};
//	void attackHydra(Hydra h) {//상대방 히드라의 마나를 1줄임
//		h.mana = h.mana - 1;
//	}
//	void attackMarine(Marine m) {//상대방 마린의 마나를 1줄임
//		m.mana = m.mana - 1;
//	}
//	void attackZealot(Zealot z) {//상대방 질럿의 마나를 1줄임
//		z.mana = z.mana - 1;
//	}
//}
//

public class Aug17study1_ {
	public static void main(String[] args) {
		Zealot z = new Zealot();
		Zealot z2 = new Zealot();
		Zealot z3 = new Zealot();
		Marine m = new Marine();
		Hydra h = new Hydra();
		System.out.println("---\n1질럿의 마나: "+z.mana);
		System.out.println("2질럿의 마나: "+z2.mana);
		System.out.println("3질럿의 마나: "+z3.mana);
		System.out.println("마린의 마나:"+m.mana);
		System.out.println("히드라의 마나:"+h.mana+"\n");
		
		//1질럿이 2질럿을 1회 공격
		z.attackZealot(z2);
		System.out.println("2질럿의 마나: "+z2.mana);//99
		//3질럿이 2질럿을 1회 공격
		z3.attackZealot(z2);
		System.out.println("n2질럿의 마나: "+z2.mana);//98
		//마린이 히드라를 2회 공격
		m.attackHydra(h);
		m.attackHydra(h);
		System.out.println("히드라의 마나: "+h.mana);//98
		//히드라가 1질럿을 3회 공격
		h.attackZealot(z);
		h.attackZealot(z);
		h.attackZealot(z);
		System.out.println("1질럿의 마나: "+z.mana);//97
		
	}
}	