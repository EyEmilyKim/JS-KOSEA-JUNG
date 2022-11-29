package mytest;

public class Test_substring {
	String str13 = "8989891111100";
	
	public static void main(String[] args) {
		Test_substring t1 = new Test_substring();
		String str11 = t1.str13.substring(0, 11);
		
		System.out.println("str13 : "+t1.str13);
		System.out.println("str11 : "+str11);
		System.out.println("str11.length() : "+str11.length());
	}
}
