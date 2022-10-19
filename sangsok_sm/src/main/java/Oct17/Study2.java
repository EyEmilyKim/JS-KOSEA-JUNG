package Oct17;

class One{
	int i; String name;
	One(int i){this.i = i;}
	One(String name){this.name = name;}
}
class Two extends One{
	Two(String n){super(n);}
	Two(int n){super(n);}
	
} //생성자가 없을 대는 기본생성자가 만들어진다. 

public class Study2 {
	public static void main(String[] args) {
		Two t1 = new Two("Korea");
		Two t2 = new Two(500);
		One o1 = new One(1);
		One o2 = new One("a");
		System.out.println(o1.i);
		System.out.println(o2.name);
		System.out.println(t1.name);
		System.out.println(t2.i);
	}
}