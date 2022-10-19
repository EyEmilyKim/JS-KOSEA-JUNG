package oct19;

interface Tiger {
	static final int MAX = 10;
	void doIt();
	void doDo();
	int doSome();
}
class Cat implements Tiger{
	public void doIt() {}
	public void doDo() {}
	public void doSome(){ return 1; }
}
public class Study2 {
	public static void main(String[] args) {
		int a = Tiger.MAX;
	}

}
