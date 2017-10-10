package com.exception;

/*
 * ����java����������˼���ô��������������ݣ�С�죨Ů���аְֺ����裬
 * �ְֺ�����ֱ����Լ��İְֺ����衣������С��İְֻ�������A��B��С��������������C��D��
 * Ҫ�󣺽�������龰��Java����������Ҫ���Լ�������ӿںͶ���
 * 
 * */

public class TestOO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XiaoHongFather xf = new XiaoHongFather("xhFather");
		XiaoHongMother xm = new XiaoHongMother("xhMother");
		XiaoHong xh = new XiaoHong("xiaohong", xf, xm);
		
		xh.father.WorkA();
		xh.father.WorkB();
		xh.mother.WorkC();
		xh.mother.WorkD();

	}

}
abstract class People{
	String name=null;
	Father father=null;
	Mother mother=null;
}
interface Father{
	
	void WorkA();
	void WorkB();
}

interface Mother{
	void WorkC();
	void WorkD();
}
class XiaoHongFather extends People implements Father {

	XiaoHongFather(String name){
		this.name=name;
		
	}
	
	@Override
	public void WorkA() {
		// TODO Auto-generated method stub
		System.out.println("С��ְ�WorkA");
	}

	@Override
	public void WorkB() {
		// TODO Auto-generated method stub
		System.out.println("С��ְ�WorkB");
	}
	
}

class XiaoHongMother extends People implements Mother {
	
	XiaoHongMother(String name){
		this.name=name;
		
	}
	@Override
	public void WorkC() {
		// TODO Auto-generated method stub
		System.out.println("С������WorkC");
	}

	@Override
	public void WorkD() {
		// TODO Auto-generated method stub
		System.out.println("С������WorkD");
	}
	
}

class XiaoHong extends People{
	
	XiaoHong(String name ,Father father,Mother mother){
		this.father=father;
		this.name=name;
		this.mother=mother;
	}
	
}
