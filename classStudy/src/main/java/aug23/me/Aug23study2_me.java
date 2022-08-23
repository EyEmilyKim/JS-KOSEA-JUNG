package aug23.me;

import java.util.ArrayList;

import org.eclipse.jdt.internal.compiler.ast.ArrayAllocationExpression;

//this제어자, this생성자
//게임에 등장하는 영웅(King, Knight, Magician)설계
//사용하는 무기(Axe, Sword, Wand)설계
//무기별 데미지: 도끼(100), 칼(150), 완드(50)

class Magician {
	Weapon W1; Weapon W2; Weapon W3; 
	
	Magician(Weapon a, Weapon b, Weapon c){	this.W1=a; this.W2=b; this.W3=c; }
	Magician(Weapon a, Weapon b){	this(a, b, null); }
	Magician(Weapon a){	this(a, null, null); }
	Magician(){ this(null,null,null); }

	void setWeapon() {
		ArrayList<Weapon> wList = new ArrayList<Weapon>();
		wList.add(W1);
		wList.add(W2);
		wList.add(W3);
		for(Weapon w : wList) {
			try {
				w.attack();	
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	void downcastWeapon() {
		
	}
	void showWeapon() {
		if(axe != null) System.out.println("도끼를 가지고 있음");
		if(sword != null) System.out.println("칼을 가지고 있음");
		if(wand != null) System.out.println("완드를 가지고 있음");
		if(axe == null && sword == null && wand == null) System.out.println("아무것도 없음");
	}
}
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

class Wand extends Weapon {
	Wand() { this.damage = 50; }
	void attack() { System.out.println("완드로 공격했다."); }
}
class Sword extends Weapon {
	Sword() { this.damage = 150; }
	void attack() { System.out.println("칼로 공격했다."); }
}
class Axe extends Weapon {
	Axe() { this.damage = 100; }
	void attack() { System.out.println("도끼로 공격했다."); }
}
class Weapon {
	int damage;
	void attack() { System.out.println("무기로 공격했다."); }
}
public class Aug23study2_me {
	public static void main(String[] args) {
//		King k1 = new King();
//		System.out.println("=====k1=====");
//		k1.showWeapon();
//		King k2 = new King(new Axe(), new Sword());
//		System.out.println("=====k2=====");
//		k2.showWeapon();
//		King k3 = new King(new Sword());
//		System.out.println("=====k3=====");
//		k3.showWeapon();
//		System.out.println();
//		
//		Knight kn1 = new Knight();
//		System.out.println("=====kn1=====");
//		kn1.showWeapon();
//		Knight kn2 = new Knight(new Axe(), new Wand());
//		System.out.println("=====kn2=====");
//		kn2.showWeapon();
//		System.out.println();
		
		Magician m1 = new Magician(new Sword(), new Wand());
		m1.setWeapon();
//		m1.showWeapon();
	}
}
