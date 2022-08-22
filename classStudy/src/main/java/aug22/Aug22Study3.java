package aug22;

//생성자의 오버로딩 예제
//1.동물원 객체 예제 
class JavaZoo {
	JavaZoo(String a) { name = a; }
	String name;
}
class Tiger {
	Tiger(){ weight = 130; name = "오라이"; }
	Tiger(String a){ name = a; }
	Tiger(int a){ weight = a; }
	Tiger(String a, int b){ name = a; weight = b; }
	Tiger(int a, String b){ weight = a; name = b; }

	int weight; String name;
}

//2. 쇼핑몰의 회원가입용 고객 객체 설계
//이름*, 주소*, 연락처*, 성별*, 나이, 몸무게, 신장 (*:필수항목)
class Customer {
	Customer(String a, String b, String c, char d){
		name = a; addr = b; phone = c; gender = d;
	}//c1
	Customer(String a, String b, String c, char d, int e){
		name = a; addr = b; phone = c; gender = d; age = e;
	}//c2
	Customer(String a, String b, String c, char d, double f){
		name = a; addr = b; phone = c; gender = d; weight =f;
	}//c3
	Customer(String a, String b, String c, char d, int e, double f){
		name = a; addr = b; phone = c; gender = d; age = e; weight =f;
	}//c5
	Customer(String a, String b, String c, char d, double e, int f){
		name = a; addr = b; phone = c; gender = d; age = f; weight =e;
	}//c6
	String name; String addr; String phone; char gender;
	int age; double weight; double height;
	
}
public class Aug22Study3 {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		System.out.println("t1 "+t1.name);
		System.out.println("t1 "+t1.weight);
		t1.name = "호돌이";
		System.out.println("t1 "+t1.name);
		Tiger t2 = new Tiger("호롱이");
		System.out.println("t2 "+t2.name);
		Tiger t3 = new Tiger(10);
		System.out.println("t3 "+t3.weight);
		Tiger t4 = new Tiger("호빵이", 50);
		System.out.println("t4 "+t4.name);
		System.out.println("t4 "+t4.weight);
		Tiger t5 = new Tiger(80, "호호바");
		System.out.println("t5 "+t5.name);
		System.out.println("t5 "+t5.weight+"\n");
		
		Customer c1 = new Customer("홍길동","서울","010",'M');
		Customer c2 = new Customer("이길동","서울","010",'M',32);
		Customer c3 = new Customer("나길동","서울","010",'M',95.1);
		Customer c4 = new Customer("나길동","서울","010",'M',173.5);
		//c4의 case를 위한 생성자 설계는 불가능하다. c3과 시그니처 중복.
		Customer c5 = new Customer("고길동","서울","010",'F',23,50.5);
		Customer c6 = new Customer("박길동","서울","010",'F',50.5,23);
	}
}
