package Oct18;

//머린, 질럿, 히드라가 있습니다. 서로 공격을 합니다.
//공격 후 각 유닛의 마나를 출력합니다.(기본 마나는 100)

class Unit {
	int mana;
	Unit(int mana){ this.mana = mana; }
	void attack(Unit u) {
		u.mana = u.mana -10; 
	}
}
class Marine extends Unit {
	Marine(int mana){ super(mana); }
	
}
class Zealut  extends Unit {
	Zealut(int mana){ super(mana); }
}
class Hydra  extends Unit {
	Hydra(int mana){ super(mana); }
}
class Medic {
	void recover(Unit u) { u.mana = 100; }
	
}

public class Study2 {
	public static void main(String[] args) {
		Marine m = new Marine(100);
		Zealut z = new Zealut(100);
		Hydra h = new Hydra(100);
		m.attack(h); //머린이 히드라 공격
		m.attack(h); //머린이 질럿 공격
		h.attack(m); //히드라가 머린을 공격
		h.attack(z); //히드라가 질럿을 공격
		System.out.println(m.mana);
		System.out.println(z.mana);
		System.out.println(h.mana);
		Medic medic = new Medic();
		medic.recover(m);
		medic.recover(z);
		medic.recover(h);
		System.out.println(m.mana);
		System.out.println(z.mana);
		System.out.println(h.mana);
	}
}

//상속을 사용하지 않은 설계

/*
 * public class Study2 { public static void main(String[] args) { Marine m = new
 * Marine(100); Zilet z = new Zilet(100); Hydra h = new Hydra(100);
 * m.attakHydra(h);;//머린이 히드라 공격 m.attackZilet(z);//머린이 질럿 공격
 * h.attackMarine(m);//히드라가 머린을 공격 h.attackZilet(z);//히드라가 질럿을 공격
 * System.out.println(m.mana);//머린의 마나 출력 System.out.println(z.mana);//질럿의 마나 출력
 * System.out.println(h.mana);//히드라의 마나 출력 Medic medic = new Medic();
 * medic.recoverMarine(m); medic.recoverZilet(z); medic.recoverHydra(h);
 * System.out.println(m.mana);//머린의 마나 출력 System.out.println(z.mana);//질럿의 마나 출력
 * System.out.println(h.mana);//히드라의 마나 출력 } }
 * 
 * class Unit{ int mana; double a = Math.PI;//상자이름이 PI -> 자바컴파일러가 네모에 딱 올라갈때
 * Unit(int mana){this.mana = mana;} void attak(Unit u) {u.mana=u.mana-10;} }
 * 
 * class Medic{ void recoverMarine(Marine m) { m.mana = 100; } void
 * recoverZilet(Zilet z) { z.mana = 100; } void recoverHydra(Hydra h) { h.mana =
 * 100; } }
 * 
 * class Marine extends Unit{ Marine(int mana){super(mana);} void
 * attackMarine(Marine m) {m.mana = m.mana - 10;}//상대방 머린을 공격 void
 * attackZilet(Zilet z) {z.mana = z.mana - 10;}//상대방 질럿을 공격 void
 * attakHydra(Hydra h) {h.mana = h.mana - 10;}//상대방 히드라를 공격 } class Zilet
 * extends Unit{ int mana; Zilet(int mana){super(mana);} void
 * attackMarine(Marine m) {m.mana = m.mana - 10;}//상대방 머린을 공격 void
 * attackZilet(Zilet z) {z.mana = z.mana - 10;}//상대방 질럿을 공격 void
 * attakHydra(Hydra h) {h.mana = h.mana - 10;}//상대방 히드라를 공격 } class Hydra
 * extends Unit{ int mana; Hydra(int mana){super(mana);} void
 * attackMarine(Marine m) {m.mana = m.mana - 10;}//상대방 머린을 공격 void
 * attackZilet(Zilet z) {z.mana = z.mana - 10;}//상대방 질럿을 공격 void
 * attakHydra(Hydra h) {h.mana = h.mana - 10;}//상대방 히드라를 공격 }
 */
