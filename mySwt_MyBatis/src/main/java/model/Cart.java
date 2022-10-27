package model;

import java.util.ArrayList;

import utility.Crud;
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
				numList.set(i, num);//i��° ��ǰ������ num���� ����
				////DB���� ����
				DAO dao = new DAO();
				Item item = new Item();
				item.setId(id); item.setCode(code);
				item.setNum(num);
				dao.updateCart(item);
				////DB���� ��
				return;//�޼��� ����
			}
		}
	}//��ٱ��Ͽ��� ��ǰ�� ������ �����ϴ� �޼���
	
	public void deleteItem(String code) {
		for(int i=0; i < codeList.size(); i++) {
			if(codeList.get(i).equals(code)) {
				//codeList���� �ش� ��ǰ�� ����
				codeList.remove(i);
				//numList���� �ػ� ��ǰ�� ������ ����
				numList.remove(i);
				////DB���� ����
				Crud crud = new Crud();
				Item item = new Item();
				item.setCode(code);
				item.setId(id);
				crud.deleteCart(item);
				////DB���� ��
				return;
			}
		}
	}//��ٱ��Ͽ��� ��ǰ�� �����ϴ� �޼���
	
	public void addCart(String code, Integer num) {
		for(int i=0; i < codeList.size(); i++) {
			if(codeList.get(i).equals(code)) {
				Integer n = numList.get(i);//i��° ��ǰ�� ����
				int sum = n + num;
				numList.set(i, sum);
				/////DB���� ����
				Item item = new Item();
				Crud crud = new Crud();
				item.setId(id); item.setCode(code);
				item.setNum(sum);
				crud.updateCart(item);
				/////DB���� ��
				return;//�޼��� ����
			}//i��° ��ǰ��ȣ�� code�� �ִ� ��ǰ��ȣ�� ���� ���
		}
		codeList.add(code); numList.add(num);
		////////DB���� ����
		Item item = new Item();
		Crud crud = new Crud();
		int max = crud.getMaxCartSeqno() + 1;
		item.setSeqno(max);//�Ϸù�ȣ ����
		item.setId(id);//���� ����
		item.setCode(code);//��ǰ��ȣ ����
		item.setNum(num);//��ǰ ���� ����
		crud.putCart(item);//DB���̺� ����
		////////DB���� ��
	}
}//��ٱ��� ��ü





