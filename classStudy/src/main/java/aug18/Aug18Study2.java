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
class JavaFlower{
	Rose r;
	JavaFlower(){
		r = new Rose();
	}
}
class VajaFlower{
	Kiku k;
	VajaFlower(){
		k = new Kiku();
	}
}
class Ito{
	int money;
	Ito(){ money = 50000; }
//	void buy(int price){
//		money = money - price;
	//↑뭔가를 사는 메서드..인데 아무 정수나 들어와도 돼버리니까 ↓처럼 설계.
	void buy(Rose price) {//장미를 사는 메서드
		money = money - price.price;
	}
	void buy(Kiku price) {//국화를 사는 메서드
		money = money - price.price;
	}

}


public class Aug18Study2 {
	
	public static void main(String[] args){
	JavaFlower jf = new JavaFlower();
	VajaFlower vf = new VajaFlower();
	Ito ito = new Ito();
	System.out.println("초기 잔고:"+ito.money);
//	ito.buy(jf.r.price);
//	ito.buy(bf.k.price);
	ito.buy(jf.r);
	ito.buy(vf.k);
	System.out.println("구입 후 잔고:"+ito.money);
	
	}
}
