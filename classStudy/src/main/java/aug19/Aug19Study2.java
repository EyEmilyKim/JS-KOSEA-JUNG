package aug19;

//자바 주식회사가 있습니다. 이 회사에는 영업부,개발부가 있습니다. 
//영업부에 아베와 오가와, 개발부에 나카지마, 후지타, 아코기 직원이 있습니다. 
//모든 직원들은 월급을 받습니다.(월급은 난수를 사용합니다.) 
//1.각 부서에 과장이 있습니다. 
//영업부 과정이 영업부 부하 직원의 월급의 합과 평균을 출력합니다.
//개발부 과장이 개발부 부하 직원의 월급의 합과 평균을 출력합니다.
//2.자바 주식회사에 사장이 있습니다. 
//사장이 모든 부하 직원의 월급의 합과 평균을 출력합니다.

class Employee{
	int salary;
	Employee(){ salary = (int)(Math.random()*101+200); }
}
class ChiefS{
	int salary; int sum; int sumA;
	ChiefS(){ salary = (int)((Math.random()*101+200)+100); }
	void avgSalary(SalesDiv SD) {
		sum = SD.abe.salary +SD.ogawa.salary;
		double avg = sum / 2.0;
		sumA = sum +SD.chiefS.salary;
		double avgA = sumA / 3.0;
		System.out.println("영업부)부원_ 합:"+sum+", 평균:"+avg);
		System.out.println("abe:"+SD.abe.salary);
		System.out.println("ogawa:"+SD.ogawa.salary);
//		System.out.println("영업부)전체_ 합:"+sumA+", 평균:"+avgA);
//		System.out.println("chiefS:"+SD.chiefS.salary+"\n");
	}
}
class ChiefD {
	int salary; int sum; int sumA;
	ChiefD(){ salary = (int)((Math.random()*101+200)+100); }
	void avgSalary(DebDiv DD) {
		sum = DD.nakajima.salary +DD.fujita.salary +DD.akogi.salary;
		double avg = sum / 3.0;
		sumA = sum +DD.chiefD.salary;
		double avgA = sumA / 4.0;
		System.out.println("개발부)부원_ 합:"+sum+", 평균:"+avg);
		System.out.println("nakajima:"+DD.nakajima.salary);
		System.out.println("fujita:"+DD.fujita.salary);
		System.out.println("akogi:"+DD.akogi.salary);
//		System.out.println("개발부)전체_ 합:"+sumA+", 평균:"+avgA);
//		System.out.println("chiefD:"+DD.chiefD.salary+"\n");
	}
}
class President {
	int salary;
	President(){ salary = (int)((Math.random()*101+200)+500); }
	void avgSalary(ChiefS cs, ChiefD cd) {
		int sumSD = cs.sumA + cd.sumA;
		double avgSD  = sumSD / 7.0;
		System.out.println("영업부+개발부)부하_ 합:"+sumSD+", 평균:"+avgSD);
		int sumA = sumSD + salary;
		double avgA = sumA / 8.0;
//		System.out.println("영업부+개발부)전체_ 합:"+sumA+", 평균:"+avgA);
	}
	
}
class SalesDiv {//영업부- 아베, 오가와
	Employee abe;
	Employee ogawa;
	ChiefS chiefS;
	SalesDiv(){
		abe = new Employee();
		ogawa = new Employee();
		chiefS = new ChiefS();
	}
}
class DebDiv {//개발부- 나카지마, 후지타, 아코기
	Employee nakajima;
	Employee fujita;
	Employee akogi;
	ChiefD chiefD;
	DebDiv(){
		nakajima = new Employee();
		fujita = new Employee();
		akogi = new Employee();
		chiefD = new ChiefD();
	}
}
class Company {
	SalesDiv SD;
	DebDiv DD;
	President P;
	Company(){ SD = new SalesDiv(); DD = new DebDiv(); P = new President(); }
}

public class Aug19Study2 {
	public static void main(String[] args) {
		Company JavaCom = new Company();
		JavaCom.SD.chiefS.avgSalary(JavaCom.SD);
		JavaCom.DD.chiefD.avgSalary(JavaCom.DD);
		JavaCom.P.avgSalary(JavaCom.SD.chiefS, JavaCom.DD.chiefD);
	}
}
