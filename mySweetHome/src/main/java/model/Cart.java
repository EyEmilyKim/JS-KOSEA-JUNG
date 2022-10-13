package model;

import java.util.ArrayList;

public class Cart { //장바구니 객체
	//장바구니의 주인(로그인 계정)
	private String id;
	//상품 번호 
	private ArrayList<String> codeList = new ArrayList<String>();
	//상품의 갯수
	private ArrayList<Integer> numList = new ArrayList<Integer>();

	public ArrayList<String> getCodeList() {
		return codeList;
	}
	public void setCodeList(ArrayList<String> codeList) {
		this.codeList = codeList;
	}
	public ArrayList<Integer> getNumList() {
		return numList;
	}
	public void setNumList(ArrayList<Integer> numList) {
		this.numList = numList;
	}
	
	//장바구니 객체 생성자
	public Cart(String id) { this.id = id; }

	//장바구니 클릭 누를 때 codeList, numList 추가
	public void addCart(String code, Integer num) {
		//codeList에 이미 code에 있는 상품번호가 있는지 검사
		for(int i=0; i < codeList.size(); i++) {
			if(codeList.get(i).equals(code)) {
			//i번째 상품번호와 code 에 있는 상품번호가 같은 경우
			//numList의 i번째 상품의 갯수 + num -> numList에 저장
				Integer n = numList.get(i); //i번째 상품의 기존 갯수
				int sum = n + num; //기존 갯수 + 담은 갯수
				numList.set(i, sum); //i번째 상품의 갯수 바꿔줌
				return; //메서드 종료
			}
		}
		//codeList 다 찾아봤는데 code와 같은 상품번호 없는 경우
		codeList.add(code); numList.add(num);
	}
}
