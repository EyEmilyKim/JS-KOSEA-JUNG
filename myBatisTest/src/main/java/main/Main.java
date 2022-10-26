package main;

import java.util.ArrayList;

import crud.Crud;
import model.Test;

public class Main {

	public static void main(String[] args) {
		Crud crud = new Crud();

		//삽입 작업
//		Test test = new Test();
//		test.setNo(5);
//		test.setName("하현무");
//		test.setAddr("서울");
//		test.setReg_date("2022-09-25");
//		int r = crud.putData(test);
//		if(r > 0) System.out.println("삽입 성공!");
//		else System.out.println("삽입 실패");
		
		//삭제 작업
//		int r = crud.deleteData(1);
//		if(r > 0) System.out.println("삭제 성공!");
//		else System.out.println("삭제 실패ㅠㅠ");
		
		//변경 작업
//		Test test = new Test();
//		test.setNo(2);
//		test.setName("김해치");
//		test.setAddr("서울시 경복궁");
//		test.setReg_date("2022-10-26");
//		int r = crud.updateData(test);
//		if(r > 0) System.out.println("수정 성공");
//		else System.out.println("수정 실패");
		
		//조회 (번호로 이름)
//		String name = crud.getName(2);
//		System.out.println("조회결과 : "+name);
		
		//조회 (번호로 날짜)
//		String date = crud.getDate(2);
//		System.out.println("조회결과 : "+date);
		
		//조회 (번호로 이름, 주소, 날짜)
//		Integer no = 2;
//		Test result = crud.getNameAddrDate(no);
//		System.out.println("---getNameAddrDate(no)---");
//		if(result == null) {
//			System.out.println("조회결과가 존재하지 않습니다.");
//		}else {
//			System.out.println("no : "+no);
//			System.out.println("이름 : "+result.getName());
//			System.out.println("주소 : "+result.getAddr());
//			System.out.println("날짜 : "+result.getReg_date());
//		}
		
		//조회 (번호와 이름으로/ 번호,이름,주소,날짜를 검색)
//		Integer num = 2;
//		String name = "김해치";		
//		Test test = new Test();
//		test.setNo(num);
//		test.setName(name);
//		Test result = crud.getAllByNoName(test);
//		System.out.println("---getAllByNoName(test)---");
//		System.out.println("param num = "+num);
//		System.out.println("param name = "+name);
//		if(result == null) {
//			System.out.println("조회결과가 존재하지 않습니다.");
//		}else {
//			System.out.println("번호 : "+result.getNo());
//			System.out.println("이름 : "+result.getName());
//			System.out.println("주소 : "+result.getAddr());
//			System.out.println("날짜 : "+result.getReg_date());
//		}
		
		//전체 조회
		ArrayList al = crud.getAll();
		System.out.println("---getAll()---");
		for(int i=0; i<al.size(); i++) {
			Test test = (Test)al.get(i);
			System.out.println("번호 : "+test.getNo());
			System.out.println("이름 : "+test.getName());
			System.out.println("주소 : "+test.getAddr());
			System.out.println("날짜 : "+test.getReg_date());
			System.out.println();
		}
		System.out.println("---getAll() end---");
	}

}
