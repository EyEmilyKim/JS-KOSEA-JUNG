package oct19;

class Printer {
	private Printer(){}
	static private Printer p = new Printer();
	static Printer getInstance() {
		return p;
	}
}
class A {
	int doIt() {return 100;}
}
class Human{
	String name;
}
public class Study1 {
	public static void main(String[] args) {
		A a = new A(); int t = a.doIt(); //static 아닌 일반 메서드
		double random = Math.random(); //static 메서드
		
		Printer p1 = Printer.getInstance(); //static 메서드!
		Printer p2 = Printer.getInstance();
		if(p1 == p2) {
			System.out.println("같다.");
		}else {
			System.out.println("다르다.");
		}
		
		Human h1 = new Human(); h1.name = "고바야시";
		Human h2 = new Human(); h2.name = "다나까";
		
	}

}
