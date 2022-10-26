package model;

import java.util.ArrayList;

import utility.DAO;

public class Cart {
	private ArrayList<String> codeList =
				new ArrayList<String>();
	private ArrayList<Integer> numList =
				new ArrayList<Integer>();
	private String id;

	public ArrayList<String> getCodeList() {
		return codeList;
	}
	public ArrayList<Integer> getNumList() {
		return numList;
	}
	public Cart(String id) {this.id = id;}
	
	public void modifyItem(String code, Integer num) {
		for(int i=0; i < codeList.size(); i++) {
			if(codeList.get(i).equals(code)) {
				numList.set(i, num);//i번째 상품갯수를 num으로 변경
				////DB연동 시작
				DAO dao = new DAO();
				Item item = new Item();
				item.setId(id); item.setCode(code);
				item.setNum(num);
				dao.updateCart(item);
				////DB연동 끝
				return;//메서드 종료
			}
		}
	}//장바구니에서 상품의 갯수를 변경하는 메서드
	
	public void deleteItem(String code) {
		for(int i=0; i < codeList.size(); i++) {
			if(codeList.get(i).equals(code)) {
				//codeList에서 해당 상품을 삭제
				codeList.remove(i);
				//numList에서 해상 상품의 갯수를 삭제
				numList.remove(i);
				////DB연동 시작
				DAO dao = new DAO();
				dao.deleteCart(code, id);
				////DB연동 끝
				return;
			}
		}
	}//장바구니에서 상품을 삭제하는 메서드
	
	public void addCart(String code, Integer num) {
		for(int i=0; i < codeList.size(); i++) {
			if(codeList.get(i).equals(code)) {
				Integer n = numList.get(i);//i번째 상품의 갯수
				int sum = n + num;
				numList.set(i, sum);
				/////DB연동 시작
				Item item = new Item();
				DAO dao = new DAO();
				item.setId(id); item.setCode(code);
				item.setNum(sum);
				dao.updateCart(item);
				/////DB연동 끝
				return;//메서드 종료
			}//i번째 상품번호와 code에 있는 상품번호가 같은 경우
		}
		codeList.add(code); numList.add(num);
		////////DB연동 시작
		Item item = new Item();
		DAO dao = new DAO();
		int max = dao.getMaxCartSeqno() + 1;
		item.setSeqno(max);//일련번호 설정
		item.setId(id);//계정 설정
		item.setCode(code);//상품번호 설정
		item.setNum(num);//상품 갯수 설정
		dao.putCart(item);//DB테이블에 삽입
		////////DB연동 끝
	}
}//장바구니 객체





