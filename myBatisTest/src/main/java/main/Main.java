package main;

import crud.Crud;
import model.Test;

public class Main {

	public static void main(String[] args) {
		//삽입 작업
		Test test = new Test();
		test.setNo(2);
		test.setName("나주작");
		test.setAddr("서울");
		test.setReg_date("2022-09-25");
		Crud crud = new Crud();
		int r = crud.putData(test);
		if(r > 0) System.out.println("삽입 성공!");
		else System.out.println("삽입 실패");
	}

}
