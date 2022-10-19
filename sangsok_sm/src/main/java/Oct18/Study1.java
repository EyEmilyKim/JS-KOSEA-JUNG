package Oct18;

//용돈 100만원을 가지고 있는 고바야시가 물건 세개를 구입한 후
//잔액을 출력하는 프로그램
class Gobayasi{
	int pocketMoney;
	Gobayasi(int money){pocketMoney = money; }
	void buy(Computer c) { //컴퓨터를 구매하는 메서드
	//고바야시의 용돈에서 컴퓨터의 가격이 차감된다.
		pocketMoney = pocketMoney - c.price; 
		
	}
	void buy(Jean j) { //청바지를 구매하는 메서드
		pocketMoney = pocketMoney - j.price;
	}
	void buy(Orange o) { //오렌지를 구매하는 메서드
		pocketMoney = pocketMoney - o.price;
	}
}
class Item {
	int price;
	Item(int price){this.price = price; }
}
class Orange extends Item {
	Orange(int price) { super(price); }
}
class Jean  extends Item {
	Jean(int price) { super(price); }
}

class Computer extends Item {
	Computer(int price) { super(price);	}
}

public class Study1 {
	public static void main(String[] args) {
		Computer c = new Computer(50);
		Jean j = new Jean(10);
		Orange o = new Orange(2);
		Gobayasi goba = new Gobayasi(100);
		goba.buy(c);
		goba.buy(j);
		goba.buy(o);
		System.out.println("구매 후 잔액"+goba.pocketMoney+"만원");
	}
}
