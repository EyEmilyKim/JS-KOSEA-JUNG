package test;

//Math.ceil() : 소수점 이하 숫자를 올림하여 정수를 리턴합니다.
//Math.floor() : 소수점 이하 숫자를 버림하여 정수를 리턴합니다.
//Math.round() : 소수점 이하 숫자를 반올림하여 정수를 리턴합니다.
//Number.toFixed(n) : 숫자를 소수점 n자리로 반올림합니다. n자리 이후의 숫자를 제거.

public class Round {
	Integer mid = 95;
	Integer fin = 80;
			
	public static void main(String[] args) {
		Round r = new Round();
		float avg = (r.mid+r.fin)/2;
		Integer round = Math.round(avg);
		Integer ceil = (int) Math.ceil(avg);
		Integer floor = (int) Math.floor(avg);
//		float toFix2 = Number.toFixed(avg);
		
		System.out.println("avg : "+avg);
		System.out.println("round : "+round);
		System.out.println("ceil : "+ceil);
		System.out.println("floor : "+floor);
		
		
	}
}
