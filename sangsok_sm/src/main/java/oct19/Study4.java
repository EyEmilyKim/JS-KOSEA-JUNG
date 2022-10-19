package oct19;

//게임에 등장하는 캐릭터와 무기를 설계합니다.
//캐릭터: 왕(King), 기사(Knight), 왕비(Queen)
//무기: 칼(Sword), 도끼(Axe), 활(Bow)

abstract class GameCharacter {
	Weapon w;
	abstract void whoAmI();
	void fight() { whoAmI(); w.useWeapon(); }
}

class King extends GameCharacter {
	King(){ w = new Sword();}
	void whoAmI() {System.out.println("나는 왕이로소이다.");}
}
class Queen extends GameCharacter {
	Queen(){ w = new Axe();}
	void whoAmI() {System.out.println("나는 여왕이로소이다.");}
}
class Knight extends GameCharacter {
	Knight(){ w = new Knife();}
	void whoAmI() {System.out.println("나는 기사로소이다.");}
}

interface Weapon {
	abstract void useWeapon();
}

class Sword implements Weapon {
	public void useWeapon() {System.out.println("검 사용");}
}
class Axe implements Weapon {
	public void useWeapon() {System.out.println("도끼 사용");}
}
class Bow implements Weapon {
	public void useWeapon() {System.out.println("활 사용");}
}
class Knife implements Weapon {
	public void useWeapon() { System.out.println("단검 사용");}
}

public class Study4 {
	public static void main(String[] args) {
		King k = new King();
		k.fight();
		Queen q = new Queen();
		q.fight();
		Knight kn = new Knight();
		kn.fight();
	}
}
