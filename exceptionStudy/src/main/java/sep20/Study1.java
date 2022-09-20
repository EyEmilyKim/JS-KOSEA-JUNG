package sep20;

public class Study1 {

	public static void main(String[] args) {
		// 예외발생 프로그램(0으로 나눔)
		int num1 = 5;
		int num2 = 0;
		try {
			int result = num1 / num2;
			System.out.println(result);
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없음.");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("종료");
	}

}
