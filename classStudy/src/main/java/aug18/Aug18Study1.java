package aug18;

//1.지갑이 있다. 지갑 안에 만원이 있다.
//2.와타나베가 용돈을 가지고 있다. 와타나베가 십만원을 가지고 있다.
//3.새우깡이 있다. 가격은 5천원이다.
//4.롯데마트가 있다. 롯데마트에 새우깡이 있다.
//5.와타나베가 지갑의 돈으로 롯데마트에 있는 새우깡을 산다.
//6.와타나베가 자신의 용돈으로 롯데마트에 있는 새우깡을 산다.
//7.지갑 안에 잔액을 출력한다. (정답:5,000)
//8.와타나베의 용돈을 출력한다. (정답:95,000)
class Wallet{
	int money;
	Wallet(){//생성자(constructor):인스턴스 초기화 메서드
		money = 10000;
	}
}
class Watanabe{
	int money;
	Wallet w;
	Watanabe(){
		money = 100000; 
		w = new Wallet();
	}
	void buy(int price) {//용돈으로 새우깡 구매하는 메서드
		money = money - price;
	}
	void buyWallet(int price) {//지갑의 돈으로 새우깡 구매하는 메서드
		w.money = w.money - price;
	}
}
class Saewoo{
	int price;
	Saewoo(){ price = 5000; }
}
class LotteMart{
	Saewoo s;
	LotteMart(){ s = new Saewoo();}
	
}
public class Aug18Study1 {
	public static void main(String[] args) {
		Wallet w = new Wallet();
		System.out.println(w.money);
		
		Watanabe wa = new Watanabe();
		System.out.println(wa.money);
		//(문제)와타나베가 가지고 있는 지갑 안의 돈을 출력		
		System.out.println(wa.w.money);
		
		//(문제)롯데마트에 있는 새우깡의 가격을 출력하라
		Saewoo sae = new Saewoo();
		System.out.println(sae.price);//(X)
		LotteMart lm = new LotteMart();
		System.out.println(lm.s.price);//(O)
		
		//와타나베가 자신의 용돈으로 롯데마트에 있는 새우깡을 산다. 
		wa.buy(lm.s.price);//(O)
		System.out.println("와타나베가 가진 용돈의 잔액: "+wa.money);
		wa.buyWallet(lm.s.price);//(X)
		System.out.println("와타나베가 가진 지갑 안의 잔액: "+wa.w.money);
		
	}

}
