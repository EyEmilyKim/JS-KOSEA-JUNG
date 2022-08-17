package aug17;

//고바야시와 다나까가 있다. //고바야시와 다나까가 멀리뛰기를 했다.
//고바야시와 다나까의 기록을 출력한다.
//스즈키가 고바야시와 다나까의 기록을 비교해서 승패를 판단한다.
//클래스를 찾는 작업(SRP)
class Kobayashi {
	double record = 0;
	Kobayashi(){}
	void jump() {
		record = (int)((Math.random()*3000)+1)/10.0;
	}
}
class Tanaka {
	double record = 0;
	Tanaka(){}
	void jump() {
		record = (int)((Math.random()*3000)+1)/10.0;
	}
}
class Suzuki {
	Suzuki(){}
	void winner(double recK, double recT){
		if(recK == recT) { System.out.println("무승부");
		}else if(recK > recT) { System.out.println("Kobayashi 승");
		}else { System.out.println("Tanaka 승"); }
	}
	void winner2(Kobayashi k,Tanaka t) {
		if(k.record > t.record){ System.out.println("Kobayashi 승");
		}else if(k.record < t.record){ System.out.println("Tanaka 승");
		}else { System.out.println("무승부");}
	}
}
public class Aug17study2 {
	public static void main(String[] args) {
		Kobayashi k = new Kobayashi();
		Tanaka t = new Tanaka();
		System.out.println("뛰기 전 K: "+k.record);
		System.out.println("뛰기 전 T: "+t.record);
		k.jump();
		t.jump();
		System.out.println("뛴 후 K: "+k.record);
		System.out.println("뛴 후 T: "+t.record);
		Suzuki s = new Suzuki();
		s.winner(k.record, t.record);
		s.winner2(k, t);
	}

}
