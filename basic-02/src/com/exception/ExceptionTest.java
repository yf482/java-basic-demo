package com.exception;

public class ExceptionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tercher t  = new Tercher("MrWang");
		try {
			t.prelect();
		} catch (MaoYanException e) {
			// TODO Auto-generated catch block
			System.out.println("ð���ˡ��Ͽ��ж�");
		}
	}

}

class Tercher{
	Computer cm ;
	private String name;
	Tercher (String name ){
		this.name=name;
		cm = new Computer();
	}
	void prelect() throws MaoYanException{
		try {
			cm.run();
		}catch (LanPingException e) {
			System.out.println("������");
			cm.reset();
		}catch(MaoYanException e){
			throw new MaoYanException("ð����");
		}
		System.out.println("������");
	}
	
}

class Computer{
	private  int state =3;
	
	public void run() throws MaoYanException, LanPingException {
		if(state==2)
			throw new LanPingException("������");
		if(state==3)
			throw new MaoYanException("ð����");
		System.out.println("���Կ���");
	}
	public void reset() {
		state =1;
		System.out.println("��������");
	}
}

class LanPingException extends Exception{
	
	LanPingException(String msg){
		super(msg);
	}
}

class MaoYanException extends Exception{
	
	MaoYanException (String msg){
		super(msg);
	}
}
