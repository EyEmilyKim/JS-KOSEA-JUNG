package aug17;

//고바야시와 다나까가 있다. //고바야시와 다나까가 멀리뛰기를 했다.
//고바야시와 다나까의 기록을 출력한다.
//스즈키가 고바야시와 다나까의 기록을 비교해서 승패를 판단한다.
//클래스를 찾는 작업(SRP)
//((과제))
//고바야시와 다나까가 높이뛰기를 했습니다.
//사토가 고바야시와 다나까의 기록을 비교해서 높이뛰기 승패를 판단합니다.
class Kobayashi {
	double record = 0;
	double recordH = 0;
	Kobayashi(){}
	void jump() {
		record = (int)((Math.random()*3000)+1)/10.0;
	}
	void jumpHigh() {
		recordH = (int)(Math.random()*4000+1)/10.0;
	}
}
class Tanaka {
	double record = 0;
	double recordH = 0;
	Tanaka(){}
	void jump() {
		record = (int)((Math.random()*3000)+1)/10.0;
	}
	void jumpHigh() {
		recordH = (int)(Math.random()*4000+1)/10.0;
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
class Sato{
	Sato(){}
	void winner(double KrecH, double TrecH) {
		if(KrecH > TrecH) { System.out.println("Kobayashi 승");
		}else if(KrecH < TrecH) { System.out.println("Tanaka 승");
		}else { System.out.println("무승부"); }
	}
}
public class Aug17study2 {
	public static void main(String[] args) {
		Kobayashi k = new Kobayashi();
		Tanaka t = new Tanaka();
		System.out.println("--멀리뛰기--");
		System.out.println("뛰기 전 K: "+k.record);
		System.out.println("뛰기 전 T: "+t.record);
		k.jump();
		t.jump();
		System.out.println("뛴 후 K: "+k.record);
		System.out.println("뛴 후 T: "+t.record);
		Suzuki s = new Suzuki();
		s.winner(k.record, t.record);
		s.winner2(k, t);
		
		System.out.println("--높이뛰기--");
		System.out.println("뛰기 전 K: "+k.recordH);
		System.out.println("뛰기 전 T: "+t.recordH);
		k.jumpHigh();
		t.jumpHigh();
		System.out.println("뛴 후 K: "+k.recordH);
		System.out.println("뛴 후 T: "+t.recordH);
		Sato st = new Sato();
		st.winner(k.recordH, t.recordH);
	}

}
