package aug19;

//자바 주식회사가 있습니다. 이 회사에는 영업부,개발부가 있습니다. 
//영업부에 아베와 오가와, 개발부에 나카지마, 후지타, 아오키 직원이 있습니다. 
//모든 직원들은 월급을 받습니다.(월급은 난수를 사용합니다.) 
//1.각 부서에 과장이 있습니다. 
//영업부 과정이 영업부 부하 직원의 월급의 합과 평균을 출력합니다.
//개발부 과장이 개발부 부하 직원의 월급의 합과 평균을 출력합니다.
//2.자바 주식회사에 사장이 있습니다. 
//사장이 모든 부하 직원의 월급의 합과 평균을 출력합니다.
class SWManager {
	public SWManager() {}
	void sumNavg(SWDept d) {
		int sum = d.n.salary + d.f.salary + d.ak.salary;
		double avg = sum / 3.0;
		System.out.println("--개발부의 합:"+sum+", 평균:"+avg);
	}
}
class SalesManager {
	public SalesManager() {}
	void sumNavg(SalesDept d) {
		int sum = d.abe.salary + d.ogawa.salary;
		double avg = sum / 2.0;
		System.out.println("--영업부의 합:"+sum+", 평균:"+avg);
	}
}
class Nakajima {
	int salary;
	Nakajima(){ salary = (int)(Math.random()*5+1); }
}
class Fujita {
	int salary;
	Fujita(){ salary = (int)(Math.random()*5+1); }
}
class Aoki {
	int salary;
	Aoki(){ salary = (int)(Math.random()*5+1); }
}
class Abe {
	int salary;
	Abe(){ salary = (int)(Math.random()*5+1); }
}
class Ogawa {
	int salary;
	Ogawa(){ salary = (int)(Math.random()*5+1); }
}
class SWDept{
	SWDept(){ n = new Nakajima(); f = new Fujita(); ak = new Aoki(); manager = new SWManager(); }
	Nakajima n; Fujita f; Aoki ak; SWManager manager;
}	
class SalesDept{
	SalesDept(){ abe = new Abe(); ogawa = new Ogawa(); manager = new SalesManager(); }
	Abe abe; Ogawa ogawa; SalesManager manager;
}
class JavaCompany {
	JavaCompany(){ sd = new SalesDept(); sw = new SWDept(); }
	SalesDept sd; SWDept sw;
}

public class Aug19Study2_tr {
	public static void main(String[] args) {
		JavaCompany jc = new JavaCompany();
		System.out.println("아베:"+jc.sd.abe.salary);
		System.out.println("오가와:"+jc.sd.ogawa.salary);
		jc.sd.manager.sumNavg(jc.sd);
		System.out.println("나카지마:"+jc.sw.n.salary);
		System.out.println("후지타:"+jc.sw.f.salary);
		System.out.println("아오키:"+jc.sw.ak.salary);
		jc.sw.manager.sumNavg(jc.sw);
	}

}
