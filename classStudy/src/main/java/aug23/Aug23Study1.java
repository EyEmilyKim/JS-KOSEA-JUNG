package aug23;

class Customer {
	String name; String addr; String tel; char gender; 
	Customer(String name, String addr, String tel, char gender){
		this.name = name; this.addr = addr; 
		this.tel = tel; this.gender = gender; 
	}//1.이름, 주소, 전화번호, 성별
	Customer(String name, String addr, char gender){
		this(name, addr, "", gender); 
	}//2.이름, 주소, 성별
	Customer(String name, String addr){
		this(name, addr, "", ' ');
	}//3.이름, 주소
	
	/* 인스턴스를 지칭하는 제어자(modifier): this! */
	int total = 10;
	void thisEx() {
		int total = 20;
		System.out.println(total+", "+this.total);
	}
}

public class Aug23Study1 {

	public static void main(String[] args) {
		Customer c1 = new Customer("홍길동","서울","01021212",'M');
//		c1.thisEx();
		//Customer c2 = new Customer("마길동","인천","01023333",'M',33);
		Customer c3 = new Customer("강길동","수원");
		System.out.println(c3.name);//"마길동"
		System.out.println(c3.addr);//"수원"
		System.out.println(c3.gender);//X
		
	}

}
