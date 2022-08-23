package aug23;

//this제어자, this생성자
//게임에 등장하는 영웅(King, Knight, Magician)설계
//사용하는 무기(Axe, Sword, Wand)설계
//무기별 데미지: 도끼(100), 칼(150), 완드(50)
class Knight{
	Axe axe; Sword sword; Wand wand;
	
	Knight(Axe a, Sword s, Wand w){ this.axe=a; this.sword=s; this.wand=w; }
	Knight(Axe a, Sword s){ this(a, s, null); }
	Knight(Axe a, Wand w){ this(a, null, w); }
	Knight(Sword s, Wand w){ this(null, s, w); }
	Knight(Axe a){ this(a, null, null); }
	Knight(Sword s){ this(null, s, null); }
	Knight(Wand w){ this(null, null, w); }
	Knight(){ this(null, null, null); }
	
	void showWeapon() {
		if(axe != null) System.out.println("도끼를 가지고 있음");
		if(sword != null) System.out.println("칼을 가지고 있음");
		if(wand != null) System.out.println("완드를 가지고 있음");
		if(axe == null && sword == null && wand == null) System.out.println("아무것도 없음");
	}
}

class King{
	Axe axe; Sword sword; Wand wand;

	void showWeapon() {
		if(axe == null && sword == null && wand == null) {
			System.out.println("아무것도 없음");
		}if(axe != null) {
			System.out.println("도끼를 가지고 있음");
		}if(sword != null) {
			System.out.println("칼을 가지고 있음");
		}if(wand != null) {
			System.out.println("완드를 가지고 있음");
		}
	}
	
	//무기가 없는 King
	King(){}
	//도끼만 있는 King
	King(Axe axe){
//		this.axe = axe; 
		this(axe, null, null);
	}
	//칼만 있는 King
	King(Sword sword){
//		this.sword = sword; 
		this(null, sword, null);
	}
	//완드만 있는 King
	King(Wand wand){
//		this.wand = wand; 
		this(null, null, wand);
	}
	//도끼와 칼이 있는 king
	King(Axe axe, Sword sword){
//		this.axe = axe; this.sword = sword; 
		this(axe, sword, null);
	}
	//도끼와 완드가 있는 King
	King(Axe axe, Wand wand){
//		this.axe = axe; this.wand = wand; 
		this(axe, null, wand);
	}
	//칼과 완드가 있는 King
	King(Sword sword, Wand wand){
//		this.sword = sword; this.wand = wand;
		this(null, sword, wand);
	}
	//도끼와 칼과 완드가 있는 King
	King(Axe axe, Sword sword, Wand wand){ 
		this.axe = axe; this.sword = sword; this.wand = wand; }
}

class Wand {
	int damage; 
	Wand() { damage = 50; }
}
class Sword {
	int damage; 
	Sword() { damage = 150; }
}
class Axe {
	int damage; 
	Axe() { damage = 100; }
}

public class Aug23study2 {
	public static void main(String[] args) {
		King k1 = new King();
		System.out.println("=====k1=====");
		k1.showWeapon();
		King k2 = new King(new Axe(), new Sword());
		System.out.println("=====k2=====");
		k2.showWeapon();
		King k3 = new King(new Sword());
		System.out.println("=====k3=====");
		k3.showWeapon();
		System.out.println();
		
		Knight kn1 = new Knight();
		System.out.println("=====kn1=====");
		kn1.showWeapon();
		Knight kn2 = new Knight(new Axe(), new Wand());
		System.out.println("=====kn2=====");
		kn2.showWeapon();
		System.out.println();
	}
}
