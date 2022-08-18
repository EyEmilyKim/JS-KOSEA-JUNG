package aug18;

//장미꽃이 있습니다. 가격은 5천원입니다.//국화꽃이 있습니다. 가격은 만원입니다.
//장미꽃이 자바 꽃 집에 있습니다. //국화꽃이 바자 꽃 집에 있습니다.
//이토군이 오만원을 가지고 있습니다.
//이토군이 자바 꽃 집에서 장미꽃을 샀습니다.
//이토군이 바자 꽃 집에서 국화꽃을 샀습니다.
//이토군의 용돈의 잔액을 출력합니다.

class Rose{
	Rose(){ price = 5000;}
	int price;
}
class Kiku{
	Kiku(){ price = 10000;}
	int price;
}
class javaFlower{
	Rose r;
	Kiku k;
	javaFlower(){
		r = new Rose();
		k = new Kiku();
	}
}
class Ito{
	int money;
	Ito(){ money = 50000;}
	void buy(int price){
		money = money - price;
	}
}


public class Aug18Study2 {
	
	public static void main(String[] args) {
	javaFlower jf = new javaFlower();
	Ito ito = new Ito();
	System.out.println("초기 잔고:"+ito.money);
	ito.buy(jf.r.price);
	ito.buy(jf.k.price);
	System.out.println("구입 후 잔고:"+ito.money);
	
	}
}
