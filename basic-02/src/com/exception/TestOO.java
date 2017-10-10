package com.exception;

/*
 * 请用java中面向对象的思想用代码描述如下内容：小红（女）有爸爸和妈妈，
 * 爸爸和妈妈分别有自己的爸爸和妈妈。。。，小红的爸爸会做工作A和B，小红的妈妈会做工作C和D。
 * 要求：将上面的情景用Java类来描述，要求自己抽象出接口和对象。
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
		System.out.println("小红爸爸WorkA");
	}

	@Override
	public void WorkB() {
		// TODO Auto-generated method stub
		System.out.println("小红爸爸WorkB");
	}

}

class XiaoHongMother extends People implements Mother {

	XiaoHongMother(String name){
		this.name=name;

	}
	@Override
	public void WorkC() {
		// TODO Auto-generated method stub
		System.out.println("小红妈妈WorkC");
	}

	@Override
	public void WorkD() {
		// TODO Auto-generated method stub
		System.out.println("小红妈妈WorkD");
	}

}

class XiaoHong extends People{

	XiaoHong(String name ,Father father,Mother mother){
		this.father=father;
		this.name=name;
		this.mother=mother;
	}

}
