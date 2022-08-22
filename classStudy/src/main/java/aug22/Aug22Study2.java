package aug22;

//계산기가 있습니다. 이 계산기는 덧셈을 수행합니다.
//덧셈(정수+정수, 정수+실수, 실수+정수, 실수+실수)
class Calculator {
	Calculator(){}
	void add(int a, int b) {//정수+정수
		int sum = a + b;
		System.out.println(a+"+"+b+"="+sum);
	}
	void add(int a, double b) {//정수+실수
		double sum = a + b;
		System.out.println(a+"+"+b+"="+sum);
	}
	void add(double a, int b) {//실수+정수
		double sum = a + b;
		System.out.println(a+"+"+b+"="+sum);
	}
	void add(double a, double b) {//실수+실수
		double sum = a + b;
		System.out.println(a+"+"+b+"="+sum);
	}
}

public class Aug22Study2 {

	public static void main(String[] args) {
		Calculator c = new Calculator();
		c.add(10, 20);
		c.add(10, 20.5);
		c.add(10.5, 20);
		c.add(10.5, 20.5);
		
		byte b1 = 10; short s1 = 11; int i1 =12;
		long l1 = 13; float f1 = 14.1f; double d1 = 20.5;
		char c1 = 'A'; boolean bo = true;
		String s = "KOREA";
		
		System.out.println(b1);
		System.out.println(s1);
		System.out.println(i1);
		System.out.println(l1);
		System.out.println(f1);
		System.out.println(d1);
		System.out.println(c1);
		System.out.println(bo);
		System.out.println(s);
	}

}
