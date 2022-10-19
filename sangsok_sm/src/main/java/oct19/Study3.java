package oct19;

interface Bird {
	int MAX_SPEED = 60;
	void fly();
}
interface Horse{
	void run();
}
class Pegasus implements Bird, Horse{
	public void run() {
		System.out.println("말처럼 뛴다.");
	}

	public void fly() {
		System.out.println("새처럼 난다.");
	}
	
}
public class Study3 {
	public static void main(String[] args) {
		Pegasus p = new Pegasus();
		p.fly();
		p.run();
	}

}
