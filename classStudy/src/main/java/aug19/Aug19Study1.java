package aug19;

//와타나베 학생이 있다. 점수가 있다.(난수 0~100)
//이토 학생이 있다. 점수가 있다.
//장미반에 와타나베와 이토 학생이 있다. 
//가토 학생이 있다. 점수가 있다.
//요시다 학생이 있다. 점수가 있다.
//백합반에 가토와 요시다 학생이 있다.
//담임 선생님이 모든 학생의 점수의 합과 평균을 계산한다.
class Watanabe {
	Watanabe(){ score = (int)(Math.random()*101); }
	int score;
}
class Ito {
	Ito(){ score = (int)(Math.random()*101); }
	int score;
}
class Kato {
	Kato(){ score = (int)(Math.random()*101); }
	int score;
}
class Yoshida {
	Yoshida(){ score = (int)(Math.random()*101); }
	int score;
}
class JangmiClass {
	JangmiClass(){ w = new Watanabe(); i = new Ito(); }
	Watanabe w; Ito i;
}
class BaekhapClass {
	BaekhapClass(){ k = new Kato(); y = new Yoshida();
	}
	Kato k; Yoshida y; 
}
class Teacher {
	Teacher(){};
	void sumNavg(JangmiClass j,  BaekhapClass b) {
		int sum = j.w.score + j.i.score + b.k.score + b.y.score;
		double avg = (double)(sum / 4.0);
		System.out.println("합:"+sum+", 평균:"+avg);
	}
}
public class Aug19Study1 {
	public static void main(String[] args) {
		JangmiClass j = new JangmiClass();
		BaekhapClass b = new BaekhapClass();
		Teacher t = new Teacher();
		t.sumNavg(j, b);
		System.out.println("장미_와타나베:"+j.w.score);
		System.out.println("장미_이토:"+j.i.score);
		System.out.println("백합_가토:"+b.k.score);
		System.out.println("백합_요시다:"+b.y.score);
	}
}
