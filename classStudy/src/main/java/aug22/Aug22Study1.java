package aug22;

//1.자바 책방이 있다. 
//2.이 책방에 미술서적, 음악서적, 컴퓨터 서적, 교양서적이 있다.
//3.미술서적- 가격:1000원, 출판사 이름:가나출판사. 출판사 주소:경기. 
//4.음악서적- 가격:5000원, 출판사 이름:우리출판사. 출판사 주소:서울. 
//5.컴퓨터 서적- 가격:5500원. 출판사 이름:자바출판사. 페이지수:550 페이지. 
//6.교양서적- 가격:8000원, 책 제목:아름다운 청춘. 페이지수:190페이지. 
//7.이 책방에는 점원이 있다. 
//8.이 점원은 나이가 32세, 이름은 마길동, 주소는 경기도 수원시. 
//9.이 점원이 책방의 모든 책의 가격의 합을 계산하고 출력한다.
//10.이 점원이 책방의 모든 출판사 이름을 출력합니다.

class JavaBookStore {//1.자바 책방이 있다. 
	//2.이 책방에 미술서적, 음악서적, 컴퓨터 서적, 교양서적이 있다.
	//7.이 책방에는 점원이 있다. 
	JavaBookStore(){
		ab = new ArtBook(); mb = new MusicBook();
		cb = new ComputerBook(); lb = new LiberalArtBook();
		w = new Worker();
	}
	ArtBook ab; MusicBook mb; ComputerBook cb; LiberalArtBook lb; 
	Worker w;
}
class ArtBook{//3.미술서적- 가격:1000원, 출판사 이름:가나출판사. 출판사 주소:경기. 
	ArtBook(){ price = 1000; publ ="가나출판사"; addr = "경기도"; 
	}
	int price; String publ; String addr;
}
class MusicBook{//4.음악서적- 가격:5000원, 출판사 이름:우리출판사. 출판사 주소:서울. 
	MusicBook(){ price = 5000; publ ="우리출판사"; addr = "서울"; 
	}
	int price; String publ; String addr;
}
class ComputerBook{//4.음악서적- 가격:5000원, 출판사 이름:우리출판사. 출판사 주소:서울. 
	ComputerBook(){ price = 5500; publ ="자바출판사"; page = 550; 
	}
	int price; String publ; String addr; int page; 
}
class LiberalArtBook{//4.음악서적- 가격:5000원, 출판사 이름:우리출판사. 출판사 주소:서울. 
	LiberalArtBook(){ price = 8000; title ="아름다운 청춘"; page = 190; 
	}
	int price; String publ; String addr; int page; String title;
}
 
class Worker {
	Worker(){//8.이 점원은 나이가 32세, 이름은 마길동, 주소는 경기도 수원시.
		age = 32; name = "마길동"; address="경기도 수원시";
	}
	int age; String name; String address;
	//9.이 점원이 책방의 모든 책의 가격의 합을 계산하고 출력한다.
	//10.이 점원이 책방의 모든 출판사 이름을 출력합니다.
	void showSumPrice(JavaBookStore box){
		int sum = box.ab.price+box.mb.price+box.cb.price+box.lb.price;
		System.out.println("모든 책의 가격 합:\n" + sum);
	}
	void showAllPubl(JavaBookStore box){
		System.out.println("모든 책의 출판사:");
		System.out.println(box.ab.publ);
		System.out.println(box.mb.publ);
		System.out.println(box.cb.publ);
		System.out.println(box.lb.publ);
	}
}

public class Aug22Study1 {

	public static void main(String[] args) {
		JavaBookStore jbs = new JavaBookStore();
		jbs.w.showSumPrice(jbs);
		jbs.w.showAllPubl(jbs);
	}

}
