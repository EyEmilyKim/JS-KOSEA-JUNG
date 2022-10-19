package Oct17;

class IamKing{
	String name;
	IamKing(String name){this.name = name;} //생성자
}
class IamSon extends IamKing{
	IamSon(String name){super(name);}
}
public class Study1 {
	public static void main(String[] args) {
		IamSon s = new IamSon("왕건");
		System.out.println(s.name);
		IamSon s2 = new IamSon("장수");
		System.out.println(s2.name);
		IamKing k = new IamKing("세종");
		System.out.println(k.name);
		IamKing y = new IamKing("광개토");
		System.out.println(y.name);
	}
}